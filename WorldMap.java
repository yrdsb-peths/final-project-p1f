import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Write a description of class WorldMap here.
 * 
 * @author Eric Zhang
 * @version January 2022
 */
public class WorldMap extends World
{
    public static WorldMap instance;
    
    private ArrayList<MapNode> path;
    private ArrayList<MapCharacter> playersRef;
    private ArrayList<Label> coinLabels;
    private Queue<MapCharacter> players;
    private DicePopUp dicePopUp;
    private TutorialPopUp tutorialPopUp;
    private ScorePopUp scorePopUp;
    private MapCharacter player; // current player
    private int rounds, roundsLeft;
    private Label roundsText;
    private SimpleTimer timer;
     
    /**
     * WorldMap Constructor - sets up timer, rounds, players and path for players to walk
     *
     */
    public WorldMap() {
        super(1000, 600, 1);
        instance = this; 

        setupPath();
        
        //Uses sprites based on input name
        playersRef = new ArrayList<MapCharacter>();
        //playersRef.add(new MapPlayer("Mario"));
        //playersRef.add(new MapNPC("Luigi"));
        
        if (CharSelectChar.playerChoice != null) {
            playersRef.add(new MapPlayer(CharSelectChar.playerChoice));
        } else {
            playersRef.add(new MapPlayer("Mario"));
        }
        for (int i=0;i<3;i++) {
            while (true) {
                int r = Utils.random(1, 6);
                MapNPC p;
                switch (r) {
                    case 1: p = new MapNPC("Mario"); break;
                    case 2: p = new MapNPC("Luigi"); break;
                    case 3: p = new MapNPC("KoopaRed"); break;
                    case 4: p = new MapNPC("KoopaYellow"); break;
                    case 5: p = new MapNPC("KoopaGreen"); break;
                    case 6: p = new MapNPC("KoopaPurple"); break;
                    case 7: p = new MapNPC("KoopaSilver"); break;
                    default: p = new MapNPC("Mario"); break;
                }
                boolean duplicate = false;;
                for (MapCharacter player : playersRef) {
                    if (player.getName().equals(p.getName())) {
                        duplicate = true;
                        break;
                    }
                }
                if (!duplicate) {
                    playersRef.add(p);
                    break;
                }
            }
        }
        
        for (MapCharacter p : playersRef) {
            addObject(p, path.get(0).getX(), path.get(0).getY()-60);
        }
        
        assert playersRef.size()==4 : "Require 4 and only 4 players";
        
        players = new LinkedList<MapCharacter>();
        player = null;
         
        timer = new SimpleTimer();
        timer.mark();
        
        rounds = 10;
        rounds++;
        roundsLeft = rounds;
        roundsText = new Label(String.valueOf(roundsLeft) + " Rounds Left", 50);
        addObject(roundsText, 155, 575);
        
        drawWorld();
        startSound();
    }
    
    boolean test=false;
    /**
     * Method that controls dice all components of the map, including players, rounds, dice,
     * and pop-ups
     */
    public void act() {
        if (test) return;

        if (tutorialPopUp != null) {
            return;
        }
        if (scorePopUp != null) {
            return;
        }
        if (roundsLeft == 0) { // game ends
            Greenfoot.setWorld(new GameOverScreen(playersRef));
            return;
        }

        if (player==null && players.size() == 0) {
            // reinitialize queue
            for (MapCharacter p : playersRef) {
                players.add(p);
            }
            roundsLeft--;
            roundsText.setValue(String.valueOf(roundsLeft) + " Rounds Left"); 
            // should make tutoiral popup -> minigame
            // eg new TutorialPopUp(minigame name) 
            if (rounds!=roundsLeft+1) {
                tutorialPopUp = new TutorialPopUp(getRandomMiniGame());
                addObject(tutorialPopUp, 0, 0);
                // Greenfoot.setWorld(getRandomMiniGame());
            }
        }
        if (player == null) {
            player = players.remove();
        } 
        // boolean finishedTurn = player.takeTurn();
        // if finished, init next player
        
        // take turn code (put in MapPlayer and MapNPC)
        if (player.getState() == MapCharacter.State.DICE) {
            if (dicePopUp.isClosed()) {
                int steps = dicePopUp.rollResult();
                player.setSteps(steps);
                player.setState(MapCharacter.State.MOVE);
                timer.mark();
            }
        } else if (player.getState() == MapCharacter.State.MOVE) {
            // if finished path
            if (player.followPath()) {
                timer.mark();
                player.setState(MapCharacter.State.IDLE);
                player = null;
            }
        } else {
            // player.dice()
            // maybe declare which player's turn it is
            if (timer.millisElapsed() > 1000) {
                player.setState(MapCharacter.State.DICE);
                dicePopUp = new DicePopUp(player);
                addObject(dicePopUp, 0, 0);
            }
        }
    }

    private MiniGame prevGame;
    /**
     * Method that returns instance of a random minigame
     */
    private MiniGame getRandomMiniGame() {
        MiniGame game;
        while (true) {
            int r = Utils.random(1, 5);
            switch (r) {
                case 1: game = new MemoryMatch(); break;
                case 2: game = new Look(); break;
                case 3: game = new BombsAway(); break;
                case 4: game = new SpeedyShells(); break;
                case 5: game = new SamuelSays(); break;
                default: game = new MemoryMatch(); break;
                // add other minigames here
            }
            if (prevGame == null || prevGame.getClass() != game.getClass()) {
                break;
            }
        }
        prevGame = game;
        
        return game;
    }
    
    /**
     * Method that adds score to players
     * 
     * @param addedCoins list of coins that will be added
     */
    public void addScores(ArrayList<Player> addedCoins) {
        scorePopUp = new ScorePopUp(playersRef, addedCoins);
        addObject(scorePopUp, 0, 0);
        updateCoinLabels();
    }

    /**
     * Method that updates the coin labels of players
     */
    public void updateCoinLabels() {
        for (int i=0;i<coinLabels.size();i++) {
            String v = String.valueOf(playersRef.get(i).getCoins());
            coinLabels.get(i).setValue(v);
        }
    }

    /**
     * Method that creates all nodes in path
     */
    private void setupPath() {
        path = new ArrayList<MapNode>();
        path.add(new GoodNode(140, 460)); // start node
        path.add(new BadNode(315, 460));
        path.add(new GoodNode(500, 460));
        path.add(new GoodNode(500, 280));
        path.add(new BadNode(680, 280));
        path.add(new GoodNode(680, 460));
        path.add(new GoodNode(865, 460));
        path.add(new GoodNode(865, 280));
        path.add(new GoodNode(865, 100));
        path.add(new GoodNode(680, 100));
        path.add(new BadNode(500, 100));
        path.add(new GoodNode(315, 100));
        path.add(new SuperNode(140, 100)); // top left
        path.add(new GoodNode(140, 280));
    }

    /**
     * Method that draws the world, players and players'coins
     */
    private void drawWorld() {
        GreenfootImage img = new GreenfootImage("world_map.png");
        coinLabels = new ArrayList<Label>();
        for (int i=0;i<4;i++) {
            img.drawImage(playersRef.get(i).getRightImage(), 150 + i*200, 5);
            Label l = new Label(String.valueOf(playersRef.get(i).getCoins()), 50);
            coinLabels.add(l);
            addObject(l, 220 + i*200, 30);
        }
        setBackground(img);
    }
    
    /**
     * Method that plays background music
     */
    public void startSound() {
        MainSound.setSound(new GreenfootSound("MainTheme.wav"));
        MainSound.play();
    }

    public ArrayList<MapCharacter> getPlayers() {
        return playersRef;
    }

    public ArrayList<MapNode> getPath() {
        return this.path;
    }
    
    public SimpleTimer getTimer() {
        return this.timer; 
    }

    public void removeTutorial() {
        tutorialPopUp = null;
    }

    public void removeScorePopUp() {
        scorePopUp = null;
    }
}
