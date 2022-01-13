import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlagManSign here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlagManSign extends FlagMan
{
    //too many errors, starting over
    //flag change sign
    GreenfootImage leftSign = new GreenfootImage("signLeft.png");
    GreenfootImage rightSign = new GreenfootImage("signRight.png");
    GreenfootSound bad = new GreenfootSound("bad.mp3");
    GreenfootSound good = new GreenfootSound("good.mp3");
    
    private enum Direction { LEFT, RIGHT };
    private static Direction direction = Direction.LEFT; 
    
    private int nextCheck = 5000;
    
    private static boolean check = false;
    
    private SimpleTimer timer = new SimpleTimer();
    
    public FlagManSign(){
        setImage(leftSign);
        timer.mark();
        check = false;
        direction = Direction.LEFT;
    }
    public void act(){
        //good check method
        if(Greenfoot.isKeyDown("g")){
            check = true;
            if(!String.valueOf(PlayerSays.getDirection()).equals(String.valueOf(FlagManSign.direction)))
            {
                if(PlayerSays.alive){
                    bad.play();
                }
                PlayerSays.alive = false;
            }
            else{
                good.play();
            }
         }
        else
        {
            check = false;
        } 
        if(timer.millisElapsed() >= nextCheck) {
            if(direction == Direction.RIGHT) {
                direction = Direction.LEFT;
                setImage(leftSign);
            } else{
                FlagManSign.direction = Direction.RIGHT;
                setImage(rightSign);
            }
            timer.mark();
            nextCheck = Greenfoot.getRandomNumber(2000) + 4000; // [4000, 6000]
            /**
            int getDir = Greenfoot.getRandomNumber(2);
            System.out.println(getDir);
            System.out.println(timer.millisElapsed());
            if(getDir > 0){
                FlagManSign.direction = "right";
                setImage(rightSign);
            }
            else{
                FlagManSign.direction = "left";
                setImage(leftSign);
            }
            */
        }
    }
    
    public static boolean getLeft() {
        return (direction == Direction.LEFT);
    }
    
    public static boolean getCheck() {
        return check;
    }
    
    /**
    */
    /**
     * Act - do whatever the FlagManSign wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    /**
    public void act() 
    {
        //not changing orientation
        //NULL POINTER  EXCEPTION???
        //make it switch sign later
        /**
        if(FlagMan.needToCheck = true){
            if(FlagMan.direction.equals("left")){
                setImage(leftSign);
            }
            else if(FlagMan.direction.equals("right")){
                setImage(rightSign);
            }
            System.out.println("switched sign");
        }
        */
     
    
}
