import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Title screen of the game
 * 
 * @author Tanya Gu
 * @version January 2022
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

    /**
     * Adds start button
     */
    public void prepare() {
        start = new Button("    Start", 0.7f);
        addObject(start, 500,450);
    }
    
    /**
     * Checks if the start button is clicked, if so, 
     * switch to story screen
     */
    public void act() {
        MainSound.play();
        if (Greenfoot.mouseClicked(start)) {
            Greenfoot.setWorld(new StoryScreen());
        }
    }
}
