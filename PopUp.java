import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays various pop-up screens throughout the game
 * 
 * @author Eric Zhang
 * @version January 2022 
 */
public class PopUp extends Actor
{
    protected GreenfootImage panel;
    protected Button exitButton;
    protected Boolean canClose;
    private Boolean closed;
    
    /**
     * Constructor for the PopUp superclass 
     */
    public PopUp() {
        setupBG();
        canClose = true;
        closed = false;
    } 

    boolean isFirstAct = true;
    /**
     * Method that controls actions and exit status of pop-ups
     */
    public void act() {
        if (isFirstAct) {
            firstAct();
        }
        if (canClose && exitButton.clicked()) {
            // hide the pop up
            onExit();
        }
    }

    /**
     * Method to exit pop-ups
     */
    protected void onExit() {
        closed = true;
        getWorld().removeObject(exitButton);
        getWorld().removeObject(this);
    }

    /**
     * Method that sets up a panel for pop-ups
     */
    protected void setupBG() {
        panel = new GreenfootImage(WorldMap.instance.getWidth(), WorldMap.instance.getHeight());
        panel.setColor(new Color(0, 0, 0, 200));
        panel.fillRect(0, 0, panel.getWidth(), panel.getHeight());
        setImage(panel);
    }

    /**
     * Method called on the first act update after popup is added to the world
     */
    public void firstAct() {
        isFirstAct = false;
        setLocation(panel.getWidth()/2, panel.getHeight()/2);
        exitButton = new Button("  continue");
        WorldMap.instance.addObject(exitButton, 850, 550);
    }

    /**
     * Method that checks if is closed
     * 
     * @return boolean true if is closed
     */
    public boolean isClosed() {
        return closed;
    }
    
}
