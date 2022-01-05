import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class MemoryMatch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MemoryMatch extends MiniGame
{
    private SimpleTimer tim = new SimpleTimer();
    private Counter timeCount = new Counter();
    private int time = 60;
    Label coinLabel;
    int coinCount;
    /**
     * Constructor for objects of class MemoryMatch.
     * 
     */
    public MemoryMatch()
    {
        prepare();
        prepareCards();
    }
    
    public void prepare() {
        addObject(timeCount,90,50);
        timeCount.setValue(time); 
        
        //bgm
        
        addObject(new Coin(), 80, 130);
        coinLabel = new Label(coinCount,50);
        addObject(coinLabel,100,200);
        
        Player player = new Player();
        addObject(player, 110,280);
    }
    
    public void prepareCards() {
        addObject(new Card(1), 225,120);
        addObject(new Card(3), 380,120);
        addObject(new Card(2), 535,120);
        addObject(new Card(2), 690,120);

    }
    
    public void act() {
        timeCountDown();
    }
    
    /**
     * Called every act; updates the time counter every second.
     * If time limit is reached, return to main world.
     */
    public void timeCountDown()
    {    
        if(tim.millisElapsed() > 1000) { //time count down every second
            timeCount.add(-1);
            tim.mark();
        }
        
        if (tim.millisElapsed() * 1000 == timeCount.getValue()) { //if time limit is reached
            Greenfoot.setWorld(new WorldMap()); 
        }

    }
    
    public void updateCoins() {
        removeObject(coinLabel);
        coinLabel = new Label(coinCount,50);
        addObject(coinLabel,60,140);
    }
}
