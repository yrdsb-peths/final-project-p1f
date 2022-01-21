import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A dodge mini game that challenges players to dodge all shells, 
 * and becomes more challenging over time
 * 
 * @author Eric Zhang
 * @version January 2022
 */
public class SpeedyShells extends MiniGame
{
    private int lDelay, rDelay;
    private SimpleTimer lTimer, rTimer;
    private static final int groundLevel = 600 - 110;
    private SimpleTimer timer;
    private SimpleTimer gameOverDelay;
    private int difficulty;
    private Counter timeCount;
    
    /**
     * Constructor for objects of class SpeedyShells - prepares background, difficulty and music.
     * 
     */
    public SpeedyShells() {
        super(); 
        setBackground("shellbg.png"); 
        
        difficulty = 0;

        MainSound.setSound(new GreenfootSound("Shell Shock Deluxe.wav"));
        MainSound.play();
    }
    
    /**
     * Method that sets up players and their locations, time counter, various timers, and 
     * various delay control variables
     */
    protected void firstAct() {
        setupPlayers(3f);
        int pos=350, distance=100;
        for (Player p : players) {
            addObject(p, pos, 0);
            pos += distance; 
        }
        
        timeCount = new Counter();
        addObject(timeCount,150,90);
        timeCount.setValue(30);
        
        lDelay = Utils.random(2000, 5000);
        rDelay = lDelay + Utils.random(2000, 5000);
        lTimer = new SimpleTimer();
        rTimer = new SimpleTimer();
        timer = new SimpleTimer();
        timer.mark(); 
    }

    /**
     * Method that increases the difficulty level based on 2 timers, and tracks the gaming time based on 2 other timers
     * End the game and updates world when time limit is reached or all players are eliminated,
     */
    public void act() {
        super.act();
        if (lTimer.millisElapsed() > lDelay) {
            lTimer.mark();
            lDelay = Utils.random(2000, 10000 - (difficulty / 2));
            addObject(new Shell(1), 0, 0);
        }
        if (rTimer.millisElapsed() > rDelay) {
            rTimer.mark();
            rDelay = Utils.random(2000, 10000 - (difficulty / 2));
            addObject(new Shell(-1), 0, 0);
        }
        if (gameOverDelay == null) {
            if (timer.millisElapsed() >= 30000 || getObjects(Player.class).size() == 0) { 
                gameOverDelay = new SimpleTimer();
                gameOverDelay.mark();
            }
        } else {
            if (gameOverDelay.millisElapsed() >= 3000)
                updateWorld();
        }
        difficulty++;

        timeCount.setValue((30000 - timer.millisElapsed()) / 1000);
        if (timeCount.getValue() <= 0) {
            timeCount.setValue(0);
        }
    }

    /**
     * Method to get time
     * 
     * @return timer.millisElapsed()
     */
    public int getTime() {
        return timer.millisElapsed();
    }
    
    /**
     * Method to get ground level
     * 
     * @return groundLevel
     */
    public static int getGround() {
        return groundLevel;
    }

    /**
     * Method to get game name
     * 
     * @return game name - SpeedyShells
     */
    public String toString() {
        return "SpeedyShells";
    }
}
