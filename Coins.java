import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coins here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coins extends Actor
{
    GreenfootImage[] coin = new GreenfootImage[8];
    boolean coinSpin = false;
    SimpleTimer tim = new SimpleTimer();
    Counter timeCount = new Counter();
    
    /**
     * Constructor for Coins Class - sets the image
     */
    public Coins() {
        timeCount.setValue(2); //spin time is 2s
        for (int i = 0; i < coin.length; i++) {
            coin[i] = new GreenfootImage("images/Coins/Coin" + (i+1) + ".png");
        }
        setImage(coin[0]);
    }

    /**
     * Called every act; Make the images animated
     */
    int imageIndex = 0;
    public void act()  {
        if (coinSpin) {
            setImage(coin[imageIndex]);
            imageIndex = (imageIndex + 1) % coin.length;

            if(tim.millisElapsed() > 1000) { //time count down every second
                timeCount.add(-1);
                tim.mark();
            }

            if (tim.millisElapsed() * 1000 == timeCount.getValue()) { //if time limit is reached
                coinSpin = false;
            }
        }
    }
}
