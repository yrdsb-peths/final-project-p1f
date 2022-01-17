import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class ScorePopUp here.
 * 
 * @param ArrayList<MapCharacter> players
 * @param ArrayList<Integer> coins to be added to each player
 * 
 */
public class ScorePopUp extends PopUp
{
    
    /**
     * show score changes, sort by points
     */
    private ArrayList<MapCharacter> players;
    private ArrayList<Label> coinLabels;
    private ArrayList<Integer> addedCoins; 
    private SimpleTimer timer;

    public ScorePopUp(ArrayList<MapCharacter> players_, ArrayList<Integer> addedCoins_) {
        super();
        this.players = new ArrayList<MapCharacter>(players_);
        this.addedCoins = addedCoins_;
        
        int y = 50;
        for (MapCharacter p : this.players) {
            GreenfootImage img = new GreenfootImage(p.getRightImage());
            float scale = 2f;
            img.scale((int)(img.getWidth()*scale), (int)(img.getHeight()*scale));
            panel.drawImage(img, 300, y);
            y += 120;
        }
        // just for testing
        for (MapCharacter p : this.players) {
            p.addCoins(Utils.random(10));
            System.out.println(p.getName() + ": " + p.getCoins());
        }
        System.out.println("****");
        // print player coins
        for (MapCharacter p : this.players) {
            System.out.println(p.getName() + ": " + p.getCoins());
        }
        System.out.println("****");
        // show scores as "player.getCoins()" + "addedCoins"
        this.coinLabels = new ArrayList<Label>();
        
        timer = new SimpleTimer();
        timer.mark();
        
        // add scores to players
        // sort player array
        Utils.sort(this.players);
        // sort new player array using new scores
        // "transition" to new player array (gradually move towards)

        // activate continue button
        // after 2 seconds, show scores as "player.getCoins()"
    }

}
