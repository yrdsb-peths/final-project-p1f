import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BombsAway here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BombsAway extends MiniGame
{
    private SimpleTimer timer = new SimpleTimer();
    private Counter timeCount = new Counter();
    private int time = 30;
    private SimpleTimer levelTimer = new SimpleTimer();
    private SimpleTimer bombTimer = new SimpleTimer();
    private int delay = 0;

    private GreenfootImage background = new GreenfootImage("BombsAwayBKG.png");

    /**
     * Constructor for objects of class BombsAway.
     * 
     */
    public BombsAway()
    {
        super();

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

    public void act() {
        if (timer.millisElapsed() > 1000) { //count down one second
            timeCount.add(-1);
            timer.mark();
        }
        if (bombTimer.millisElapsed() > delay) {
            float difficulty = (levelTimer.millisElapsed() / 10000) + 1;
            delay = (int) Utils.random(1000 / difficulty, 3000 / difficulty);
            bombTimer.mark();
            addObject(new Bomb(2f + difficulty), Utils.random(1000), 0);
        }
        if (levelTimer.millisElapsed() >= time * 1000) {
            updateWorld();
        }
    }

    public int getTime() {
        return levelTimer.millisElapsed();
    }

    public String toString() {
        return "BombsAway";
    }

}
