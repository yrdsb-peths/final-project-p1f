import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bombs that fall from sky
 * 
 * @author Kevin Wang
 * @version January 2022
 */
public class Bomb extends Actor
{
    private GreenfootImage bombFall = new GreenfootImage("Bob-Omb.png");
    private GreenfootSound startFall = new GreenfootSound("bombSend.mp3");
    private int x;
    private int y;
    /**
     * Constructor for the Bomb class - sets and scales bomb images
     * 
     * @param scale Scale of the bombs
     */
    public Bomb(float scale) {
        bombFall.scale((int)(bombFall.getWidth() * scale), (int)(bombFall.getHeight() * scale));
        setImage(bombFall);
        turn(Utils.random(359));
    }
    
    /**
     * Generates random locations for falling bombs
     */
    public void act()  {
        if(this.getY() >= 599){
           x = Greenfoot.getRandomNumber(1000);
           y = 0;
           startFall.play();
           turn(Greenfoot.getRandomNumber(359));
        }
        else{
            x = this.getX();
            y = this.getY() + 3;
        }
        setLocation(x, y);
        turn(1);
    }    
}
