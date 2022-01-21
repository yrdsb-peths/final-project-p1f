import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Updates levels for the look mini-game
 * 
 * @author Tanya Gu
 * @version January 2022
 */
public class Level extends Actor
{
    /**
     * Constructor for the Level class - sets images
     */
    Level() {
        setImage("images/Levels/lv0.png");
    }
    
    /**
     * Method that sets images based on the level
     */
    public void act() {
        switch(((Look)getWorld()).getLV()) {
            case 1:
                setImage("images/Levels/lv1.png");
                break;
            case 2:
                setImage("images/Levels/lv2.png");
                break;
            case 3:
                setImage("images/Levels/lv3.png");
                break;
            case 4:
                setImage("images/Levels/lv4.png");
                break;
            case 5:
                setImage("images/Levels/lv5.png");
                break;
            case 6:
                setImage("images/Levels/lv6.png");
                break;
        }
    }
}
