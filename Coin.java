import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coins here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Actor
{
    private Animation spinAnim;
    private int spinAmount;
    /**
     * Constructor for Coin Class - sets the image
     */
    public Coin() {
        spinAnim = new Animation(this, "coins/c", 8, 25, 1);
        setImage(spinAnim.getImage(0));
    }

    /**
     * Called every act; Make the images animated
     */
    public void act() {
        if (spinAmount > 0) {
            spinAnim.animate();
            if (spinAnim.getFrame()==0) {
                spinAmount--;
            }
        }
    }

    /**
     * spin the coin a certain amount of times
     * @param amnt the amount of times
     */
    public void setSpin(int amnt) {
        // got lazy and didn't want to make another variable to
        // properly count the spins so i just multiplied by framerate
        spinAmount = Math.round(amnt * (60f / spinAnim.getFPS()));
    }
}
