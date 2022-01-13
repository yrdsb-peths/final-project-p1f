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
    
    static PlayerSays player = new PlayerSays();
    static FlagManSign flagSign = new FlagManSign();
    static FlagMan flagMan = new FlagMan();
    
    //initializing the player
    GreenfootImage left = new GreenfootImage("WalkL1.png");
    GreenfootImage leftSign = new GreenfootImage("signLeft.png");
    GreenfootImage leftFlagMan = new GreenfootImage("flaggerL.png");
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
        
        leftFlagMan.scale(80, 80);
        flagMan.setImage(leftFlagMan);
        addObject(flagMan, 200, 480);
        
        //making sure player does not die on startup
        left.scale(100, 100);
        player.alive = true;
        player.setDirection(true);
        addObject(player, 600, 460);
        player.setImage(left);
        
        flagSign.setImage(leftSign);
        addObject(flagSign, 185, 254);
    }
    private boolean addedLabel = false;
    public void act(){
        //3...2...1...start!
        main.playLoop();
    }
}
