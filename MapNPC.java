import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot andx MouseInfo)

/**
 * Write a description of class MapNPC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MapNPC extends MapCharacter
{
    
    public MapNPC(String name) {
        super(name);
    }
    
    protected void setupAnim() {
        lWalk = new Animation(this, "Luigi/WalkL", 2, 5, 3);
        rWalk = new Animation(this, "Luigi/WalkL", 2, 5, 3, true);
        lIdle = new Animation(this, "Luigi/WalkL", 1, 5, 3);
        rIdle = new Animation(this, "Luigi/WalkL", 1, 5, 3, true);
    }
}
