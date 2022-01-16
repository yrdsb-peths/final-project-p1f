import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    private Button start;
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        setBackground(new GreenfootImage("Title.png"));
        MainSound.setSound(new GreenfootSound("TitleBGM.mp3"));
        prepare();
    }
    public void prepare() {
        start = new Button("    Start", 0.7f);
        addObject(start, 500,450);
        
        //MainSound.play();
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(start)) {
            Greenfoot.setWorld(new WorldMap());
        }
    }
}
