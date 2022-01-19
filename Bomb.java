import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bombs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
    private GreenfootImage bombFall = new GreenfootImage("Bob-Omb.png");
    
    private GreenfootSound startFall = new GreenfootSound("bombSend.mp3");
    
    public Bomb(float scale) {
        bombFall.scale((int)(bombFall.getWidth() * scale), (int)(bombFall.getHeight() * scale));
        setImage(bombFall);
        turn(Utils.random(359));
    }
    
    private int x;
    private int y;

    /**
     * Act - do whatever the Bombs wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
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
