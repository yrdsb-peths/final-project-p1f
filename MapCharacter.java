import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MapCharacter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MapCharacter extends SmoothMover
{
    private String name;
     
    public MapCharacter() {
        this("Unnamed");
    }
    
    public MapCharacter(String name) {
        this.name = name;
    }
    
    public void act() {
        
    }
    
    public String getName() { return this.name; }
}
