import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Controls animated dice in the world map
 * 
 * @author Eric Zhang 
 * @version January 2022
 */
public class Dice extends Actor
{
    private Animation rollAnim;
    private boolean paused;
    
    private GreenfootSound diceRolling = new GreenfootSound("Dice_Rolling.mp3");
    private GreenfootSound rollingEnded = new GreenfootSound("Rolling_Ended.mp3");
    
    /**
     * Constructor for the Dice class - initializes dice rolling  
     */
    public Dice() {
        // upload dice here
        rollAnim = new Animation(this, "Dice/", 6, 20, 2);
        rollAnim.shuffle();
        startRoll();
    }
    
    /**
     * Method that controls dice animation
     */
    public void act() {
        rollAnim.periodicResize(paused); 
        rollAnim.animate();
    }

    /**
     * Method that stops the roll
     */
    public void stopRoll() {
        paused = true;
        rollAnim.pause();
        diceRolling.stop();
        rollingEnded.play();
    }

    /**
     * Method that starts a roll
     */
    public void startRoll() {
        paused = false;
        rollAnim.resume();
        diceRolling.playLoop();
    }
    
    /**
     * return 0 if not finished roll
     * return 1-6 when finished roll
     */
    public int rollResult() { 
        return rollAnim.getFrame()+1;
    }
    
    /**
     * Method that hides the dice
     */
    public void hide() {
        getWorld().removeObject(this);
    }
}
