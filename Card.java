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
    ArrayList<Card> cards = new ArrayList<Card>();
    //Card cards = new Card[6][2];

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
        if (isTouching(Player.class) && !this.dead) {
            this.active = true;
            cardFlip(this);
            cards.add(this);
            if(cards.size() == 2) {
                checkMatch();    
            }
        }

    }

    public void cardFlip(Card cd) {
        if (cd.active) {
            setImage("Cards/Card" + (3 + this.id) + ".png");
            Greenfoot.delay(15);
        } else if (!cd.active) {
            setImage("Cards/Card1.png");
        } else if (cd.dead) {
            setImage("Cards/Card7.png");
        }
    }

    public void checkMatch() {
        if (cards.get(0).id == cards.get(1).id) {
            //add coin + spin coin
            /*((MemoryMatch)getWorld()).coinCount ++;
            getWorld().getObjects(Coins.class).get(0).coinSpin = true;
            ((MemoryMatch)getWorld()).updateCoins();*/

            cards.get(0).dead = true;
            cards.get(1).dead = true;
            cardFlip(cards.get(0)); //set dead image
            cardFlip(cards.get(1));
            cards.clear();
        } else {
            cards.get(0).active = false;
            cards.get(1).active = false;
            cardFlip(cards.get(0)); //flip back
            cardFlip(cards.get(1));
            cards.clear();
        }

    }
}
