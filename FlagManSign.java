import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlagManSign here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlagManSign extends FlagMan
{
    GreenfootImage leftSign = new GreenfootImage("signLeft.png");
    GreenfootImage rightSign = new GreenfootImage("signRight.png");
    GreenfootImage unknownSign = new GreenfootImage("uniFlag.png");

    GreenfootSound samuelSays = new GreenfootSound("SamuelSays.mp3");
    GreenfootSound samuelLeft = new GreenfootSound("SamuelLeft.mp3");
    GreenfootSound samuelRight = new GreenfootSound("SamuelRight.mp3");

    private enum Direction { LEFT, RIGHT, UNKNOWN };
    private static Direction direction = Direction.LEFT; 

    private int nextCheck = 9500;

    private SimpleTimer timer = new SimpleTimer();

    private static boolean justChecked = false;

    private boolean hasSamuelSaid = false;

    private static boolean samuelSaid = false;

    private static boolean check = false;

    private boolean firstAct = false;

    public FlagManSign(){    }

    public void act(){
        if(firstAct){
            timer.mark();
            direction = Direction.UNKNOWN;
        }

        //give the player the direction
        if((timer.millisElapsed() >= nextCheck - 1000) && (!hasSamuelSaid)){
            int doesSamuelSay = Greenfoot.getRandomNumber(2); //[0, 11]
            //60% chance of saying Simon Says
            if(doesSamuelSay == 0){
                samuelSays.play();
                samuelSaid = true;
            }
            else{
                samuelSaid = false;
            }
            hasSamuelSaid = true;
        }
        if(timer.millisElapsed() >= nextCheck) {
            //unknown sign, then randomize
            int leftOrRight = Greenfoot.getRandomNumber(2); //[0, 1]

            if(leftOrRight > 0){
                if(samuelSaid){
                    FlagManSign.direction = Direction.LEFT;
                }
                else{
                    FlagManSign.direction = Direction.RIGHT;
                }
                setImage(leftSign);
                samuelLeft.play();
            }
            else{
                if(samuelSaid){
                    FlagManSign.direction = Direction.RIGHT;
                }
                else{
                    FlagManSign.direction = Direction.LEFT;
                }
                setImage(rightSign);
                samuelRight.play();
            }
            timer.mark();
            nextCheck = Greenfoot.getRandomNumber(2000) + 4000; // [4000, 6000]

            FlagManSign.justChecked = true;
        }

        //Check if the player did good
        if((timer.millisElapsed() >= 2000) && (FlagManSign.justChecked)){
            FlagManSign.check = true;
        }
        if((timer.millisElapsed() >= 2500) && (FlagManSign.justChecked)){
            FlagManSign.check = false;
            //cleaning up for next cycle
            setImage(unknownSign);
            FlagManSign.direction = Direction.UNKNOWN;
            FlagManSign.justChecked = false;
            hasSamuelSaid = false;
        }
    }

    public static String getDirection(){
        return String.valueOf(FlagManSign.direction);
    }

    public static boolean getJustChecked(){
        return FlagManSign.justChecked;
    }

    public static boolean getSamuelSaid(){
        return samuelSaid;
    }

    public static boolean getCheck(){
        return FlagManSign.check;
    }

    public static boolean getUnknown(){
        return direction == Direction.UNKNOWN;
    }
}
