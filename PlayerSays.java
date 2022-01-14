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
    GreenfootImage right = new GreenfootImage("WalkR1.png");
    GreenfootImage fail = new GreenfootImage("failureMario.png");
    
    private enum PlayerDirection{ LEFT, RIGHT};
    private static PlayerDirection playerDirection = PlayerDirection.LEFT;
    public static boolean alive;
    
    //To prevent the player from rapidly pressing a and d to always win
    //private SimpleTimer lastMove = new SimpleTimer();
    
    public PlayerSays(){
        left.scale(100, 100);
        right.scale(100, 100);
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
    }
    
    public static String getDirection(){
        return String.valueOf(PlayerSays.playerDirection);
    }
    
    public static void setDirection(boolean isLeft){
        if(isLeft){
            PlayerSays.playerDirection = PlayerDirection.LEFT;
        }
        else{
            PlayerSays.playerDirection = PlayerDirection.RIGHT;
        }
    }
    /**
    private boolean inTheGame = true;
    //to prevent the player from changing their mind
    private boolean canMove = false;
    //Direction of the player. Is a string so the player cant lose at the start of the game
    private String meDirection = "";
    
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    /**
    public void act()
    {
        //Kind of janky. fix later.
        //GOOD NOW?
        if(inTheGame){
            if(!FlagMan.needToCheck){
                canMove = true;
            }
            if(Greenfoot.isKeyDown("a") && canMove){
                setImage(left);
                meDirection = "left";
                canMove = false;
            }
            if(Greenfoot.isKeyDown("d") && canMove){
                setImage(right);
                meDirection = "right";
                canMove = false;
            }
            if(FlagMan.needToCheck){
                //to catch "" error
                //try removing it
                if(meDirection.equals(FlagMan.direction))
                {
                    System.out.println("correct!");
                }
                else
                {
                    inTheGame = false; 
                    setImage(fail);  
                    meDirection = "";
                    death.play();
                }
            }        
        }
    }
    */
}
