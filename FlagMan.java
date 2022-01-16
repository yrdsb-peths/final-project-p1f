import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlagMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlagMan extends Actor
{
    //too many errors, starting over
    GreenfootImage lFlagMan = new GreenfootImage("flaggerL.png");
    GreenfootImage rFlagMan = new GreenfootImage("flaggerR.png");
    
    GreenfootSound main = new GreenfootSound("Mario Party (Music) - Dodging Danger.mp3");
    
    private SimpleTimer timer = new SimpleTimer();
    public FlagMan(){
        lFlagMan.scale(80, 80);
        rFlagMan.scale(80, 80);
        timer.mark();
        main.setVolume(30);
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
        
        if((timer.millisElapsed() > 62500) || !PlayerSays.alive){
            main.stop();
            GameEnded done = new GameEnded();
            Greenfoot.setWorld(done);
            System.out.println(timer.millisElapsed());
        }
        else{
            main.play();
        }
    }
}

