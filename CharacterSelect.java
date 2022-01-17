import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CharacterSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharacterSelect extends World
{
    
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
        CharSelectChar mario = new CharSelectChar("MarioMenu");
        CharSelectChar luigi = new CharSelectChar("LuigiMenu");
        
        CharSelectChar koopaG = new CharSelectChar("KoopaGreen");
        CharSelectChar koopaP = new CharSelectChar("KoopaPurple");
        CharSelectChar koopaR = new CharSelectChar("KoopaRed");
        CharSelectChar koopaS = new CharSelectChar("KoopaSilver");
        CharSelectChar koopaY = new CharSelectChar("KoopaYellow");
        
        addObject(mario, 200, 300);
        addObject(luigi, 300, 305);
        addObject(koopaG, 400, 300);
        addObject(koopaP, 500, 300);
        addObject(koopaR, 600, 300);
        addObject(koopaS, 700, 300);
        addObject(koopaY, 800, 300);
    }
    
    public void act(){
        if(CharSelectChar.getNumClicks() >= 1){
            WorldMap world = new WorldMap();
            Greenfoot.setWorld(world);
        }
        /**
        System.out.println(String.valueOf(CharSelectChar.getNumClicks()));
        System.out.println(CharSelectChar.getPlayerChoice());
        */
    }
}
