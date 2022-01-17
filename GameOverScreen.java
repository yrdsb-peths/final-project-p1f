import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverScreen extends World
{
    GreenfootImage[] bkg = new GreenfootImage[28];
    /**
     * Constructor for objects of class GameOverScreen.
     * 
     */
    public GameOverScreen()
    {    
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        setBackground(new GreenfootImage("WinningScreen/16.png"));
        for (int i = 0; i < bkg.length; i++) { //change to use animat
            bkg[i] = new GreenfootImage("images/WinningScreen/" + (i) + ".png"); 
        }
        
        addObject(new Player("Mario",5),400,395);
        addObject(new Label("Wins!",70),550,415);
    }
    int imageIndex = 0; 
    public void act() {
        setBackground(bkg[imageIndex]);
        Greenfoot.delay(5);
        imageIndex = (imageIndex + 1) % bkg.length;
    }
}
