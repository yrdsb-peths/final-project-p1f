import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Provides background story and general instructions of the game
 * 
 * @author Eric Zhang, Tanya Gu
 * @version January 2022
 */
public class StoryScreen extends World
{
    Button btn;
    /**
     * Constructor for objects of class StoryScreen.
     */
    public StoryScreen()
    {    
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        setBackground(new GreenfootImage("Instruction/Story.png"));
        MainSound.play();
        
        btn = new Button("  Continue", 0.7f); //add continue button
        addObject(btn, 500, 450);
    }
    
    /**
     * Method that checks if the continue button is clicked, if so, 
     * switch to character selection screen
     */
    public void act() {
        if (btn.clicked()) { 
            Greenfoot.setWorld(new CharacterSelect());
        }
    }
}
