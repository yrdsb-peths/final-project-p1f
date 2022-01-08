import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class MemoryMatch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 * Need: card flip delay
 */
public class MemoryMatch extends MiniGame
{
    private SimpleTimer tim = new SimpleTimer();
    private Counter timeCount = new Counter();
    private int gameTime = 60;
    private Label coinLabel;
    int coinCount;
    GreenfootSound bgm = new GreenfootSound("MemoryMatchBGM.mp3");
    
    private SimpleTimer winTim = new SimpleTimer();
    private Counter winTimeCount = new Counter();
    private int waitTime = 5;
    private boolean wait;
    /**
     * Constructor for objects of class MemoryMatch.
     * 
     */
    public MemoryMatch() {
        prepare();
        prepareCards();
        addObject(getObjects(Card.class).get(0).cdTimeCount, 40, 15); // to be removed later
    }

    public void prepare() {
        addObject(timeCount,100,65);
        timeCount.setValue(gameTime); 
        winTimeCount.setValue(waitTime);

        //bgm.play();

        addObject(new Coin(), 220, 70);
        coinLabel = new Label(coinCount,50);
        addObject(coinLabel,290,70);
        

        Player player = new Player();
        addObject(player, 80,340);
    }

    public void prepareCards() {
        int[] cardVal = {1,1,2,2,3,3,3,3,4,4,5,5};
        shuffle(cardVal);
        int i = 0;
        for (int x=100; x<=900; x+=155) {
            for (int y=200; y<=500; y+=290) {
                addObject(new Card(cardVal[i]), x, y);
                i++;
            }
        }

        /*
        Vector2[][] positions = new Vector2[4][3];
        for (int i=0;i<4;i++) {
        for (int j=0;j<3;j++) {
        int x = i*160 + 200;
        int y = j*160 + 100;
        positions[i][j] = new Vector2(x,y);
        }
        }

        for (int i=1;i<=3;i++) {
        int iX = Utils.random(3);
        int iY = Utils.random(2);
        Vector2 pos = positions[iX][iY];
        addObject(new Card(i), pos.getX(), pos.getY()); 
        } */
    }

    public void shuffle(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            int j = Greenfoot.getRandomNumber(arr.length - i) + i;

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public void act() {
        timeCountDown();
        waitTimeCountDown();
        checkCoin();    
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
    
    public void waitTimeCountDown() {
        if (wait) {
            if(winTim.millisElapsed() > 1000) { //time count down every second
                winTimeCount.add(-1);
                winTim.mark();
            }
    
            if (winTim.millisElapsed() * 1000 == winTimeCount.getValue()) { //if time limit is reached
                Greenfoot.setWorld(new WorldMap()); 
                wait= false;
            }
        }
    }
    
    public void checkCoin() {
        if (coinCount == 6) {
            Greenfoot.playSound("IWin.wav");
            bgm.stop();
            wait = true;
            coinCount++; //so the method doesn't run o&o again, not good tho
        }
    }

    public void updateCoins() {
        removeObject(coinLabel);
        coinLabel = new Label(coinCount,50);
        addObject(coinLabel,290,70);
    }
}
