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
    public static boolean direction;
    //did simon say? 
    public static boolean simonSaid = true;
    
    private SimpleTimer timer = new SimpleTimer();
    GreenfootImage lFlagMan = new GreenfootImage("flaggerL.png");
    GreenfootImage rFlagMan = new GreenfootImage("flaggerR.png");
    protected static boolean left = true;
    //protected SimpleTimer timer = new SimpleTimer();
    public FlagMan(){
        lFlagMan.scale(80, 80);
        rFlagMan.scale(80, 80);
        setImage(lFlagMan);
        timer.mark();
    }
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
        if(timer.millisElapsed() % 100 == 0){
            lastTimeChecked = timer.millisElapsed();
            needToCheck = true;
            //RANDOMIZING DIRECTION!!!
            if(Greenfoot.getRandomNumber(2) > 0){simonSaid = true;}
            else{simonSaid = false;}
            if(Greenfoot.getRandomNumber(2) > 0){
                direction = true;
            }
            else{
                direction = false;
            }
            System.out.println("timer debug: " + String.valueOf(timer.millisElapsed()));
            System.out.println("needToCheck debug" + String.valueOf(needToCheck));
            System.out.println("direction debug" + String.valueOf(direction));
            System.out.println("simon says debug" + String.valueOf(simonSaid));
        }
        //thirty milliseconds later, stop the check
        if(timer.millisElapsed() - 50 == lastTimeChecked){
            System.out.println("time elapsed: " + timer.millisElapsed());
            needToCheck = false;
        }
        
        //part 2
        if(FlagMan.needToCheck)
        {
            //Set to !left because the program is too slow to sync flagman with flagman sign
            //If your computer doesn't sync, try removing the !
            if(FlagMan.direction){ 
                setImage(lFlagMan);
            }
            else{
                setImage(rFlagMan);
            }
            // Add your action code here.
            left = !left;
        }
    }    
    //Static var to player, player then checks and sends back?
}
