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
    
    public static String direction = "left";
    public static boolean check = false;
    
    
    private SimpleTimer timer = new SimpleTimer();
    public FlagManSign(){
        setImage(leftSign);
    }
    public void act(){
        //good check method
        if(Greenfoot.isKeyDown("g")){
            check = true;
            //System.out.println(check);
            //System.out.println(PlayerSays.playerDirection);
            //System.out.println(FlagManSign.direction);
            if(!PlayerSays.playerDirection.equals(FlagManSign.direction))
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
        if(Greenfoot.isKeyDown("f")){
            int getDir = Greenfoot.getRandomNumber(2);
            System.out.println(getDir);
            if(getDir > 0){
                FlagManSign.direction = "right";
                setImage(rightSign);
            }
            else{
                FlagManSign.direction = "left";
                setImage(leftSign);
            }
        }
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
