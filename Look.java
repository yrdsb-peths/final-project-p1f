import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Mini game with 6 rounds that challenges players to follow the target suit each round
 * 
 * @author Eric Zhang, Tanya Gu
 * @version January 2022
 */
public class Look extends MiniGame
{
    private SimpleTimer tim = new SimpleTimer();
    private Counter timeCount = new Counter();
    private int time = 3; // 3s per level  
    private int lv = 1;
    private Suit targetSuit;
    private ArrayList<Suit> suits;
    private Player player;
    private boolean finished = false;

    /**
     * Constructor for objects of class DontLook.
     * 
     */
    public Look() {
        super();
        
        setPaintOrder(Player.class, Suit.class);
        
        // initialize required suits
        suits = new ArrayList<Suit>();
        for (int i=0;i<4;i++) suits.add(null);
        initSuits(); 
        
        prepare();
    }

    /**
     * Method that prepares time countdown, background, background music,
     * players and level
     */
    public void prepare() {
        setBackground(new GreenfootImage("LookBKG3.png"));
        
        MainSound.setSound(new GreenfootSound("LookBGM.mp3"));
        MainSound.play();
        
        addObject(timeCount,110,85);
        timeCount.setValue(time);  

        setupPlayers(3f); // set up players and their locations
        int pos=450, distance=50;
        player = players.get(0);
        for (Player p : players) {
            addObject(p, pos, 400);
            pos += distance;
        }
        
        addObject(new Level(), 315, 75);
    }

    /**
     * Method that prepares different suits each round
     */
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

        // add suits to their corresponding locations
        addObject(suits.get(0), 500,72);
        addObject(suits.get(1), 500,527);
        addObject(suits.get(2), 72,300);
        addObject(suits.get(3), 927,300);
        addObject(targetSuit, 500, 300);
    }

    /**
     * Method that tracks time and level
     * Updates world when reached time limit and game finished
     */
    public void act() {
        timeCountDown();
        if (lv == 7 && !finished) { // when reached 7th level, finish game
            finished = true;
            tim.mark();
        }
        if (finished && tim.millisElapsed() > 2000) { 
            updateWorld();
        }
    }

    /**
     * Method that updates the time counter every second
     * Updates world when reached time limit
     */
    private void timeCountDown() {
        if (finished) return;
        if(tim.millisElapsed() > 1000) { // time count down every second
            Greenfoot.playSound("Second.wav"); 
            timeCount.add(-1);
            tim.mark();
        }
        if (tim.millisElapsed() * 1000 == timeCount.getValue()) { // time limit reached
            lv++;
            if (lv==7) return;
            for (Player p : players) { // reset target for another round
                p.resetTarget();
            }
            Greenfoot.playSound("LevelUp.wav");
            Greenfoot.playSound("Beep.wav");
            timeCount.setValue(time); // reset time for another round
            checkMatch();
            initSuits();
        } 
    }
    
    /**
     * Method that checks if player chose the correct suit
     * If so, adds 1 score 
     */
    private void checkMatch() {
        for (Player p : players) {
            if (p.getSuit() == targetSuit.getType()) { 
                p.addScore(1); 
            } 
        } 

        // sound effects for human palyer
        if (player.getSuit() == targetSuit.getType()) {
            Greenfoot.playSound("Coin.wav");
        } else {
            Greenfoot.playSound("Dissapointed.wav");
        }
    }

    /**
     * Method to get target suit
     */
    public Suit getTargetSuit() {
        return this.targetSuit;
    }

    /**
     * Method to get suits
     */
    public ArrayList<Suit> getSuits() {
        return this.suits;
    }

    /**
     * Method to get current level
     */
    public int getLV() {
        return lv;
    }

    /**
     * Method to get game name
     * 
     * @return game name - Look
     */
    public String toString() {
        return "Look";
    }
}

