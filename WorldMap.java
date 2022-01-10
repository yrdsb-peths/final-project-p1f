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
    ArrayList<MapNode> path;
    ArrayList<MapCharacter> playersRef;
    Queue<MapCharacter> players;
    Dice dice;
    MapCharacter currentPlayer;
    int rounds = 15, round = 0;
    
    /**
     * WorldMap Constructor
     *
     */
    public WorldMap() {
        super(1000, 600, 1);
        instance = this;
        setBackground(new GreenfootImage("WorldMap.png"));
        setupPath();
        
        playersRef = new ArrayList<MapCharacter>();
        playersRef.add(new MapPlayer());
        playersRef.add(new MapNPC());
        
        for (Actor p : playersRef) {
            addObject(p, path.get(0).getX(), path.get(0).getY());
        }
        
        players = new LinkedList<MapCharacter>();
        currentPlayer = null; 
        
        dice = new Dice(200, 500);
    }
    
    public void act() {
        dice.rollResult();
        if (players.size() == 0) {
            if (round == rounds) {
                // who wins
                return;
            } else {
                // reinitialize queue
                for (MapCharacter p : playersRef)
                    players.add(p);
                round++;
                // +1 minigame every round ?
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
        path.add(new EmptyNode(340, 70));
        path.add(new GoodNode(340, 250));
        path.add(new GameNode(340, 375));
        path.add(new EmptyNode(340, 415));
        path.add(new BadNode(525, 415));
        path.add(new GoodNode(660, 415));
        path.add(new GoodNode(800, 415));
        path.add(new EmptyNode(910, 415));
        path.add(new GameNode(910, 365));
        path.add(new BadNode(910, 260));
        path.add(new EmptyNode(870, 260));
        path.add(new GoodNode(870, 150));
        path.add(new EmptyNode(870, 70));
        path.add(new GoodNode(790, 10));
        path.add(new GameNode(630, 10));
        path.add(new BadNode(490, 10));
    }
}
