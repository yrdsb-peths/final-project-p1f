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
        setImage("Cards/Card1.png");
    }

    public void act() {
        /*
         * 
         * when active, switch to open card
         * when not active, switch to closed card
         * 
         * when player touches:
         *   toggle active
         *   
         * if two active: check if theyre same ID
         * 
         * 
         */
        if (isTouching(Player.class) && !this.dead && !this.active) { 
            flip();
            activeCards.add(this); 
            if(activeCards.size() == 2) { 
                checkMatch();
            }
        } 
    }

    public void flip() {
        this.active = !this.active;
        
        if (this.dead) {
            System.out.println("death " + this.id);
            setImage("Cards/Card7.png");
        } else if (this.active) {
            setImage("Cards/Card" + (3 + this.id) + ".png");
        } else if (!this.active) {
            setImage("Cards/Card1.png");
        }
    }

    public void checkMatch() {
        Card a = activeCards.get(0), b = activeCards.get(1); 
        if (a.id == b.id) {
            //add coin + spin coin
            /*((MemoryMatch)getWorld()).coinCount ++;
            getWorld().getObjects(Coins.class).get(0).coinSpin = true;
            ((MemoryMatch)getWorld()).updateCoins();*/

            a.dead = true;
            b.dead = true;
        }
        a.flip(); // flip to dead or not collected
        b.flip();
        activeCards.clear();

    }
}
