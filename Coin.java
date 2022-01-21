import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Animates coin to spin
 * 
 * @author Eric Zhang
 * @version January 2022
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
     * Method that animates the images
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
     * Method that spins the coin a certain amount of times
     * 
     * @param amnt the amount of times
     */
    public void setSpin(int amnt) {
        // got lazy and didn't want to make another variable to
        // properly count the spins so i just multiplied by framerate
        spinAmount = Math.round(amnt * (60f / spinAnim.getFPS()));
    }
}
