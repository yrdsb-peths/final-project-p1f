import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Cards here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card extends Actor
{
    int id;
    boolean active = false;
    boolean dead = false; 
    static ArrayList<Card> activeCards = new ArrayList<Card>();
    
    SimpleTimer cdTim = new SimpleTimer();
    Counter cdTimeCount = new Counter();
    boolean wait = false;
    /*
     * 
     * cards[0][0] = top left
     * cards[0][1] = top right
     * 
     * if cards[index][0].active and cards[index][1].active:
     *    YOU PICKED A CARD WOOHOO
     * 
     * 
     * A * * A
     * * * * *
     * * * * *
     * 
     */

    Card(int id) {
        this.id = id;
        GreenfootImage constructorCard = new GreenfootImage("Cards/Card1.png");
        constructorCard.scale(60, 108);
        setImage(constructorCard);
        cdTimeCount.setValue(2);
    }
    public void act() {
        if (isTouching(Player.class) && !this.dead && !this.active) { 
            flip();
            activeCards.add(this); 
            if(activeCards.size() == 2) { 
                checkMatch();
            }
        } 
        
        if (wait == true) {
            cdTimeCountDown();   
        }
    }
    public void cdTimeCountDown() {
        if(cdTim.millisElapsed() > 1000) { //time count down every second
            cdTimeCount.add(-1);
            cdTim.mark();
        }

        if (cdTim.millisElapsed() * 1000 == cdTimeCount.getValue()) { //if time limit is reached
            wait = false;
        } 
    }
    public void flip() {
        this.active = !this.active;
        
        if (this.dead) {
            GreenfootImage deadCard = new GreenfootImage("Cards/Card" + (3 + this.id) + ".png");
            deadCard.scale(60, 108);
            setImage(deadCard);
            //wait
            GreenfootImage waitCard = new GreenfootImage("Cards/Card9.png");
            waitCard.scale(60, 108);
            setImage(waitCard);            
        } else if (this.active) {
            GreenfootImage activeCard = new GreenfootImage("Cards/Card" + (3 + this.id) + ".png");
            activeCard.scale(60, 108);
            setImage(activeCard);
        } else if (!this.active) {
            GreenfootImage notActive = new GreenfootImage("Cards/Card" + (3 + this.id) + ".png");
            notActive.scale(60, 108);
            setImage(notActive);
            //wait
            GreenfootImage waitActive = new GreenfootImage("Cards/Card1.png");
            notActive.scale(60, 108);
            setImage(waitActive);
        }
    }
    public void checkMatch() {
        Card a = activeCards.get(0), b = activeCards.get(1); 
        if (a.id == b.id) {
            ((MemoryMatch)getWorld()).coinCount ++; //add coin
            getWorld().getObjects(Coin.class).get(0).timeCount.setValue(2); //coin spin for 2s
            getWorld().getObjects(Coin.class).get(0).coinSpin = true;
            ((MemoryMatch)getWorld()).updateCoins();
            Greenfoot.playSound("Laughter.wav");

            a.dead = true;
            b.dead = true;
        }
        a.flip(); // flip to dead or not collected
        b.flip();
        activeCards.clear();
    }
}
