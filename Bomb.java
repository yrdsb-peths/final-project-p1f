import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bombs here.
 * 
 * @author Kevin Wang
 * @version January 2022
 */
public class Bomb extends Actor
{
    //The image for the bob-ombs that fall
    private GreenfootImage bombFall = new GreenfootImage("Bob-Omb.png");
    
    //The sound that plays when a bob-omb is dropped
    private GreenfootSound startFall = new GreenfootSound("bombSend.mp3");
    
    //Some coordinates for the bombs to later set their location to
    private int x;
    private int y;
    /**
     * Constructor for the Bomb class - sets and scales bomb images
     * 
     * @param scale Scale of the bombs
     */
    public Bomb(float scale) {
        //Scales it to the float inputted during creation, and sets the image
        bombFall.scale((int)(bombFall.getWidth() * scale), (int)(bombFall.getHeight() * scale));
        setImage(bombFall);
        
        //Turns a random rotation to start falling at
        turn(Utils.random(359));
    }
    
    /**
     * Generates random locations for falling bombs
     */
    public void act()  {
        if(this.getY() >= 599){
           //If the bob-omb reached the end of the world:
                //-put itself back at the top
                //-play the new bob-omb drop sound
                //-turn a random rotation
           x = Greenfoot.getRandomNumber(1000);
           y = 0;
           startFall.play();
           turn(Greenfoot.getRandomNumber(359));
        }
        else{
            //Otherwise, put itself at a lower coordinate
            x = this.getX();
            y = this.getY() + 3;
        }
        
        //Sets the coordinates after modifying it 
        setLocation(x, y);
        
        //Turns a bit every frame
        turn(1);
    }    
}
