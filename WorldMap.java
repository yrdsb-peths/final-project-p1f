import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Write a description of class WorldMap here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class WorldMap extends World
{
    public static WorldMap instance;
    
    private ArrayList<MapNode> path;
    private ArrayList<MapCharacter> playersRef;
    private Queue<MapCharacter> players;
    private DicePopUp dicePopUp;
    private MapCharacter player; // current player
    private int rounds = 15+1;
    private Label roundsText;
    private SimpleTimer timer;
     
    /**
     * WorldMap Constructor
     *
     */
    public WorldMap() {
        super(1000, 600, 1); 
        instance = this;
        setBackground(new GreenfootImage("world_map.png"));
        setupPath();
        
        playersRef = new ArrayList<MapCharacter>();
        playersRef.add(new MapPlayer("Mario"));
        playersRef.add(new MapNPC("Luigi"));
        playersRef.add(new MapNPC("Yellow"));
        playersRef.add(new MapNPC("Purple"));
        
        for (Actor p : playersRef) {
            addObject(p, path.get(0).getX(), path.get(0).getY()-20);
        }
        
        players = new LinkedList<MapCharacter>();
        player = null;
         
        timer = new SimpleTimer();
        timer.mark();
        
        roundsText = new Label(String.valueOf(rounds) + " Rounds Left", 50);
        addObject(roundsText, 155, 575);
        
    }
    
    boolean test = false;
    public void act() { 
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) System.out.println(mouse.getX() + " " + mouse.getY());
        if (test) return;

        if (player==null && players.size() == 0) {
            if (rounds == 0) {
                // new winscreen(winning player)
                return;
            } else {
                // reinitialize queue
                for (MapCharacter p : playersRef) {
                    players.add(p);
                }
                rounds--;
                roundsText.setValue(String.valueOf(rounds) + " Rounds Left");
                // play minigame every round ?
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

    /**
     * return instance of a random minigame
     */
    private MiniGame getRandomMiniGame() {
        String[] minigames = { "MemoryMatch" };
        String name = minigames[Utils.random(minigames.length-1)];
        MiniGame game = new MiniGame();
        
        switch (name) {
            case "MemoryMatch": game = new MemoryMatch(); break;
            // add other minigames here
        }
        
        return game;
    }
    
    /**
     * create all nodes in path
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
        path.add(new GoodNode(140, 100)); // shop node
        path.add(new GoodNode(140, 280));
        /*
        // old map path
        path.add(new EmptyNode(335, 70));
        path.add(new GoodNode(340, 120));
        path.add(new GoodNode(340, 250));
        path.add(new GameNode(340, 375));
        path.add(new EmptyNode(340, 415));
        path.add(new BadNode(525, 415));
        path.add(new GoodNode(660, 415));
        path.add(new GoodNode(800, 415));
        path.add(new EmptyNode(915, 415));
        path.add(new GameNode(910, 365));
        path.add(new BadNode(910, 260));
        path.add(new EmptyNode(870, 260));
        path.add(new GoodNode(870, 150));
        path.add(new EmptyNode(870, 70));
        path.add(new GoodNode(790, 10));
        path.add(new GameNode(630, 10));
        path.add(new BadNode(490, 10));
        */
    }
    
    public ArrayList<MapNode> getPath() {
        return this.path;
    }
    
    public SimpleTimer getTimer() {
        return this.timer; 
    }
}
