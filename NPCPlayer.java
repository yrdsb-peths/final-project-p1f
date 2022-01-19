import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class NPCPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NPCPlayer extends Player
{
    
    private Vector2 targetPos;
    private SimpleTimer timer;
    private int delay = 0;
    public NPCPlayer(String name, float scale) {
        super(name, scale);

        timer = new SimpleTimer(); 
    }
    
    protected void playMemoryMatch() {
        super.playMemoryMatch();
        if (targetPos == null || moveTowards(targetPos, 3f)) {
            MemoryMatch world = getWorldOfType(MemoryMatch.class);
            Vector2[] cards = world.getCardPositions();
            int idx = Utils.random(cards.length-1);
            targetPos = cards[idx];
            // 20% chance of getting a coin
            if (Utils.random() < 0.20) {
                if (getScore() < 6) { // can only make 6 pairs
                    addScore(1);
                }
            }
        }
    } 
    
    protected void playLook() {
        super.playLook();
        if (lookTarget == null && timer.millisElapsed() > delay) {
            int w = getWorld().getWidth();
            int h = getWorld().getHeight();
            int d = 180;
            
            Vector2[] pos = new Vector2[4];
            pos[0] = new Vector2(w/2, d);
            pos[1] = new Vector2(w/2, h-d);
            pos[2] = new Vector2(d, h/2);
            pos[3] = new Vector2(w-d, h/2);
            
            float r = Utils.random();
            // 70% chance of going to correct one
            // 30% chance of going to a random one
            if (r < 0.7) {
                ArrayList<Suit> suits = getWorldOfType(Look.class).getSuits();
                Suit targetSuit = getWorldOfType(Look.class).getTargetSuit();
                int i=0;
                for (;i<4;i++) {
                    if (suits.get(i).getType() == targetSuit.getType()) 
                        break;
                }
                lookTarget = pos[i];
            } else {
                r = Utils.random();
                lookTarget = pos[(int)(r/0.25)];
            }
            delay = Utils.random(500, 1500);
        }
    }
    
    
    private int moveDir = 0;
    protected void playBombsAway() {
        super.playBombsAway();
        
        try {
            Actor up = getOneObjectAtOffset(0, -500, Bomb.class);
            Actor left = getOneObjectAtOffset(-300, 0, Bomb.class);
            Actor right = getOneObjectAtOffset(300, 0, Bomb.class);
            
            //already checked
            for(int i = -500; i < 0; i++){
                up = getOneObjectAtOffset(0, i, Bomb.class);
                left = getOneObjectAtOffset(i, 0, Bomb.class);
                right = getOneObjectAtOffset(0 - i, 0, Bomb.class);
                
                //If no bomb above, why move?
                if (up != null) {
                //fix this!!!
                if(left == null && right == null){
                    //move left or right
                    int leftOrRight = Greenfoot.getRandomNumber(2); //[0, 1]
                    if(leftOrRight == 0){
                        //move left
                        this.setLocation(this.getX() - 60, this.getY());
                    }else{
                        //move right
                        this.setLocation(this.getX() + 60, this.getY());
                    }
                }else if(left != null && right == null){
                    //move right
                    this.setLocation(this.getX() + 60, this.getY());
                }else if(left == null && right != null){
                    //move left
                    this.setLocation(this.getX() - 60, this.getY());
                }
            }
            }
            /**
            move(new Vector2());
            if (moveDir > 0) {
                move(new Vector2(3f, 0));
                moveDir--;
            } else if (moveDir < 0) {
                move(new Vector2(-3f, 0));
                moveDir++;
            }
            */
        } catch (IllegalStateException e) {
            
        }
    }
    
    public void resetTarget() {
        super.resetTarget();
        timer.mark();
    }
}
