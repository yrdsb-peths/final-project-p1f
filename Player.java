import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Players
{
    char playerOrientation;
    Player() {
        setPlayerImage("Mario/WalkF1.png");
    }

    private void setPlayerImage(String file) {
        GreenfootImage image = new GreenfootImage(file);
        image.scale(image.getWidth()+100, image.getHeight()+100);
        setImage(image);
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (Greenfoot.isKeyDown("up")) {
            playerOrientation = 'U';
            setPlayerImage("Mario/U1.png"); 
        } else if (Greenfoot.isKeyDown("down")) {
            playerOrientation = 'D';
            setPlayerImage("Mario/D1.png"); 
        } else if (Greenfoot.isKeyDown("left")) {
            playerOrientation = 'L';
            setPlayerImage("Mario/L1.png"); 
        } else if (Greenfoot.isKeyDown("right")) {
            playerOrientation = 'R';
            setPlayerImage("Mario/R1.png"); 
        } else if (Greenfoot.isKeyDown("space")) {
            playerOrientation = 'F';
            setPlayerImage("Mario/WalkF1.png"); //img need to be changed
        }
    }

    public int checkPlayer() {
        if (playerOrientation == 'F') {
            return 0;
        } else if (playerOrientation == 'U') {
            return 1;
        } else if (playerOrientation == 'D') {
            return 2;
        } else if (playerOrientation == 'L') {
            return 3;
        } else if (playerOrientation == 'R') {
            return 4;
        }
        return -1;
    }
}