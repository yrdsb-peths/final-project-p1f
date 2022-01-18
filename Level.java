import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level extends Actor
{
    Level() {
        setImage("images/Levels/lv0.png");
    }
    /**
     * Act - do whatever the Level wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        switch(((Look)getWorld()).getLV()) {
            case 1:
                setImage("images/Levels/lv1.png");
                break;
            case 2:
                setImage("images/Levels/lv2.png");
                break;
            case 3:
                setImage("images/Levels/lv3.png");
                break;
            case 4:
                setImage("images/Levels/lv4.png");
                break;
            case 5:
                setImage("images/Levels/lv5.png");
                break;
            case 6:
                setImage("images/Levels/lv6.png");
                break;
        }
    }
}
