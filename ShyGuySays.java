import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class ShyGuySays here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShyGuySays extends World
{
    
    private static PlayerSays player = new PlayerSays();
    private static FlagManSign flagSign = new FlagManSign();
    private static FlagMan flagMan = new FlagMan();
    
    //initializing the player
    GreenfootImage idle = new GreenfootImage("WalkF1.png");
    GreenfootImage unknownSign = new GreenfootImage("uniFlag.png");
    GreenfootImage leftFlagMan = new GreenfootImage("flaggerL.png");
    
    GreenfootSound main = new GreenfootSound("Mario Party (Music) - Dodging Danger.mp3");
    /**
     * Constructor for objects of class ShyGuySays.
     * 
     */
    public ShyGuySays()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1);
        
        main.setVolume(30);

        leftFlagMan.scale(80, 80);
        flagMan.setImage(leftFlagMan);
        addObject(flagMan, 200, 480);
        
        idle.scale(100, 100);
        player.alive = true;
        player.setUnknown();
        addObject(player, 600, 460);
        player.setImage(idle);
        
        flagSign.setImage(unknownSign);
        addObject(flagSign, 185, 254);
    }
    
    public void act(){
        if(PlayerSays.alive){
            main.play();
        }
        else{
            main.stop();
        }
    }
}
