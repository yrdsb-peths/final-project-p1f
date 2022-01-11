import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class ShyGuySays here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShyGuySays extends World
{
    GreenfootSound main = new GreenfootSound("Mario Party (Music) - Dodging Danger.mp3");
    /**
     * Constructor for objects of class ShyGuySays.
     * 
     */
    public ShyGuySays()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1);
        //Delete when done
        main.setVolume(10);
        
        FlagMan flagMan = new FlagMan();
        addObject(flagMan, 200, 480);

        PlayerSays player = new PlayerSays();
        addObject(player, 600, 460);

        FlagManSign flagSign = new FlagManSign();
        addObject(flagSign, 185, 254);
    }
    private boolean addedLabel = false;
    public void act(){
        //3...2...1...start!
        main.playLoop();
    }
}
