import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerSays extends Actor
{
    GreenfootImage idle = new GreenfootImage("WalkF1.png");
    GreenfootImage left = new GreenfootImage("WalkL2.png");
    GreenfootImage right = new GreenfootImage("WalkR2.png");
    
    public PlayerSays(){
        idle.scale(100, 100);
        left.scale(100, 100);
        right.scale(100, 100);
        setImage(idle);
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("a")){
            setImage(left);
        }
        if(Greenfoot.isKeyDown("d")){
            setImage(right);
        }
    }
}
