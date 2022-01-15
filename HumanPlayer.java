import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HumanPlayer extends Player
{
    
    public HumanPlayer(String name, float scale) {
        super(name, scale);
    }
    
    protected void playMemoryMatch() {
        float speed = 3f;
        if (Greenfoot.isKeyDown("w")) {
            move(new Vector2(0, -speed));
        } else if (Greenfoot.isKeyDown("s")) { 
            move(new Vector2(0, speed));
        }
        if (Greenfoot.isKeyDown("a")) {
            move(new Vector2(-speed, 0));
        } else if (Greenfoot.isKeyDown("d")) { 
            move(new Vector2(speed, 0));
        }
    }
}
