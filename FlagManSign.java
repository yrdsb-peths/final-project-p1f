import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * FlagManSign changes direction for player to follow
 * 
 * @author Kevin Wang
 * @version January 2022
 */
public class FlagManSign extends FlagMan
{
    //various directional files
    GreenfootImage leftSign = new GreenfootImage("signLeft.png");
    GreenfootImage rightSign = new GreenfootImage("signRight.png");
    GreenfootImage unknownSign = new GreenfootImage("uniFlag.png");

    GreenfootSound samuelSays = new GreenfootSound("SamuelSays.mp3");
    GreenfootSound samuelLeft = new GreenfootSound("SamuelLeft.mp3");
    GreenfootSound samuelRight = new GreenfootSound("SamuelRight.mp3");

    private enum Direction { LEFT, RIGHT, UNKNOWN };
    private Direction direction = Direction.LEFT; 

    //first check is at 3 seconds
    private int nextCheck = 3000;

    private SimpleTimer timer = new SimpleTimer();

    private boolean justChecked = false;

    private boolean hasSamuelSaid = false;

    private boolean samuelSaid = false;

    private boolean check = false;

    private boolean firstAct = true;

    public FlagManSign(){    }

    public void act(){
        if(firstAct){
            timer.mark();
            direction = Direction.UNKNOWN;
            firstAct = false;
        }
        //give the player the direction
        else{
            if((timer.millisElapsed() >= nextCheck - 1000) && (!hasSamuelSaid)){
                int doesSamuelSay = Greenfoot.getRandomNumber(2); //[0, 1]
                // 50% chance of saying Simon Says
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
                // empty sign, then randomize direction
                int leftOrRight = Greenfoot.getRandomNumber(2); //[0, 1]

                if(leftOrRight > 0){
                    if(samuelSaid){
                        direction = Direction.LEFT;
                    }
                    else{
                        direction = Direction.RIGHT;
                    }
                    setImage(leftSign);
                    samuelLeft.play();
                }
                else{
                    if(samuelSaid){
                        direction = Direction.RIGHT;
                    }
                    else{
                        direction = Direction.LEFT;
                    }
                    setImage(rightSign);
                    samuelRight.play();
                }
                timer.mark();
                nextCheck = Greenfoot.getRandomNumber(2000) + 4000; // [4000, 6000]

                justChecked = true;
            }

            // Check if the player did good
            if((timer.millisElapsed() >= 2000) && (this.justChecked)){
                this.check = true;
            }
            if((timer.millisElapsed() >= 2500) && (this.justChecked)){
                this.check = false;
                //cleaning up for next cycle
                setImage(unknownSign);
                direction = Direction.UNKNOWN;
                justChecked = false;
                hasSamuelSaid = false;
            }
        }
    }
    
    /**
     * Return the correct direction to face.
     */
    public String getDirection(){
        return String.valueOf(this.direction);
    }

    /**
     * Return if the program is about to check
     */
    public boolean getJustChecked(){
        return justChecked;
    }

    /**
     * Return if Samuel said to turn a direction or not
     */
    public boolean getSamuelSaid(){
        return samuelSaid;
    }

    /**
     * Return if the program should check directions now
     */
    public boolean getCheck(){
        return check;
    }

    /**
     * Return if the direction is neither left nor right; not checking
     */
    public boolean getUnknown(){
        return direction == Direction.UNKNOWN;
    }
}
