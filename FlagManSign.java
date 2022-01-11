import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlagManSign here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlagManSign extends FlagMan
{
    GreenfootImage leftSign = new GreenfootImage("signLeft.png");
    GreenfootImage rightSign = new GreenfootImage("signRight.png");
    public FlagManSign(){
        setImage(leftSign);
    }
    /**
     * Act - do whatever the FlagManSign wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //not changing orientation
        //NULL POINTER  EXCEPTION???
        //make it switch sign later
        /**
        if(FlagMan.needToCheck = true){
            if(FlagMan.direction.equals("left")){
                setImage(leftSign);
            }
            else if(FlagMan.direction.equals("right")){
                setImage(rightSign);
            }
            System.out.println("switched sign");
        }
        */
    }    
}
