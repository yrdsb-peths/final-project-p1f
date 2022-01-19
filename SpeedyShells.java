import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpeedyShells here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpeedyShells extends MiniGame
{

    private int lDelay, rDelay;
    private SimpleTimer lTimer, rTimer;
    private static final int groundLevel = 600 - 110;
    private SimpleTimer timer;
    private SimpleTimer gameOverDelay;
    
    /**
     * Constructor for objects of class SpeedyShells.
     * 
     */
    public SpeedyShells() {
        setBackground("shellbg.png");
        lDelay = Utils.random(2000, 5000);
        rDelay = Utils.random(2000, 5000);
        lTimer = new SimpleTimer();
        rTimer = new SimpleTimer();
        timer = new SimpleTimer();
        timer.mark();

        addObject(new HumanPlayer("Mario", 3f), 500, groundLevel);
    }

    public void act() {
        if (lTimer.millisElapsed() > lDelay) {
            lTimer.mark();
            lDelay = Utils.random(2000, 5000);
            addObject(new Shell(1), 0, 0);
        }
        if (rTimer.millisElapsed() > rDelay) {
            rTimer.mark();
            rDelay = Utils.random(2000, 5000);
            addObject(new Shell(-1), 0, 0);
        }
        if (timer.millisElapsed() >= 30000 || getObjects(Player.class).size() == 0) {
            gameOverDelay = new SimpleTimer();
            gameOverDelay.mark();
        }
        if (gameOverDelay != null && gameOverDelay.millisElapsed() >= 3000) {
            updateWorld();
        }
    }

    public int getTime() {
        return timer.millisElapsed();
    }
    
    public static int getGround() {
        return groundLevel;
    }
}
