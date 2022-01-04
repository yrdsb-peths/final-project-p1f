import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * When boolean 'coinSpin' is set to true, the coin icon starts spinning for 2 seconds
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coins extends Actor
{
    GreenfootImage[] coin = new GreenfootImage[9];
    boolean coinSpin = false;
    SimpleTimer spinTim = new SimpleTimer();
    Counter spinTimeCount = new Counter();
    
    /**
     * Constructor for Coins Class - sets the image
     */
    public Coins() {
        spinTimeCount.setValue(2); //spin time is 3s
        for (int i = 0; i < coin.length; i++) {
            coin[i] = new GreenfootImage("images/Coin" + (i+1) + ".png");
        }
        setImage(coin[0]);
    }

    /**
     * Called every act; Make the images animated
     */
    int imageIndex = 0;
    public void act() {
        if (coinSpin) { 
            setImage(coin[imageIndex]);
            imageIndex = (imageIndex + 1) % coin.length;

            if(spinTim.millisElapsed() > 1000) { //time count down every second
                spinTimeCount.add(-1);
                spinTim.mark();
            }

            if (spinTim.millisElapsed() * 1000 == spinTimeCount.getValue()) { //if time limit is reached
                coinSpin = false; //stops spinning coin
            }
        }
    }
}
