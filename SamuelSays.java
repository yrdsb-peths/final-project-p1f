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

    private SimpleTimer counterTimer = new SimpleTimer();
    private Counter samuelSaysTimer = new Counter();
    private int gameTime = 30; //30s time limit
    private SimpleTimer gameOverTimer;
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
        samuelSaysTimer.setValue(gameTime);
        addObject(samuelSaysTimer, 115, 85);
    }

    public void act(){
        super.act();

        if(counterTimer.millisElapsed() >= 1000){ //count down by 1 second every second
            samuelSaysTimer.add(-1);
            counterTimer.mark();
            if(samuelSaysTimer.getValue() < 0){
                samuelSaysTimer.setValue(0);
            }
        }

        // if timer is up or no players left, end game
        if(gameOverTimer == null){
            if((levelTimer.millisElapsed() >= gameTime * 1000) || getObjects(Player.class).size() == 0){
                gameOverTimer = new SimpleTimer();
                gameOverTimer.mark();
            }
        } else {
            if(gameOverTimer.millisElapsed() >= 3000){
                removeObject(flagMan);
                removeObject(flagSign);
                updateWorld();
            }
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
