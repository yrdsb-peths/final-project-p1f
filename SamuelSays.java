import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * SamuelSays minigame
 * 
 * @author Kevin Wang
 * @version January 2022
 */
public class SamuelSays extends MiniGame
{
    FlagManSign flagSign; 
    FlagMan flagMan; 
    
    //initializing the player
    GreenfootImage unknownSign = new GreenfootImage("uniFlag.png");
    GreenfootImage leftFlagMan = new GreenfootImage("flaggerL.png");
    
    GreenfootImage background = new GreenfootImage("SamuelSays.png");
    
    private SimpleTimer levelTimer = new SimpleTimer();
    /**
     * Constructor for objects of class ShyGuySays.
     * 
     */
    public SamuelSays()
    {
        super();
        
        this.setBackground(background);
        
        flagMan = new FlagMan();
        leftFlagMan.scale(80, 80);
        flagMan.setImage(leftFlagMan);
        addObject(flagMan, 200, 480);
        
        flagSign = new FlagManSign();
        flagSign.setImage(unknownSign);
        addObject(flagSign, 185, 254);
        
        MainSound.setSound(new GreenfootSound("The Wide, Wide Ocean  Mario Party Music Extended OST Music [Music OST][Original Soundtrack].mp3"));
        MainSound.setVolume(50);
        MainSound.play();
    }
    
    protected void firstAct(){
        setupPlayers(3f);
        int pos = 300, distance = 200;
        for (Player p : players) {
            addObject(p, pos, 470);
            pos += distance;
        }
        levelTimer.mark();
    }

    public void act(){
        super.act();
        // if timer is up or no players left, end game
        if((levelTimer.millisElapsed() >= 30000) || getObjects(Player.class).size() == 0){
            removeObject(flagMan);
            removeObject(flagSign);
            updateWorld();
        }
    }
    
    /**
     * return timer of the game
     * @return 
     */
    public int getTime(){
        return levelTimer.millisElapsed();
    }
    
    /**
     * return current world's FlagManSign
     * @return
     */
    public FlagManSign getFlagManSign(){
        return flagSign;
    }
    
    public String toString(){
        return "SamuelSays";
    }
}
