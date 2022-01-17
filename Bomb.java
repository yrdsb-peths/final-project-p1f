import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bombs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
    private GreenfootImage bombFall = new GreenfootImage("Bomb1.png");
    
    public Bomb(int size){
        bombFall.scale(size, size);
        setImage(bombFall);
    }
    
    private int x;
    private int y;
    
    /**
     * Act - do whatever the Bombs wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(this.getY() >= 550){
           x = Greenfoot.getRandomNumber(1000);
           y = 0;
        }
        else{
            x = this.getX();
            y = this.getY() + 3;
        }
        setLocation(x, y);
    }    
    
    private void explode(){
        SimpleTimer animateTimer = new SimpleTimer();
        animateTimer.mark();
        int i = 0;
        if(animateTimer.millisElapsed() >= 300){
            GreenfootImage bomb = new GreenfootImage("Bomb" + i + ".png");
            setImage(bomb);
            animateTimer.mark();
        }
        /**
        for(int i = 2; i < 4; i++){
            this.setImage(bomb);
        }
        */
    }
}
