import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MapNPC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MapNPC extends MapCharacter
{
    // change to Luigi later
    protected void setupAnim() {
        lWalk = new Animation(this, "Luigi/WalkL", 2, 3, 3);
        rWalk = new Animation(this, "Luigi/WalkL", 2, 3, 3, true);
        lIdle = new Animation(this, "Luigi/WalkL", 1, 3, 3);
        rIdle = new Animation(this, "Luigi/WalkL", 1, 3, 3, true);
    }
}
