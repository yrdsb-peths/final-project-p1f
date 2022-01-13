import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DontLook here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DontLook extends MiniGame
{
    private SimpleTimer tim = new SimpleTimer();
    private Counter timeCount = new Counter();
    private int time = 20;
    Label coinLabel;
    int coinCount;
    int lv;
    Arrow arrow;
    Player player;
    /**
     * Constructor for objects of class DontLook.
     * 
     */
    public DontLook()
    {
        prepare();
    }

    public void prepare() {
        addObject(timeCount,90,50);
        timeCount.setValue(time); 

        addObject(new Coins(), 850, 50);
        
        coinLabel = new Label(coinCount,50);
        addObject(coinLabel,920,50);

        addObject(new Level(), getWidth()/2, 40);

        arrow = new Arrow();
        addObject(arrow, getWidth()/2, 200);

        player = new Player();
        addObject(player, getWidth()/2,460);
    }

    public void act() {
        timeCountDown();
        checkPlayerMoves();
        if (tim.millisElapsed() * 1000 == timeCount.getValue()) {
            Greenfoot.setWorld(new WorldMap());
        }
    }

    public void checkPlayerMoves()
    {
        if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("left")
        ||Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("down"))
        {
            checkMatch();
            arrow.setArrow();
        }
    }
    /**
     * Called every act; updates the time counter every second.
     * If time limit is reached...
     */
    public void timeCountDown() {    
        if(tim.millisElapsed() > 1000) { //time count down every second
            Greenfoot.playSound("Second.wav"); 
            timeCount.add(-1);
            tim.mark();
        }
    }

    public void updateCoins() {
        getObjects(Coins.class).get(0).timeCount.setValue(2); 
        getObjects(Coins.class).get(0).coinSpin = true;
        coinCount++;
        removeObject(coinLabel);
        coinLabel = new Label(coinCount,50);
        addObject(coinLabel,920,50);
    }

    public void checkMatch() {
        if (player.checkPlayer() != arrow.arrowType)
        {
            updateCoins();
        } else {
            Greenfoot.playSound("Bad.wav");
        }
    }
}
