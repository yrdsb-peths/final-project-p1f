import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Suit extends Actor
{
    private final int numSuits = 22;
    private int suitType;
    private boolean center;

    public Suit() {
        // get random suit (will be placed at edge)
        suitType = Utils.random(1, numSuits);
        center = false;
        updateImage();
    }

    public Suit(int type) {
        // set suit to another suit (will be placed in center)
        suitType = type;
        center = true;
        updateImage();
    }

    public boolean isCenter() {
        return center;
    }

    public int getType() {
        return suitType;
    }

    public void updateImage() { 
        GreenfootImage img = new GreenfootImage("Suits/power" + suitType + ".png");
        img.scale(124, 124);
        setImage(img);
    }

    public void setSuit(int idx) {
        // suitType = (Greenfoot.getRandomNumber(4) + 1); // Random type + color
        // suitColor = (Greenfoot.getRandomNumber(4) + 1);
        // switch(suitColor) {
        //     case 1: 
        //         setImage("Suits/R" + suitType + ".png");
        //         break;
        //     case 2:
        //         setImage("Suits/B" + suitType + ".png");
        //         break;
        //     case 3:
        //         setImage("Suits/G" + suitType + ".png");
        //         break;
        //     case 4:
        //         setImage("Suits/Y" + suitType + ".png");
        //         break;
        // }
    }
}
