import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CharacterSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharacterSelect extends World
{
    private GreenfootSound charSelect = new GreenfootSound("CharacterSelectr.mp3");
    /**
     * Constructor for objects of class CharacterSelect.
     * 
     */
    public CharacterSelect()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //TODO: MERGE THE MENU FOLDERS WITH THE NORMAL ONES SO THAT IT CAN INTERFACE
        //WITH WORLDMAP
        CharSelectChar mario = new CharSelectChar("Mario");
        CharSelectChar luigi = new CharSelectChar("Luigi");
        
        CharSelectChar koopaP = new CharSelectChar("KoopaPurple");
        CharSelectChar koopaY = new CharSelectChar("KoopaYellow");
        
        addObject(mario, 320, 300);
        addObject(luigi, 470, 305);
        addObject(koopaP, 630, 300);
        addObject(koopaY, 780, 300);
    }
    
    public void act(){
        charSelect.play();
        if(CharSelectChar.getNumClicks() >= 1){
            charSelect.stop();
            WorldMap world = new WorldMap();
            Greenfoot.setWorld(world);
        }
        /**
        System.out.println(String.valueOf(CharSelectChar.getNumClicks()));
        System.out.println(CharSelectChar.getPlayerChoice());
        */
    }
}
