import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DontLook here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DontLook extends MiniGame
{
    private SimpleTimer tim = new SimpleTimer();
    private Counter timeCount = new Counter();
    private int time = 4;
    Label coinLabel;
    int coinCount;
    int lv;
    Arrow arrow;
    Player player;
    /**
     * Constructor for objects of class DontLook.
     * 
     */
    public DontLook() {
        prepare();
    }

    public void prepare() {
        addObject(timeCount,90,50);
        timeCount.setValue(time); 

        addObject(new Coins(), 180, 50);
        coinLabel = new Label(coinCount,50);
        addObject(coinLabel,220,50);

        player = new Player();
        addObject(player, getWidth()/2,getHeight()/2);

        arrow = new Arrow();
        addObject(arrow, getWidth()/2, 200);
    }

    public void act() {
        timeCountDown();
        if (lv == 6) {
            Greenfoot.setWorld(new WorldMap());
        }
    }

    /**
     * Called every act; updates the time counter every second.
     * If time limit is reached...
     */
    public void timeCountDown() {    
        if(tim.millisElapsed() > 1000) { //time count down every second
            Greenfoot.playSound("Second.wav"); 
            timeCount.add(-1);
            tim.mark();
        }
        if (tim.millisElapsed() * 1000 == timeCount.getValue()) { //if time limit is reached
            lv++;
            checkMatch();
            arrow.setArrow();
            Greenfoot.playSound("Beep.wav");
            timeCount.setValue(time); 
        }
    }

    public void updateCoins() {
        removeObject(coinLabel);
        coinLabel = new Label(coinCount,50);
        addObject(coinLabel,60,140);
    }

    public void checkMatch() {
        if (player.checkPlayer() != arrow.arrowType) {
            coinCount++;
            updateCoins();
        } else {
            Greenfoot.playSound("Bad.wav");
        }
    }
}
