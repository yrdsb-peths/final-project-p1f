import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StoryScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StoryScreen extends World
{

    Button btn;
    /**
     * Constructor for objects of class StoryScreen.
     * 
     */
    public StoryScreen()
    {    
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        setBackground(new GreenfootImage("Instruction/Story.png"));
        MainSound.play();
        
        btn = new Button("continue", 1f);
        addObject(btn, 470, 500);
    }
    
    public void act() {
        if (btn.clicked()) {
            Greenfoot.setWorld(new CharacterSelect());
        }
    }
}
