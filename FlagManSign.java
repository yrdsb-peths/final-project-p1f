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
    GreenfootImage unknownSign = new GreenfootImage("uniFlag.png");
    
    GreenfootSound bad = new GreenfootSound("bad.mp3");
    GreenfootSound good = new GreenfootSound("good.mp3");
    
    GreenfootSound samuelSays = new GreenfootSound("SamuelSays.mp3");
    GreenfootSound samuelLeft = new GreenfootSound("SamuelLeft.mp3");
    GreenfootSound samuelRight = new GreenfootSound("SamuelRight.mp3");
    
    private enum Direction { LEFT, RIGHT, UNKNOWN };
    private static Direction direction = Direction.LEFT; 
    
    private int nextCheck = 5000;
    
    private static boolean check = false;
    
    private SimpleTimer timer = new SimpleTimer();
    
    private boolean justChecked = false;
    
    private boolean samuelSaid;
    
    public FlagManSign(){
        //not setting???
        timer.mark();
        check = false;
        direction = Direction.UNKNOWN;
    }
    public void act(){
        //good check method
        /**
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
        */
        
        //debug
        if(Greenfoot.isKeyDown("t")){
            System.out.println(String.valueOf(FlagManSign.direction));
        }
        //give the player the direction
        if(timer.millisElapsed() >= nextCheck - 1000){
            int doesSamuelSay = Greenfoot.getRandomNumber(2); //[0, 1]
            if(doesSamuelSay > 0){
                samuelSays.play();
            }
        }
        if(timer.millisElapsed() >= nextCheck) {
            //unknown sign, then randomize
            //way too fast
            int leftOrRight = Greenfoot.getRandomNumber(2); //[0, 1]
            if(leftOrRight > 0){
                FlagManSign.direction = Direction.LEFT;
                setImage(leftSign);
                samuelLeft.play();
            }
            else{
                FlagManSign.direction = Direction.RIGHT;
                setImage(rightSign);
                samuelRight.play();
            }
            timer.mark();
            nextCheck = Greenfoot.getRandomNumber(2000) + 4000; // [4000, 6000]
            justChecked = true;
        }
        
        //Check if the player did good
        if((timer.millisElapsed() >= 1000) && (justChecked)){
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
            
            //cleaning up for next cycle
            setImage(unknownSign);
            FlagManSign.direction = Direction.UNKNOWN;
            justChecked = false;
        }
        else{
            check = false;
        }
    }
    
    public static boolean getLeft() {
        return (direction == Direction.LEFT);
    }
    
    public static boolean getUnknown(){
        return (direction == Direction.UNKNOWN);
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
