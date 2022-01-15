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
    
    SimpleTimer cdTimer = new SimpleTimer();
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
        setCardImage("Cards/questioncard.png");  
    }
    public void act() {
        // change to Player.class if include NPC hitboxes (will cause havoc though)
        if (isTouching(HumanPlayer.class) && !this.wait && !this.dead && !this.active) { 
            flip();
            activeCards.add(this);
            if(activeCards.size() == 2) { 
                checkMatch();
            }
        }
        
        if (this.wait) {
            cdTimeCountDown();
        }
    }
    public void cdTimeCountDown() {
        if (cdTimer.millisElapsed() > 1000) {
            wait = false;
            if (this.dead) {
                setCardImage("Cards/starcard.png");
            } else {
                setCardImage("Cards/questioncard.png");
            }
        }
    }
    public void flip() {
        this.active = !this.active;
        
        if (this.active) {
            setCardImage("Cards/c" + this.id + ".png");
            wait = false;
        } else {
            cdTimer.mark();
            wait = true;
        }
    }

    private void setCardImage(String file) {
        GreenfootImage image = new GreenfootImage(file);
        image.scale(60, 108);
        setImage(image);
    }

    public void checkMatch() {
        Card a = activeCards.get(0), b = activeCards.get(1); 
        if (a.id == b.id) {
            MemoryMatch world = getWorldOfType(MemoryMatch.class);
            world.addCoin(1);
            Greenfoot.playSound("Laughter.wav");

            a.dead = true;
            b.dead = true;
        }
        a.flip(); // flip to dead or not collected
        b.flip();
        activeCards.clear();
    }
}
