import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Flag Man, who holds the Flag Man's Sign. Changes direction when the sign does.
 * 
 * @author Kevin Wang 
 * @version January 2022
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
        if(getWorldOfType(SamuelSays.class).getFlagManSign().getUnknown()){
            setImage(lFlagMan);
        }
        else if(getWorldOfType(SamuelSays.class).getFlagManSign().getSamuelSaid()){
            if(getWorldOfType(SamuelSays.class).getFlagManSign().getDirection().equals("LEFT")){
                setImage(lFlagMan);
            }
            else{
                setImage(rFlagMan);
            }
        }
        else{
            if(getWorldOfType(SamuelSays.class).getFlagManSign().getDirection().equals("LEFT")){
                setImage(rFlagMan);
            }
            else{
                setImage(lFlagMan);
            }
        }
    }
}

