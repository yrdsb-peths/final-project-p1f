import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot andx MouseInfo)

/**
 * Controls NPC's dice in world map
 * 
 * @author Eric Zhang
 * @version January 2022 
 */
public class MapNPC extends MapCharacter
{
    private SimpleTimer timer;
    /**
     * Constructor for the MapNPC class - calls its superclass and initializes a timer
     * 
     * @param name npc name 
     */
    public MapNPC(String name) {
        super(name);
        timer = new SimpleTimer();
    }

    /**
     * Method that starts a timer for when "npc" clicks dice
     */
    public void startDice(Dice dice) {
        timer.mark();
    }

    /**
     * Method that stops dice after a certain time
     * 
     * @param dice dice of npc
     * @return true/false if dice should stop
     */
    public boolean stopDice(Dice dice) {
        if (timer.millisElapsed() > 1500) {
            timer.mark();
            return true;
        }
        return false;
    }

    /**
     * Method that lets pop up know it can close, when "npc" clicks dice
     * (aka after certain amount of time)
     * 
     * @return boolean true if timer's millis time elapsed is greater than 1000
     */
    public boolean closePopUp() {
        return timer.millisElapsed() > 1000;
    }
    
}
