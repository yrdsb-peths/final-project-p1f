import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class ShyGuySays here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SamuelSays extends MiniGame
{
    private static FlagManSign flagSign = new FlagManSign();
    private static FlagMan flagMan = new FlagMan();
    
    //initializing the player
    GreenfootImage unknownSign = new GreenfootImage("uniFlag.png");
    GreenfootImage leftFlagMan = new GreenfootImage("flaggerL.png");
    
    GreenfootImage background = new GreenfootImage("SamuelSays.png");
    
    private static SimpleTimer timer = new SimpleTimer();
    /**
     * Constructor for objects of class ShyGuySays.
     * 
     */
    public SamuelSays()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();
        
        this.setBackground(background);
        
        leftFlagMan.scale(80, 80);
        flagMan.setImage(leftFlagMan);
        addObject(flagMan, 200, 480);
        
        flagSign.setImage(unknownSign);
        addObject(flagSign, 185, 254);
        
        MainSound.setSound(new GreenfootSound("The Wide, Wide Ocean  Mario Party Music Extended OST Music [Music OST][Original Soundtrack].mp3"));
        MainSound.play();
    }
    
    protected void firstAct(){
        setupPlayers(3f);
        int pos = 300, distance = 200;
        for (Player p : players) {
            addObject(p, pos, 470);
            pos += distance;
        }
        timer.mark();
    }

    public void act(){
        super.act();
        if((timer.millisElapsed() >= 60000) || getObjects(Player.class).size() == 0){
            updateWorld();
        }
    }
    
    public static int getTime(){
        return timer.millisElapsed();
    }
    
    public String toString(){
        return "SamuelSays";
    }
}
