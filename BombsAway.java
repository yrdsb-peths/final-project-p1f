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
    private SimpleTimer timer = new SimpleTimer();
    private Counter timeCount = new Counter();
    private int time = 30; // time limit of 30s
    private SimpleTimer levelTimer = new SimpleTimer();
    private SimpleTimer bombTimer = new SimpleTimer();
    private int delay = 0;
    private GreenfootImage background = new GreenfootImage("BombsAwayBKG.png");

    /**
     * Constructor for objects of class BombsAway - prepares players, time countdown,
     * music and background   
     */
    public BombsAway()
    {
        super();

        // set up players and their locations
        setupPlayers(3f);
        int pos=200, distance=200;
        for (Player p : players) {
            addObject(p, pos, 470);
            pos += distance;
        }

        addObject(timeCount,300,90);
        timeCount.setValue(time); 
        levelTimer.mark();

        this.setBackground(background);

        MainSound.setSound(new GreenfootSound("Mario Party 1 OST - Ducking and Dodging (Mini-Game).mp3"));
        MainSound.play();
    }

    /**
     * Method that tracks time and increase the difficulty over time
     * Updates world when reached time limit or no player is left
     */
    public void act() {
        if (timer.millisElapsed() > 1000) { // time count down every second
            timeCount.add(-1);
            timer.mark();
        }
        if (bombTimer.millisElapsed() > delay) {
            float difficulty = (levelTimer.millisElapsed() / 10000) + 1;
            delay = (int) Utils.random(1000 / difficulty, 3000 / difficulty);
            bombTimer.mark();
            addObject(new Bomb(2f + difficulty), Utils.random(1000), 0); // denser bombs
        }
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
