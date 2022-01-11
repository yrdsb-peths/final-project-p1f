import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MapPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MapPlayer extends MapCharacter
{
    
    public MapPlayer(String name) {
        super(name);
    }
    
    protected void setupAnim() {
        lWalk = new Animation(this, "Mario/WalkL", 2, 5, 1);
        rWalk = new Animation(this, "Mario/WalkR", 2, 5, 1);
        lIdle = new Animation(this, "Mario/WalkL", 1, 5, 1);
        rIdle = new Animation(this, "Mario/WalkR", 1, 5, 1);
    }
    
    
    
}
