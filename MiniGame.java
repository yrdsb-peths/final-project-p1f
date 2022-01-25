import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo) 
import java.util.ArrayList;
/**
 * MiniGame Superclass - All mini-game classes inherit from it, contains basic functions 
 * of each game.
 * 
 * @author Eric Zhang
 * @version January 2022
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
        setPaintOrder(HumanPlayer.class, NPCPlayer.class);
    }

    /**
     * Method to set up all players - 1 human player and 3 npc players
     * 
     * @param scale Scale of players added
     */
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

    private boolean isFirstAct = true;
    public void act() {
        if (isFirstAct) {
            firstAct();
            isFirstAct = false;
        }
    }
    
    /**
     * Will be called in first act method (meant to be overridden)
     */
    protected void firstAct() {
        
    }
    
    /**
     * Method to get game name
     * 
     * @return game name - Unnamed MiniGame
     */
    public String toString() {
        return "Unnamed MiniGame";
    }

    /**
     * Method that sorts player scores and update world scores
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
