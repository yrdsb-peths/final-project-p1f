import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PopUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PopUp extends Actor
{
    protected GreenfootImage panel;
    private Button exitButton;
    protected Boolean canClose;
    private Boolean closed;
    
    public PopUp() {
        setupBG();
        canClose = true;
        closed = false;
    } 

    boolean isFirstAct = true;
    public void act() {
        if (isFirstAct) {
            firstAct();
        }
        if (canClose && exitButton.clicked()) {
            // hide the pop up
            onExit();
        }
    }

    protected void onExit() {
        closed = true;
        getWorld().removeObject(exitButton);
        getWorld().removeObject(this);
    }

    protected void setupBG() {
        panel = new GreenfootImage(WorldMap.instance.getWidth(), WorldMap.instance.getHeight());
        //panel.setColor(new Color(0, 0, 0, 200));
        panel.setColor(new Color(0, 0, 0, 200));
        panel.fillRect(0, 0, panel.getWidth(), panel.getHeight());
        setImage(panel);
    }

    /**
     * called on the first act update after popup is added to the world
     */
    public void firstAct() {
        isFirstAct = false;
        setLocation(panel.getWidth()/2, panel.getHeight()/2);
        exitButton = new Button("  continue");
        WorldMap.instance.addObject(exitButton, 850, 550);
    }

    public boolean isClosed() {
        return closed;
    }
    
}
