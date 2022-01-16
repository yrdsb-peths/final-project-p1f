import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class DontLook here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Look extends MiniGame
{
    private SimpleTimer tim = new SimpleTimer();
    private Counter timeCount = new Counter();
    private int time = 3; //3s per level 
    private Label coinLabel;
    private int coinCount;
    private int lv = 1;
    private Suit targetSuit;
    private Suit[] suits;
    private Player player;

    /**
     * Constructor for objects of class DontLook.
     * 
     */
    public Look() {
        super();
        
        setPaintOrder(Player.class, Suit.class);
        
        suits = new Suit[4];
        initSuits(); 
        
        prepare();

        setupPlayers(3f);
        int pos=450, distance=50;
        player = players.get(0);
        for (Player p : players) {
            addObject(p, pos, 400);
            pos += distance;
        }
    }

    public void prepare() {
        setBackground(new GreenfootImage("LookBKG3.png"));
        
        MainSound.setSound(new GreenfootSound("LookBGM.mp3"));
        MainSound.play();
        
        addObject(timeCount,110,85);
        timeCount.setValue(time); 

        addObject(new Coin(), 620, 80);
        coinLabel = new Label(coinCount,50);
        addObject(coinLabel,620,80);

        addObject(new Level(), 315, 75);
    }

    private void initSuits() {
        for (int i=0;i<4;i++) {
            if (suits[i]!= null) {
                removeObject(suits[i]);
            }
        }
        if (targetSuit!=null) {
            removeObject(targetSuit);
        }

        while (true) {
            boolean reroll = false;
            for (int i=0;i<4;i++) {
                suits[i] = new Suit();
            }

            for (int i=0;i<4;i++) {
                for (int j=i+1;j<4;j++) {
                    if (suits[i].getType() == suits[j].getType()) {
                        reroll = true;
                        break;
                    }
                }
            }
            if (!reroll) {
                break;
            }
        }
        // pick random suit and set it as target
        targetSuit = new Suit(suits[Utils.random(3)].getType()); 

        addObject(suits[0], 500,72);
        addObject(suits[1], 500,527);
        addObject(suits[2], 72,300);
        addObject(suits[3], 927,300);
        addObject(targetSuit, 500, 300);
    }

    private boolean finished = false;
    public void act() {
        timeCountDown();
        if (lv == 7 && !finished) { //when reached 7th level, return to main world
            finished = true;
            tim.mark();
        }
        if (finished && tim.millisElapsed() > 2000) { //if time limit is reached
            MainSound.stop();
            if (WorldMap.instance != null) 
                Greenfoot.setWorld(WorldMap.instance);
        }
    }

    /**
     * Called every act; updates the time counter every second.
     * If time limit is reached...
     */
    private void timeCountDown() {
        if (finished) return;
        if(tim.millisElapsed() > 1000) { //time count down every second
            Greenfoot.playSound("Second.wav"); 
            timeCount.add(-1);
            tim.mark();
        }
        if (tim.millisElapsed() * 1000 == timeCount.getValue()) { //if time limit is reached
            lv++;
            for (Player p : players) {
                p.resetTarget();
            }
            Greenfoot.playSound("LevelUp.wav");
            Greenfoot.playSound("Beep.wav");
            timeCount.setValue(time); 
            checkMatch();
            initSuits();
        } 
    }

    private void updateCoins() {
        getObjects(Coin.class).get(0).setSpin(3);
        coinCount++;
        
        removeObject(coinLabel); 
        coinLabel = new Label(coinCount,50);
        addObject(coinLabel,620,80);
    }
    
    private void checkMatch() {
        if (player.getSuit() == targetSuit.getType()) {
            updateCoins();
            Greenfoot.playSound("Coin.wav");
        } else {
            Greenfoot.playSound("Dissapointed.wav");
        }
    }

    public int getLV() {
        return lv;
    }
}

