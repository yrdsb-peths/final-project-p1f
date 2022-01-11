import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrow extends Actor
{
    int arrow;
    
    public void setArrow() {
        arrow = (Greenfoot.getRandomNumber(4) + 1);
        //System.out.println(arrow);

        switch(arrow) {
            case 1:
                setImage("Arrows/Up1.png");
                break;
            case 2:
                setImage("Arrows/Down1.png");
                break;
            case 3:
                setImage("Arrows/Left1.png");
                break;
            case 4:
                setImage("Arrows/Right1.png");
                break;
        }
    }
}
