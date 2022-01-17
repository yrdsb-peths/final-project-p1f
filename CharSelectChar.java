import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CharSelectChars here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharSelectChar extends Actor
{
    private static int numClicks;
    private static String playerChoice;
    private String thisName;
    public CharSelectChar(String player){
        GreenfootImage waitToPick = new GreenfootImage(player + "/menu.png");
        if(player.equals("LuigiMenu")){
            waitToPick.scale(150, 150);
        }
        else if(player.equals("MarioMenu")){
            waitToPick.scale(90, 134);
        }
        else{
            waitToPick.scale(70, 132);
        }
        setImage(waitToPick);
        CharSelectChar.playerChoice = "";
        thisName = player;
    }
    
    /**
     * Act - do whatever the CharSelectChars wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mousePressed(this)){
            playerChoice = thisName;
            numClicks++;
        }
    }   
    
    public static int getNumClicks(){
        return CharSelectChar.numClicks;
    }
    public static String getPlayerChoice(){
        return CharSelectChar.playerChoice;
    }
}
