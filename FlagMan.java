import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlagMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlagMan extends Actor
{
    public static boolean needToCheck = false;
    //left is true,right is false
    //make string
    public static String direction;
    private SimpleTimer timer = new SimpleTimer();
    GreenfootImage lFlagMan = new GreenfootImage("flaggerL.png");
    GreenfootImage rFlagMan = new GreenfootImage("flaggerR.png");
    public FlagMan(){
        lFlagMan.scale(80, 80);
        rFlagMan.scale(80, 80);
        setImage(lFlagMan);
        timer.mark();
    }
    //record the last time it was checked
    private int lastTimeChecked;    
    /**
     * Act - do whatever the FlagMan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //supposed to switch every now and then, make longer when done testing
        //add an animation before the switch
        //part 1
        if(timer.millisElapsed() % 5000 == 0){
            lastTimeChecked = timer.millisElapsed();
            //RANDOMIZING DIRECTION!!!
            //DIRECTION IS NULL! WHAT?
            if(Greenfoot.getRandomNumber(2) > 0){
                //show flag and allow movement
                FlagMan.direction = "left";
                setImage(lFlagMan);
            }
            else{
                FlagMan.direction = "right";
                setImage(rFlagMan);
            }
            System.out.println("timer debug: " + String.valueOf(timer.millisElapsed()));
            System.out.println("needToCheck debug: " + String.valueOf(needToCheck));
            System.out.println("direction debug: " + direction);
        }
        //give them some time to move
        if(timer.millisElapsed() - 1000 == lastTimeChecked){
            System.out.println("time elapsed since first: " + timer.millisElapsed());
            //check
            //start checking now
            needToCheck = true;
        }
        
        //now stop checking
        if(timer.millisElapsed() - 2000 == lastTimeChecked){
            System.out.println("time elapsed since last: " + timer.millisElapsed());
            needToCheck = false;
            direction = "";
        }
    }    
    //Static var to player, player then checks and sends back?
}

