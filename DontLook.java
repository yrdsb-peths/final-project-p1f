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
    private GreenfootSound bgm = new GreenfootSound("DontLookBGM.mp3");
    private Label coinLabel;
    private int coinCount;
    private Arrow arrow;
    private Player player;
    /**
     * Constructor for objects of class DontLook.
     * 
     */
    public DontLook() {
        prepare();
    }

    public void prepare() {
        //bgm.play();
        
        addObject(timeCount,350,70);
        timeCount.setValue(time); 

        addObject(new Coins(), 620, 70); 
        coinLabel = new Label(coinCount,50);
        addObject(coinLabel,620,70);

        arrow = new Arrow();
        addObject(arrow, getWidth()/2, 200);

        player = new Player();
        addObject(player, getWidth()/2,460);
    }

    public void act() {
        timeCountDown();
        checkPlayerInput();
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
        if (tim.millisElapsed() * 1000 == timeCount.getValue()) {
            Greenfoot.setWorld(new WorldMap());
        }
    }

    public void checkPlayerInput() {
        if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("left")
        ||Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("down")) {
            checkMatch();
            arrow.setArrow();
        }
        Greenfoot.delay(6);
    }

    public void checkMatch() {
        if (player.checkPlayer() != arrow.arrowType) {
            Greenfoot.playSound("Happy.wav"); // perhaps add another sound effect? 1 is a ittle boring
            updateCoins();
        } else {
            Greenfoot.playSound("Bad.wav");
            Greenfoot.playSound("Hurt.wav");
            Greenfoot.setWorld(new WorldMap());
        }
    }
    
    public void updateCoins() {
        getObjects(Coins.class).get(0).timeCount.setValue(2); 
        getObjects(Coins.class).get(0).coinSpin = true;
        coinCount++;
        removeObject(coinLabel);
        coinLabel = new Label(coinCount,50);
        addObject(coinLabel,620,70);
    }
}
