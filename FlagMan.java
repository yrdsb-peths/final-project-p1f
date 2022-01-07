import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlagMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlagMan extends Actor
{
    GreenfootImage lFlagMan = new GreenfootImage("flaggerL.png");
    GreenfootImage rFlagMan = new GreenfootImage("flaggerR.png");
    protected static boolean left = true;
    public FlagMan(){
        lFlagMan.scale(80, 80);
        rFlagMan.scale(80, 80);
    }
    /**
     * Act - do whatever the FlagMan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //Set to !left because the program is too slow to sync flagman with flagman sign
        //If your computer doesn't sync, try removing the !
        if(!left){ 
            setImage(lFlagMan);
        }
        else{
            setImage(rFlagMan);
        }
        // Add your action code here.
        Greenfoot.delay(10);
        left = !left;
    }    
}