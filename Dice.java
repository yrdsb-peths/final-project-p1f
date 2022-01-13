import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dice extends Actor
{
    private Animation rollAnim;
    private boolean paused;
    
    public Dice() {
        // upload dice here
        rollAnim = new Animation(this, "Dice/", 6, 20, 2);
        rollAnim.shuffle();
        startRoll();
    }
    
    public void act() {
        rollAnim.periodicResize(paused); 
        rollAnim.animate();
    }

    /**
     * stops the roll
     */
    public void stopRoll() {
        paused = true;
        rollAnim.pause();
    }

    /**
     * starts a roll
     */
    public void startRoll() {
        paused = false;
        rollAnim.resume();
    }
    
    /**
     * return 0 if not finished roll
     * return 1-6 when finished roll
     */
    public int rollResult() { 
        return rollAnim.getFrame()+1;
    }
    
    /**
     * hide the dice
     */
    public void hide() {
        getWorld().removeObject(this);
    }
    
}
