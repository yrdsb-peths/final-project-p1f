import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot andx MouseInfo)

/**
 * Write a description of class MapNPC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MapNPC extends MapCharacter
{
    
    private SimpleTimer timer;
    public MapNPC(String name) {
        super(name);
        timer = new SimpleTimer();
    }

    /**
     * starts a timer for when "npc" clicks dice
     */
    public void startDice(Dice dice) {
        timer.mark();
    }

    /**
     * return true after a certain time
     */
    public boolean stopDice(Dice dice) {
        if (timer.millisElapsed() > 2000) {
            timer.mark();
            return true;
        }
        return false;
    }

    /**
     * let pop up know it can close, when "npc" clicks dice
     * (aka after certain amount of time)
     */
    public boolean closePopUp() {
        return timer.millisElapsed() > 1000;
    }
    
}
