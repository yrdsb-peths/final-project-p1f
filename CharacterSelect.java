import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CharacterSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharacterSelect extends World
{
    //The background for the character selection screen
    private GreenfootImage charSelectBackground = new GreenfootImage("backgroundSelect.png");
    
    /**
     * Constructor for objects of class CharacterSelect.
     * 
     */
    public CharacterSelect()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        prepare();
        //Set the background to the character selection screen
        setBackground(charSelectBackground);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //Initializing the special character select characters
        
        //Mario and Luigi
        CharSelectChar mario = new CharSelectChar("Mario");
        CharSelectChar luigi = new CharSelectChar("Luigi");

        //Red Koopa and Purple Koopa
        CharSelectChar koopaP = new CharSelectChar("KoopaPurple");
        CharSelectChar koopaR = new CharSelectChar("KoopaRed");

        //Add these character select characters to the world
        addObject(mario, 616, 475);
        addObject(luigi, 840, 480);
        addObject(koopaP, 165, 465);
        addObject(koopaR, 388, 463);
    }
    
    public void act(){
        //If any of the character select characters have been clicked once or more
        if(CharSelectChar.getNumClicks() >= 1) {
            //Stop playing the main menu music
            MainSound.stop();
            
            //Change the world to the worldmap
            WorldMap world = new WorldMap();
            Greenfoot.setWorld(world);
        }
    }
}
