import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * A dodge mini game that challenges players to dodge all bombs, 
 * which becomes more challenging over time
 * 
 * @author Kevin Wang
 * @version January 2022
 */
public class BombsAway extends MiniGame
{
    //Timer for the program to track seconds
    private SimpleTimer timer = new SimpleTimer();
    
    //Counter for the player to see
    private Counter timeCount = new Counter();
    
    //The game lasts for 30 seconds
    private int time = 30; 
    
    //Timer for the program to know when the game has run long enough
    private SimpleTimer levelTimer = new SimpleTimer();
    
    //Timer for the program to know when to add bombs
    private SimpleTimer bombTimer = new SimpleTimer();
    
    //Difficulty delay, delay in between adding more bombs to world
    private int delay = 0;
    
    //Initializing the background image for the world
    private GreenfootImage background = new GreenfootImage("BombsAwayBKG.png");

    /**
     * Constructor for objects of class BombsAway - prepares players, time countdown,
     * music and background   
     */
    public BombsAway()
    {
        //Initialize a new world of 1000 x 600 size with cell size of 1 pixel and with Human players being drawn before NPC players
        super();

        //Set up players and their locations
        setupPlayers(3f);
        int pos=200, distance=200;
        for (Player p : players) {
            addObject(p, pos, 470);
            pos += distance;
        }
        
        //Add a timer so players know how much time is left
        addObject(timeCount,300,90);
        timeCount.setValue(time); 
        levelTimer.mark();
        
        //Set the image to the bombs away background
        this.setBackground(background);

        //Set the mainsound to the Ducking and Dodging OST from Mario Party 1
        //Play mainsound immediately
        MainSound.setSound(new GreenfootSound("Mario Party 1 OST - Ducking and Dodging (Mini-Game).mp3"));
        MainSound.play();
    }

    /**
     * Method that tracks time and increase the difficulty over time
     * Updates world when reached time limit or no player is left
     */
    public void act() {
        //Remove one second from the timer the player sees every second
        if (timer.millisElapsed() > 1000) { 
            timeCount.add(-1);
            timer.mark();
        }
        
        //Increase the difficulty at an increasing rate, starting slow but building up
        if (bombTimer.millisElapsed() > delay) {
            float difficulty = (levelTimer.millisElapsed() / 10000) + 1;
            delay = (int) Utils.random(1000 / difficulty, 3000 / difficulty);
            bombTimer.mark();
            addObject(new Bomb(2f + difficulty), Utils.random(1000), 0); // denser bombs
        }
        
        //If the game is over or everyone has been defeated, end the game and return to the WorldMap
        if (levelTimer.millisElapsed() >= time * 1000 || getObjects(Player.class).size() == 0) {
            updateWorld();
        }
    }

    /**
     * Method to time passed 
     * 
     * @return levelTimer.millisElapsed()
     */
    public int getTime() {
        return levelTimer.millisElapsed();
    }

    /**
     * Method to get game name
     * 
     * @return game name - BombsAway
     */
    public String toString() {
        return "BombsAway";
    }
}
