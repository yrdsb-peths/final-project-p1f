import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Animated game over screen - determines the winning player and allows user to re-play
 * 
 * @author Victoria Zhang, Eric Zhang, Tanya Gu
 * @version January 2022
 */
public class GameOverScreen extends World
{
    private GreenfootImage[] bkg = new GreenfootImage[28];
    private Button backToTitle;
    /**
     * Constructor for objects of class GameOverScreen.
     * 
     * @param playersRef Players of the game
     */
    public GameOverScreen(ArrayList<MapCharacter> playersRef)
    {    
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        
        setBackground(new GreenfootImage("WinningScreen/16.png"));
        for (int i = 0; i < bkg.length; i++) { //animated background
            bkg[i] = new GreenfootImage("images/WinningScreen/" + (i) + ".png"); 
        }
        
        MainSound.setSound(new GreenfootSound("EndTheme.mp3"));
        MainSound.play();
        
        //determine the winning player
        ArrayList<MapCharacter> players = new ArrayList<MapCharacter>(playersRef);
        Utils.sort(players);
        Player player = new Player(players.get(0).getName(), 5);
        addObject(player,400,395);
        addObject(new Label("Wins!",70),550,415);
        
        backToTitle = new Button("Play Again!", 0.7f);
        addObject(backToTitle, 500, 550);
    }
    
    /**
     * Method that animates the background and checks if the 
     * re-play button is clicked, if so, return to title screen
     */
    int imageIndex = 0; 
    public void act() {
        setBackground(bkg[imageIndex]);
        Greenfoot.delay(5);
        imageIndex = (imageIndex + 1) % bkg.length;
        
        if (Greenfoot.mouseClicked(backToTitle)) { 
            Greenfoot.setWorld(new TitleScreen());
        }
    }
}
