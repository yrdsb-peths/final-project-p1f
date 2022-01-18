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
    private ArrayList<Suit> suits;
    private Player player;

    /**
     * Constructor for objects of class DontLook.
     * 
     */
    public Look() {
        super();
        
        setPaintOrder(Player.class, Suit.class);
        
        suits = new ArrayList<Suit>();
        for (int i=0;i<4;i++) suits.add(null);
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
            if (suits.get(i) != null) {
                removeObject(suits.get(i));
            }
        }
        if (targetSuit!=null) {
            removeObject(targetSuit);
        }

        while (true) {
            boolean reroll = false;
            for (int i=0;i<4;i++) {
                suits.set(i, new Suit());
            }

            // ensure all 4 suits are unique
            for (int i=0;i<4;i++) {
                for (int j=i+1;j<4;j++) {
                    if (suits.get(i).getType() == suits.get(j).getType()) {
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
        targetSuit = new Suit(suits.get(Utils.random(3)).getType()); 

        addObject(suits.get(0), 500,72);
        addObject(suits.get(1), 500,527);
        addObject(suits.get(2), 72,300);
        addObject(suits.get(3), 927,300);
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
            updateWorld();
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
            if (lv==7) return;
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
    
    private void checkMatch() {
        for (Player p : players) {
            if (p.getSuit() == targetSuit.getType()) {
                // updateCoins();

                getObjects(Coin.class).get(0).setSpin(3);
                p.addScore(1);
                coinCount++;
                coinLabel.setValue(coinCount);
            }
            // System.out.print("(" + p.getName() + ", " + p.getScore() + ") ");
            // update score labels
        }
        // System.out.println();

        // sound effects for human palyer
        if (player.getSuit() == targetSuit.getType()) {
            Greenfoot.playSound("Coin.wav");
        } else {
            Greenfoot.playSound("Dissapointed.wav");
        }
    }

    public Suit getTargetSuit() {
        return this.targetSuit;
    }

    public ArrayList<Suit> getSuits() {
        return this.suits;
    }

    public int getLV() {
        return lv;
    }

    public String toString() {
        return "Look";
    }
}

