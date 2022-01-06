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
        
        Vector2[][] positions = new Vector2[4][3];
        for (int i=0;i<4;i++) {
            for (int j=0;j<3;j++) {
                int x = i*160 + 100;
                int y = j*160 + 100;
                positions[i][j] = new Vector2(x,y);
            }
        }
        
        for (int i=1;i<=3;i++) {
            int iX = Utils.random(3);
            int iY = Utils.random(2);
            Vector2 pos = positions[iX][iY];
            addObject(new Card(i), pos.getX(), pos.getY()); 
        } 
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
