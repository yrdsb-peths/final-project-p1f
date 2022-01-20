import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Provide users with 4 player options
 * 
 * @author Kevin
 * @version (a version number or a date)
 */
public class CharacterSelect extends World
{
    private GreenfootSound charSelect = new GreenfootSound("CharacterSelectr.mp3");
    
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
        setBackground(charSelectBackground);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        CharSelectChar mario = new CharSelectChar("Mario");
        CharSelectChar luigi = new CharSelectChar("Luigi");

        CharSelectChar koopaP = new CharSelectChar("KoopaPurple");
        CharSelectChar koopaR = new CharSelectChar("KoopaRed");

        addObject(mario, 616, 475);
        addObject(luigi, 840, 480);
        addObject(koopaP, 165, 465);
        addObject(koopaR, 388, 463);
    }
    
    /**
     * Allows the player to select 1 out of 4 avaliable characters.
     * The selection must be done before the game continues to WorldMap.
     */
    public void act(){
        if(CharSelectChar.getNumClicks() >= 1) {
            MainSound.stop();
            WorldMap world = new WorldMap();
            Greenfoot.setWorld(world);
        }
    }
}
