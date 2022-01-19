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
    private int difficulty;
    private Counter timeCount;
    
    /**
     * Constructor for objects of class SpeedyShells.
     * 
     */
    public SpeedyShells() {
        super();

        setupPlayers(3f);
        int pos=350, distance=100;
        for (Player p : players) {
            addObject(p, pos, 0);
            pos += distance;
        }
        
        setBackground("shellbg.png");
        lDelay = Utils.random(2000, 5000);
        rDelay = lDelay + Utils.random(2000, 5000);
        lTimer = new SimpleTimer();
        rTimer = new SimpleTimer();
        timer = new SimpleTimer();
        timer.mark(); 
        
        timeCount = new Counter();
        addObject(timeCount,150,90);
        timeCount.setValue(30);
        
        difficulty = 0;

        MainSound.setSound(new GreenfootSound("Shell Shock Deluxe.wav"));
        MainSound.play();
    }

    public void act() {
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
    }

    public int getTime() {
        return timer.millisElapsed();
    }
    
    public static int getGround() {
        return groundLevel;
    }
}
