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
    
    private SimpleTimer timer = new SimpleTimer();
    public FlagMan(){
        lFlagMan.scale(80, 80);
        rFlagMan.scale(80, 80);
        timer.mark();    
    }
    
    public void act(){
        if(FlagManSign.getUnknown()){
                setImage(lFlagMan);
        }
        else if(FlagManSign.getSamuelSaid()){
            if(FlagManSign.getLeft()){
                setImage(lFlagMan);
            }
            else{
                setImage(rFlagMan);
            }
        }
        else{
            if(FlagManSign.getLeft()){
                setImage(rFlagMan);
            }
            else{
                setImage(lFlagMan);
            }
        }
        
        if((timer.millisElapsed() > 60000) || !PlayerSays.alive){
            GameEnded done = new GameEnded();
            Greenfoot.setWorld(done);
            System.out.println(timer.millisElapsed());
            timer.mark();
        }
    }
}

