import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

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
    private ArrayList<Player> addedCoins; 
    private SimpleTimer timer;

    public ScorePopUp(ArrayList<MapCharacter> players_, ArrayList<Player> addedCoins_) {
        super();
        this.players = new ArrayList<MapCharacter>(players_);
        this.addedCoins = addedCoins_;
        this.canClose = false;

        for (int i=0;i<players.size();i++) {
            MapCharacter p = players.get(i);
            GreenfootImage img = new GreenfootImage(p.getRightImage());
            float scale = 2f;
            img.scale((int)(img.getWidth()*scale), (int)(img.getHeight()*scale));
            panel.drawImage(img, 300, 50 + i*120);
        }

    }

    public void firstAct() {
        super.firstAct();
        
        // show scores as "player.getCoins()" + "addedCoins"
        this.coinLabels = new ArrayList<Label>();
        for (int i=0;i<players.size();i++) {
            Player score = searchScores(players.get(i).getName());
            Label l = new Label(players.get(i).getCoins() + " + " + score.getScore(), 70);
            coinLabels.add(l);
            getWorld().addObject(l, 500, 120 + i*120);
        }
        
        timer = new SimpleTimer();
        timer.mark();
    }

    public void act() {
        super.act();

        if (!canClose && timer.millisElapsed() > 2000) {
            for (MapCharacter player : this.players) {
                Player score = searchScores(player.getName());
                player.addCoins(score.getScore());
            }
            Utils.sort(this.players);
            
            setupBG();
            
            
            for (int i=0;i<players.size();i++) {
                MapCharacter p = players.get(i);
                GreenfootImage img = new GreenfootImage(p.getRightImage());
                float scale = 2f;
                img.scale((int)(img.getWidth()*scale), (int)(img.getHeight()*scale));
                panel.drawImage(img, 300, 50 + i*120);
                
                //not spawning the score on top
                Label l = coinLabels.get(i);
                l.setValue(players.get(i).getCoins());
            }
            
            canClose = true;
        }
    }

    /**
     * search for player's index in addedCoins arraylist
     * @return Player player object with scores
     */
    private Player searchScores(String name) {
        for (Player score : addedCoins) {
            if (score.getName().equals(name))
                return score;
        }
        return null;
    }

    protected void onExit() {
        super.onExit();
        for (Label l : coinLabels) {
            WorldMap.instance.removeObject(l);
        }
        WorldMap.instance.removeScorePopUp();
    }

}
