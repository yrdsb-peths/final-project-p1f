import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class WorldMap here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class WorldMap extends World
{
    
    ArrayList<MapNode> path;
    MapCharacter[] players;
    
    public WorldMap() {
        super(1000, 600, 1);
        
        setupPath();
        
        players = new MapCharacter[2];
        players[0] = new MapPlayer();
        players[1] = new MapNPC();
        
        for (Actor p : players) {
            addObject(p, path.get(0).getX(), path.get(0).getY());
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
        // simple 4 node path for now
        path.add(new GoodNode(100, 100));
        path.add(new GameNode(100, 500));
        path.add(new BadNode(500, 500));
        path.add(new GameNode(500, 100));
    }
}
