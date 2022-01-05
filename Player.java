import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    Player() {
        setImage("Mario/WalkR1.png");
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("up")) {
            setImage("Mario/WalkB1.png");
            setLocation(getX(),getY() - 3);
        } else if (Greenfoot.isKeyDown("down")) {
            setImage("Mario/WalkF1.png");
            setLocation(getX(),getY() + 3);
        } else if (Greenfoot.isKeyDown("left")) {
            setImage("Mario/WalkL1.png");
            setLocation(getX() - 3,getY());
        } else if (Greenfoot.isKeyDown("right")) {
            setImage("Mario/WalkR1.png");
            setLocation(getX() + 3,getY());
        }
    }
}
