import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerOne extends Actor
{
    private GreenfootImage idle = new GreenfootImage("WalkF1.png");
    
    private enum PlayerDirection{LEFT, RIGHT, IDLE};
    private PlayerDirection playerDirection = PlayerDirection.IDLE;
    
    private GreenfootSound death = new GreenfootSound("death.mp3");
    
    public static boolean alive;
    
    public PlayerOne(){
        idle.scale(80, 80);
        setImage(idle);
    }
    /**
     * Act - do whatever the PlayerOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("a")){
            walkLeft();
        }
        else if(Greenfoot.isKeyDown("d")){
            walkRight();
        }
        else{
            playerDirection = PlayerDirection.IDLE;
            setImage(idle);
        }
        if(this.isTouching(Bomb.class)){
            PlayerOne.alive = false;
        }
    }    
    
    private void walkLeft(){
        //animate walking later
        if(this.getX() > 50){
            GreenfootImage walkLeft1 = new GreenfootImage("WalkL1.png");
            setImage(walkLeft1);
            int x = this.getX() - 5;
            int y = this.getY();
            this.setLocation(x, y);
            playerDirection = PlayerDirection.LEFT;
        }
    }
    
    private void walkRight(){
        if(this.getX() < 950){
            GreenfootImage walkRight1 = new GreenfootImage("WalkR1.png");
            setImage(walkRight1);
            int x = this.getX() + 5;
            int y = this.getY();
            this.setLocation(x, y);
            playerDirection = PlayerDirection.RIGHT;
        }
    }
}
