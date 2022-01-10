import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShyGuySays here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShyGuySays extends World
{
    GreenfootSound main = new GreenfootSound("Mario Party (Music) - Dodging Danger.mp3");
    /**
     * Constructor for objects of class ShyGuySays.
     * 
     */
    public ShyGuySays()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        prepare();
    }
    private boolean addedLabel = false;
    Label s = new Label("Simon says turn: ", 40);
    public void act(){
        //3...2...1...start!
        //uncomment when done
        //main.playLoop();
        if(FlagMan.simonSaid && !addedLabel){
            addObject(s, 200, 200);
            addedLabel = true;
        }
        else if(addedLabel){
            try{
                //REMOVING too much!!!
                removeObject(s);
                //to clear the output box
                //System.out.println("removed label!");
            }
            catch(Exception e){System.out.println("no label to remove!");}
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        FlagMan flagMan = new FlagMan();
        addObject(flagMan, 200, 480);

        PlayerSays player = new PlayerSays();
        addObject(player, 600, 460);

        FlagManSign flagSign = new FlagManSign();
        addObject(flagSign, 185, 254);
    }
}
