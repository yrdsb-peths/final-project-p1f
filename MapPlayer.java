import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MapPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MapPlayer extends MapCharacter
{
    
    public MapPlayer(String name) {
        super(name);
    } 
    
    /**
     * 
     * return true when player clicks
     * @param dice
     */
    public boolean stopDice(Dice dice) {
        return Greenfoot.mouseClicked(dice);
    }
    
    /**
     * do nothing when dice starts rolling
     */
    public void startDice(Dice dice) {}
    
    /**
     * dont close pop up,
     * will be handled by button in PopUp
     * @return false
     */
    public boolean closePopUp() {
        return false;
    }

}
