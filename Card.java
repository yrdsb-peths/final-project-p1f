import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Cards here.
 * 
 * @author Eric Zhang, Tanya Gu
 * @version January 2022
 */
public class Card extends Actor
{
    int id;
    boolean active = false;
    boolean dead = false; 
    static ArrayList<Card> activeCards = new ArrayList<Card>();
    
    private SimpleTimer cdTimer = new SimpleTimer();
    private boolean wait = false;
    
    /**
     * Constructor for the Card class
     * 
     * @param id ID for each card    
     */
    Card(int id) {
        this.id = id;
        setCardImage("Cards/questioncard.png");  
    }
    
    /**
     * Method that tracks wait time and flip cards if given conditions are true
     */
    public void act() {
        // change to Player.class if include NPC hitboxes (will cause havoc though)
        if (isTouching(HumanPlayer.class) && !this.wait && !this.dead && !this.active) { 
            flip();
        }
        
        if (this.wait) {
            cdTimeCountDown();
        }
    }
    
    /**
     * Method that flips cards based on their status after 1 second of wait time
     */
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
    
    /**
     * Method that flips a card if one's status is active
     * Check if cards match when 2 cards are flipped open
     */
    public void flip() {
        this.active = !this.active;
        if (this.active) {
            setCardImage("Cards/c" + this.id + ".png");
            wait = false;
            activeCards.add(this); // add to activeCards arraylist
            if(activeCards.size() == 2) { 
                checkMatch();
            }
        } else {
            cdTimer.mark();
            wait = true; // wait for 1s before flipping back
        }
    }

    /**
     * Method that resizes all cards images
     */
    private void setCardImage(String file) {
        GreenfootImage image = new GreenfootImage(file);
        image.scale(60, 108);
        setImage(image);
    }

    /**
     * Method that check if cards match based on their ids and determine if 
     * they should be flipped back or can no longer be flipped 
     */
    public void checkMatch() {
        // obtain 2 active cards from the activeCards arraylist
        Card a = activeCards.get(0), b = activeCards.get(1); 
        
        if (a.id == b.id) {
            MemoryMatch world = getWorldOfType(MemoryMatch.class);
            world.addCoin(1);
            Greenfoot.playSound("Laughter.wav");
            
            // cards can no longer be flipped
            a.dead = true; 
            b.dead = true;
        }
        a.flip();
        b.flip();
        activeCards.clear();
    }
}
