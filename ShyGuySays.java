import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShyGuySays here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShyGuySays extends World
{

    /**
     * Constructor for objects of class ShyGuySays.
     * 
     */
    public ShyGuySays()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        FlagMan flagMan = new FlagMan();
        addObject(flagMan, 200, 480);

        PlayerSays player = new PlayerSays();
        addObject(player, 600, 460);

        FlagManSign flagSign = new FlagManSign();
        addObject(flagSign, 185, 254);

        SimonSayer simon = new SimonSayer();
        addObject(simon, 0, 0);
    }
}
