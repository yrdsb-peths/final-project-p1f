import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Updates suits images for the look mini-game
 * 
 * @author Eric Zhang, Tanya Gu
 * @version January 2022
 */
public class Suit extends Actor
{
    private final int numSuits = 22;
    private int suitType;
    private boolean center;

    /**
     * Constructor for the Suit class
     */
    public Suit() {
        // get random suit (will be placed at edge)
        suitType = Utils.random(1, numSuits);
        center = false;
        updateImage();
    }

    public Suit(int type) {
        // set suit to another suit (will be placed in center)
        suitType = type;
        center = true;
        updateImage();
    }

    /**
     * Method to check if it's at center
     * 
     * @return center
     */
    public boolean isCenter() {
        return center;
    }

    
    /**
     * Method to get suit type
     * 
     * @return suitType
     */
    public int getType() {
        return suitType;
    }

    /**
     * Method that resizes and sets the suits images
     */
    public void updateImage() { 
        GreenfootImage img = new GreenfootImage("Suits/power" + suitType + ".png");
        img.scale(124, 124);
        setImage(img);
    }
}
