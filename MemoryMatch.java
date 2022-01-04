import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap; 
import java.util.Random;
/**
 * Write a description of class MemoryMatch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MemoryMatch extends World
{
    private SimpleTimer tim = new SimpleTimer();
    private Counter timeCount = new Counter();
    private int time = 60;
    Label coinLabel;
    int coinCount;
    HashMap<String, Integer> map;
    /**
     * Constructor for objects of class MemoryMatch.
     * 
     */
    public MemoryMatch()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepare();
        prepareCards();
    }
    
    public void prepare() {
        addObject(timeCount,90,50);
        timeCount.setValue(time); 
        
        GreenfootSound bgm = new GreenfootSound("MemoryMatchBGM.mp3");
        //bgm.playLoop(); 
        
        addObject(new Coins(), 80, 130);
        coinLabel = new Label(coinCount,50);
        addObject(coinLabel,100,200);
        
        Player player = new Player();
        addObject(player, 110,280);
    }
    
    public void prepareCards() {
        map = new HashMap<String, Integer>();
        addObject(new Cards1(), 225,120);
        addObject(new Cards2(), 380,120);
        addObject(new Cards3(), 535,120);
        addObject(new Cards4(), 690,120);

        //generate pairs of value for cards, there def should be a better way tho
        int[] cardVal = {1,1,2,2};
        shuffle(cardVal);
        for (int i = 1; i <= cardVal.length; i++) {
            map.put("Card" + i, cardVal[i-1]); //pair card with a value from the arr
        }
    }
    
    public void shuffle(int[] array){
        Random rand = new Random();

        for (int i = array.length-1; i > 0; i--) {
            int j = rand.nextInt(i+1); // Pick a random index from 0 to i

            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
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
            Greenfoot.setWorld(new MyWorld()); 
        }

    }
}
