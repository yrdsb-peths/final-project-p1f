import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerSays extends Actor
{
    GreenfootImage left = new GreenfootImage("WalkL1.png");
    GreenfootImage idle = new GreenfootImage("WalkF1.png");
    GreenfootImage right = new GreenfootImage("WalkR1.png");
    GreenfootImage fail = new GreenfootImage("failureMario.png");
    
    private enum PlayerDirection{ LEFT, RIGHT, UNKNOWN};
    private static PlayerDirection playerDirection = PlayerDirection.LEFT;
    public static boolean alive;
    
    //To prevent the player from rapidly pressing a and d to always win
    //private SimpleTimer lastMove = new SimpleTimer();
    
    public PlayerSays(){
        left.scale(100, 100);
        right.scale(100, 100);
        idle.scale(100, 100);
        fail.scale(100, 100);
        //lastMove.mark();
    }
    
    public void act(){
        if(this.alive){
            if(Greenfoot.isKeyDown("a")){
                PlayerSays.playerDirection = PlayerDirection.LEFT;
                setImage(left);
            }
            if(Greenfoot.isKeyDown("d")){
                PlayerSays.playerDirection = PlayerDirection.RIGHT;
                setImage(right);
            }
            //lastMove.mark();
        }
        else{
            setImage(fail);
        }
        if(PlayerSays.playerDirection == PlayerDirection.UNKNOWN){
            setImage(idle);
        }
    }
    
    public static String getDirection(){
        return String.valueOf(PlayerSays.playerDirection);
    }
    
    public static void setUnknown(){
        PlayerSays.playerDirection = PlayerDirection.UNKNOWN;
    }
}
