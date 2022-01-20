import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CharSelectChars here.
 * 
 * @author Kevin Wang
 * @version January 2022
 */
public class CharSelectChar extends Actor
{
    //The number of clicks on all character select characters
    //Initialize as none
    private static int numClicks = 0;
    
    //What character the player chose
    public static String playerChoice = "";
    
    //Private variable on what the object's character is
    //Used later when the player clicks on a character
    private String thisName;
    
    /**
     * Constructor for the class CharSelectChar - tracks and prepares 
     * players' images and names
     * 
     * @param player 
     */
    public CharSelectChar(String player){
        //Initializing with a special image depending on what playable character this object is representing
        GreenfootImage waitToPick = new GreenfootImage(player + "/menu.png");
        
        if(player.equals("Luigi")){
            //If this object represents playable Luigi (Luigi's sprites are smaller than the others), resize accordingly
            waitToPick.scale(130, 130);
        }
        else if(player.equals("Mario")){
            //If this object represents playable Mario (Mario's sprites are somewhat smaller than others), resize accordingly
            waitToPick.scale(70, 98);
        }
        else{
            //If this object represents one of the playable Koopas, resize accordingly
            waitToPick.scale(70, 132);
        }
        
        //Set the image and set the private name variable to player
        setImage(waitToPick);
        thisName = player;
    }
    
    /**
     * Method that tracks the user's clickings
     * Generates player choice and number of clicks when the user clicked a player
     */
    public void act() 
    {
        //If this object was clicked:
            //-set the player's choice to this object's thisName varibale
            //-increase the number of clicks by 1 (affects the CharacterSelect World)
        if(Greenfoot.mousePressed(this)){
            CharSelectChar.playerChoice = thisName;
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
