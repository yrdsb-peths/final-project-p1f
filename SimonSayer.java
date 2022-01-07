import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SimonSayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SimonSayer extends Actor
{
    //MUST BE INVISIBLE!!!
    //Maybe use an interface with a check method?
    public static boolean needToCheck = false;
    //left is true,right is false
    public static boolean direction;
    private SimpleTimer timer = new SimpleTimer();
    public SimonSayer(){
        timer.mark();
    }
    /**
     * Act - do whatever the SimonSayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(timer.millisElapsed() % 1000 == 0){
            needToCheck = true;
            //not randomizing direction
            if(Greenfoot.getRandomNumber(1) > 0){
                direction = true;
            }
            else{
                direction = false;
            }
            System.out.println("timer debug: " + String.valueOf(timer.millisElapsed()));
            System.out.println("needToCheck debug" + String.valueOf(needToCheck));
            System.out.println("direction debug" + String.valueOf(direction));
        }
        if(timer.millisElapsed() % 1000 == 0){
            needToCheck = false;
        }
    }    
}
