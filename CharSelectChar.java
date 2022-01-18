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
    public static String playerChoice;
    private String thisName;
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
}
