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
    
    public FlagMan(){
        lFlagMan.scale(80, 80);
        rFlagMan.scale(80, 80);
    }
    
    public void act(){
        // change dir based on sign direction
        if(FlagManSign.getUnknown()){
            setImage(lFlagMan);
        }
        else if(FlagManSign.getSamuelSaid()){
            if(FlagManSign.getDirection().equals("LEFT")){
                setImage(lFlagMan);
            }
            else{
                setImage(rFlagMan);
            }
        }
        else{
            if(FlagManSign.getDirection().equals("LEFT")){
                setImage(rFlagMan);
            }
            else{
                setImage(lFlagMan);
            }
        }
    }
}

