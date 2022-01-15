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
    private int time = 3;
    GreenfootSound bgm = new GreenfootSound("LookBGM.mp3");
    Label coinLabel;
    int coinCount;
    int lv = 1;
    Suit suit1, suit2, suit3, suit4;
    Player player;
    ArrayList <Integer> heartLoc;
    /**
     * Constructor for objects of class DontLook.
     * 
     */
    public Look() {
        prepareSuits();
        prepare();
    }

    public void prepare() {
        setBackground(new GreenfootImage("LookBKG2.png"));
        //bgm.play();
        
        addObject(timeCount,110,85);
        timeCount.setValue(time); 

        addObject(new Coins(), 620, 80);
        coinLabel = new Label(coinCount,50);
        addObject(coinLabel,620,80);

        addObject(new Level(), 315, 75);

        player = new Player();
        addObject(player, getWidth()/2,getHeight()/2);
    }

    public void prepareSuits() {
        suit1 = new Suit();
        addObject(suit1, 501,60);
        suit2 = new Suit();
        addObject(suit2, 501,540);
        suit3 = new Suit();
        addObject(suit3, 61,300);
        suit4 = new Suit();
        addObject(suit4, 939,300);
    }

    public void act() {
        timeCountDown();
        if (lv == 7) {
            Greenfoot.setWorld(new WorldMap());
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
        if (tim.millisElapsed() * 1000 == timeCount.getValue()) { //if time limit is reached
            lv++;
            Greenfoot.playSound("LevelUp.wav");
            checkMatch();
            suit1.setSuit();
            suit2.setSuit();
            suit3.setSuit();
            suit4.setSuit();
            Greenfoot.playSound("Beep.wav");
            timeCount.setValue(time); 
        }
    }

    public void updateCoins() {
        getObjects(Coins.class).get(0).timeCount.setValue(2); 
        getObjects(Coins.class).get(0).coinSpin = true;
        coinCount++;
        
        removeObject(coinLabel);
        coinLabel = new Label(coinCount,50);
        addObject(coinLabel,620,80);
    }

    
    public boolean checkAll() {
        for (int i = 0; i < heartLoc.size(); i++) {
            if (player.checkPlayer() == heartLoc.get(i)) {
                return true;
            }
        }
        return false;
    }
    
    public void checkMatch() {
        heartLoc = new ArrayList<Integer>(4);
        if (suit1.suitType == 3) {
            heartLoc.add(1);
        }
        if (suit2.suitType == 3) {
            heartLoc.add(2);
        }
        if (suit3.suitType == 3) {
            heartLoc.add(3);
        }
        if (suit4.suitType == 3) {
            heartLoc.add(4);
        }
        if (heartLoc.isEmpty()) {
            heartLoc.add(0);
        }

        if (checkAll()) {
            updateCoins();
            Greenfoot.playSound("Coin.wav");
        } else {
            Greenfoot.playSound("Dissapointed.wav");
        }
    }

}

