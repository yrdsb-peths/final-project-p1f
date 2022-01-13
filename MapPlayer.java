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
        lWalk = new Animation(this, "Mario/anim/right", 2, 5, 3, true);
        rWalk = new Animation(this, "Mario/anim/right", 2, 5, 3);
        lIdle = new Animation(this, "Mario/anim/right", 1, 5, 3, true);
        rIdle = new Animation(this, "Mario/anim/right", 1, 5, 3);
    }
    
    public void dice() {
        
    }
    
}
