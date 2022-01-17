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
    
    private GreenfootImage walkLeft1 = new GreenfootImage("WalkL1.png");
    private GreenfootImage walkLeft2 = new GreenfootImage("WalkL2.png");
    private GreenfootImage walkRight1 = new GreenfootImage("WalkR1.png");
    private GreenfootImage walkRight2 = new GreenfootImage("WalkR2.png");
                
    private GreenfootSound death = new GreenfootSound("death.mp3");
    
    public static boolean alive;
    
    private SimpleTimer animTimer = new SimpleTimer();
    public PlayerOne(){
        setImage(idle);
        animTimer.mark();
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
            setImage(idle);
        }
        if(this.isTouching(Bomb.class)){
            death.play();
            PlayerOne.alive = false;
        }
    }    
    
    private void walkLeft(){
        //animate walking later
        if(this.getX() > 50){
            if(animTimer.millisElapsed() % 2 == 0){setImage(walkLeft1);}
            else{setImage(walkLeft2);}
            int x = this.getX() - 5;
            int y = this.getY();
            this.setLocation(x, y);
        }
    }
    
    private void walkRight(){
        if(this.getX() < 950){
            if(animTimer.millisElapsed() % 2 == 0){setImage(walkRight1);}
            else{setImage(walkRight2);}
            int x = this.getX() + 5;
            int y = this.getY();
            this.setLocation(x, y);
        }
    }
}
