import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CharSelectChars here.
 * 
 * @author Kevin Wang
 * @version January 2022
 */
public class CharSelectChar extends Actor
{
    private static int numClicks;
    public static String playerChoice = "Mario";
    private String thisName;
    
    /**
     * Constructor for the class CharSelectChar - tracks and prepares 
     * players' images and names
     * 
     * @param player 
     */
    public CharSelectChar(String player){
        GreenfootImage waitToPick = new GreenfootImage(player + "/menu.png");
        if(player.equals("Luigi")){
            waitToPick.scale(130, 130);
        }
        else if(player.equals("Mario")){
            waitToPick.scale(70, 98);
        }
        else{
            waitToPick.scale(70, 132);
        }
        setImage(waitToPick);
        CharSelectChar.playerChoice = "";
        thisName = player;
        
        CharSelectChar.playerChoice = "";
        CharSelectChar.numClicks = 0;
    }
    
    /**
     * Method that tracks the user's clickings
     * Generates player choice and number of clicks when the user clicked a player
     */
    public void act() 
    {
        if(Greenfoot.mousePressed(this)){
            playerChoice = thisName;
            numClicks++;
        }
    }   
    
    /**
     * Method to get number of clicks
     * 
     * @return CharSelectChar.numClicks
     */
    public static int getNumClicks(){
        return CharSelectChar.numClicks;
    }
}
