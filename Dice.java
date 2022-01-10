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
    private SimpleTimer timer;
    private Vector2 pos;
    private int value;
    
    public Dice(int x, int y) {
        // upload dice here
        rollAnim = new Animation(this, "Dice/", 6, 60, 1); // (this, "", 6, 5, 1);
        rollAnim.shuffle();
        paused = true;
        timer = new SimpleTimer();
        pos = new Vector2(x, y);
    }
    
    public void act() {
        if (paused) return;
        rollAnim.animate();
    }
    
    /**
     * start rolling dice
     */
    public void roll() {
        paused = false;
        timer.mark();
        WorldMap.instance.addObject(this, pos.getX(), pos.getY());
    }
    
    /**
     * -1 to the dice value
     */
    public void countDown() {
        value--;
        rollAnim.setFrame(value);
    }
    
    /**
     * return 0 if not finished roll
     * return 1-6 when finished roll
     */
    public int rollResult() {
        if (timer.millisElapsed() >= 3000) {
            paused = true;
            value = rollAnim.getFrame()+1;
        } else {
            value = 0;
        }
        return value;
    }
    
    /**
     * return is rolling or not
     * return true if not paused
     */
    public boolean isRoll() {
        return !paused;
    }
    
    /**
     * hide the dice
     */
    public void hide() {
        getWorld().removeObject(this);
    }
    
}
