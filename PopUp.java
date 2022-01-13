import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PopUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PopUp extends Actor
{
    
    private GreenfootImage panel;
    private Button exitButton;
    private Boolean canClose;
    
    public PopUp() {
        panel = new GreenfootImage(WorldMap.instance.getWidth(), WorldMap.instance.getHeight());
        panel.setColor(new Color(0, 0, 0, 200));
        panel.fillRect(0, 0, panel.getWidth(), panel.getHeight());
        setImage(panel); 
    }

    boolean firstAct = true;
    public void act() {
        if (firstAct) {
            firstAct = false;
            setLocation(panel.getWidth()/2, panel.getHeight()/2);
            exitButton = new Button("Exit");
            WorldMap.instance.addObject(exitButton, 850, 550);
        }
        if (exitButton.clicked()) {
            // hide the pop up
            getWorld().removeObject(exitButton);
            getWorld().removeObject(this);
        }
    }
    
}
