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
        if (isTouching(Player.class) && !this.dead && !this.active) {
            this.active = true;
            
            cardFlip(this);
            activeCards.add(this);
            //System.out.println(activeCards.size());
            if(activeCards.size() == 2) {
                checkMatch();    
            }
        }

    }

    public void cardFlip(Card cd) {
        if (cd.active) {
            setImage("Cards/Card" + (3 + this.id) + ".png");
            cd.active = false;
            Greenfoot.delay(15);
        } else if (!cd.active) {
            setImage("Cards/Card1.png");
            cd.active = true;
        } else if (cd.dead) {
            setImage("Cards/Card7.png");
            
        }
    }

    public void checkMatch() {
        //System.out.println(cards.get(0).id +" " + cards.get(1).id);
        if (activeCards.get(0).id == activeCards.get(1).id) {
            //add coin + spin coin
            /*((MemoryMatch)getWorld()).coinCount ++;
            getWorld().getObjects(Coins.class).get(0).coinSpin = true;
            ((MemoryMatch)getWorld()).updateCoins();*/

            //cards.get(0).dead = true;
            //cards.get(1).dead = true;
            cardFlip(activeCards.get(0)); //set dead image
            cardFlip(activeCards.get(1));
            activeCards.clear();
        } else {
            //cards.get(0).active = false;
            //cards.get(1).active = false;
            cardFlip(activeCards.get(0)); //flip back
            cardFlip(activeCards.get(1));
            activeCards.clear();
        }

    }
}
