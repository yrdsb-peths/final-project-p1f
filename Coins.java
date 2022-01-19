import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Animates the coin
 * 
 * @author Tanya Gu
 * @version January 2022
 */
public class Coins extends Actor
{
    private GreenfootImage[] coin = new GreenfootImage[8];
    private boolean coinSpin = false;
    private SimpleTimer tim = new SimpleTimer();
    private Counter timeCount = new Counter();
    private int imageIndex = 0;
    
    /**
     * Constructor for Coins Class - sets the image and time limit
     */
    public Coins() {
        timeCount.setValue(2); // spin for 2s
        for (int i = 0; i < coin.length; i++) {
            coin[i] = new GreenfootImage("images/Coins/Coin" + (i+1) + ".png");
        }
        setImage(coin[0]);
    }

    /**
     * Method that animates the coin for 2 second if the coinSpin boolean is true
     */
    public void act()  {
        if (coinSpin) {
            setImage(coin[imageIndex]);
            imageIndex = (imageIndex + 1) % coin.length;

            if(tim.millisElapsed() > 1000) { // time count down every second
                timeCount.add(-1);
                tim.mark();
            }

            if (tim.millisElapsed() * 1000 == timeCount.getValue()) { //time limit reached
                coinSpin = false;
            }
        }
    }
}
