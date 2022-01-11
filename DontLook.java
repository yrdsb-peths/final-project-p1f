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
    
    Arrow arrow;
    /**
     * Constructor for objects of class DontLook.
     * 
     */
    public DontLook()
    {
        prepare();
    }
    public void prepare() {
        addObject(timeCount,90,50);
        timeCount.setValue(time); 
        
        addObject(new Coins(), 180, 50);
        coinLabel = new Label(coinCount,50);
        addObject(coinLabel,220,50);
        
        Player player = new Player();
        addObject(player, getWidth()/2,getHeight()/2);
        
        arrow = new Arrow();
        addObject(arrow, getWidth()/2, 200);
    }
    public void act() {
        timeCountDown();
    }
    /**
     * Called every act; updates the time counter every second.
     * If time limit is reached...
     */
    public void timeCountDown()
    {    
        if(tim.millisElapsed() > 1000) { //time count down every second
            Greenfoot.playSound("Second.wav");
            timeCount.add(-1);
            tim.mark();
        }
        
        if (tim.millisElapsed() * 1000 == timeCount.getValue()) { //if time limit is reached
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
}
