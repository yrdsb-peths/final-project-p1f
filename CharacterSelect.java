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
        //TODO: MERGE THE MENU FOLDERS WITH THE NORMAL ONES SO THAT IT CAN INTERFACE
        //WITH WORLDMAP
        CharSelectChar mario = new CharSelectChar("Mario");
        CharSelectChar luigi = new CharSelectChar("Luigi");

        CharSelectChar koopaP = new CharSelectChar("KoopaPurple");
        CharSelectChar koopaR = new CharSelectChar("KoopaRed");

        addObject(mario, 616, 475);
        addObject(luigi, 840, 480);
        addObject(koopaP, 165, 465);
        addObject(koopaR, 388, 463);
        
        MainSound.setSound(charSelect);
        MainSound.play();
    }
    
    public void act(){
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
