import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo) 
import java.util.ArrayList;
/**
 * Write a description of class MiniGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiniGame extends World
{
    
    protected ArrayList<Player> players;
    /**
     * Constructor for objects of class MiniGame.
     * 
     */
    public MiniGame() {
        super(1000, 600, 1);
        if (WorldMap.instance == null) {
            WorldMap.instance = new WorldMap();
        }
    }

    protected void setupPlayers(float scale) {
        players = new ArrayList<Player>();
        ArrayList<MapCharacter> ref = WorldMap.instance.getPlayers();
        for (int i=0;i<ref.size();i++) { 
            if (i==0) {
                players.add(new HumanPlayer(ref.get(i).getName(), scale));
            } else {
                players.add(new NPCPlayer(ref.get(i).getName(), scale));
            }
        }
    }

    public String toString() {
        return "Unnamed MiniGame";
    }

    /**
     * update world scores
     */
    protected void updateWorld() {
        MainSound.stop();
        WorldMap.instance.removeTutorial();
        // MainSound.setSound(new GreenfootSound("world map song.mp3"));
        Utils.sort(players);
        for (int i=0;i<players.size();i++) {
            players.get(i).setScore(6 - (2*i));
        }
        WorldMap.instance.addScores(players);
        WorldMap.instance.startSound();
        Greenfoot.setWorld(WorldMap.instance);
    }
}
