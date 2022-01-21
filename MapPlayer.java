import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Controls human player's dice in world map
 * 
 * @author Eric Zhang
 * @version January 2022 
 */
public class MapPlayer extends MapCharacter
{
    /**
     * Constructor for the MapPlayer class - calls its superclass
     * 
     * @param name player name 
     */
    public MapPlayer(String name) {
        super(name);
    } 
    
    /**
     * Method that returns true when player clicks
     * 
     * @param dice
     */
    public boolean stopDice(Dice dice) {
        return Greenfoot.mouseClicked(dice);
    }
    
    /**
     * Method that does nothing when dice starts rolling
     */
    public void startDice(Dice dice) {}
    
    /**
     * Method that doesn't close pop up,
     * will be handled by button in PopUp
     * 
     * @return false
     */
    public boolean closePopUp() {
        return false;
    }

}
