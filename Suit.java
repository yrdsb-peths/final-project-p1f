import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Suit extends Actor
{
    int suitType;
    int suitColor;
    Suit() {
        setSuit();
    }

    public void setSuit() {
        suitType = (Greenfoot.getRandomNumber(4) + 1); // Random type + color
        suitColor = (Greenfoot.getRandomNumber(4) + 1);
        switch(suitColor) {
            case 1: 
                setImage("Suits/R" + suitType + ".png");
                break;
            case 2:
                setImage("Suits/B" + suitType + ".png");
                break;
            case 3:
                setImage("Suits/G" + suitType + ".png");
                break;
            case 4:
                setImage("Suits/Y" + suitType + ".png");
                break;
        }
    }
}
