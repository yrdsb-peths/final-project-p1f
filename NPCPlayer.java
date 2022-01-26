import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Different NPC player control methods, speed and targets are determined according to 
 * different games
 * 
 * @author Eric Zhang, Kevin Wang
 * @version January 2022 
 */
public class NPCPlayer extends Player {
    private Vector2 targetPos;
    private SimpleTimer timer;
    private int delay = 0;

    /**
     * Constructor for the NPCPlayer class - calls its superclass and initializes a timer
     * 
     * @param name player name (eg mario, luigi)
     * @param scale player sprite size scale
     */
    public NPCPlayer(String name, float scale) {
        super(name, scale);
        timer = new SimpleTimer();
    }

    /**
     * NPCs randomly move between cards
     */
    protected void playMemoryMatch() {
        super.playMemoryMatch();
        if (targetPos == null || moveTowards(targetPos, 3f)) {
            MemoryMatch world = getWorldOfType(MemoryMatch.class);
            Vector2[] cards = world.getCardPositions();
            int idx = Utils.random(cards.length - 1);
            targetPos = cards[idx];
            // 25% chance of getting a coin
            if (Utils.random() < 0.25) {
                if (getScore() < 6) { // can only make 6 pairs
                    addScore(1);
                }
            }
        }
    }

    /**
     * Method that moves player towards one of the 4 suits
     */
    protected void playLook() {
        super.playLook();
        if (lookTarget == null && timer.millisElapsed() > delay) {
            int w = getWorld().getWidth();
            int h = getWorld().getHeight();
            int d = 180;

            Vector2[] pos = new Vector2[4];
            pos[0] = new Vector2(w / 2, d);
            pos[1] = new Vector2(w / 2, h - d);
            pos[2] = new Vector2(d, h / 2);
            pos[3] = new Vector2(w - d, h / 2);

            float r = Utils.random();
            // 90% chance of going to correct one
            // 10% chance of going to a random one
            if (r < 0.7) {
                ArrayList<Suit> suits = getWorldOfType(Look.class).getSuits();
                Suit targetSuit = getWorldOfType(Look.class).getTargetSuit();
                int i = 0;
                for (; i < 4; i++) {
                    if (suits.get(i).getType() == targetSuit.getType())
                        break;
                }
                lookTarget = pos[i];
            } else {
                r = Utils.random();
                lookTarget = pos[(int) (r / 0.25)];
            }
            delay = Utils.random(500, 1500);
        }
    }

    private int moveDir = 0;

    /**
     * NPC moves away from the bombs when detected above, left, or right
     */
    protected void playBombsAway() {
        super.playBombsAway();

        if (getWorld() == null) return;
        Actor up = null;
        Actor left = null;
        Actor right = null;

        for (int i = -40; i <= 40; i+=5) {
            if (up == null) {
                for (int y=50;y<=200;y+=10) {
                    if (getOneObjectAtOffset(i, -y, Bomb.class) != null) {
                        up = getOneObjectAtOffset(i, -150, Bomb.class);
                        break;
                    }
                }
            }
            if (left == null)
                left = getOneObjectAtOffset(-30, 50+i, Bomb.class);
            if (right == null)
                right = getOneObjectAtOffset(30, 50+i, Bomb.class);
        }
        if (up != null) {
            if (left==null && right==null) { 
                if (up.getX() < getX()) {
                    moveDir = 1;
                } else if (up.getX() > getX()) {
                    moveDir = -1;
                }
            } else if (left != null) {
                moveDir = 1;
            } else if (right != null) {
                moveDir = -1;
            }
        } else {
            moveDir = 0;
        }
        move(new Vector2(moveDir * 3f, 0)); 
    }

    /**
     * NPC detects shells and jump (high / low)
     */
    protected void playSpeedyShells() {
        super.playSpeedyShells();

        if (getWorld()==null) return;

        if (touchShellGround()) {
            // detects shell
            Actor left = getOneObjectAtOffset(-50, 30, Shell.class);
            Actor right = getOneObjectAtOffset(50, 30, Shell.class); 
            if (left!=null || right!=null) {
                float r = Utils.random();
                // 10% chance of "missing jump"
                if (r < 0.1f) {
                    return;
                }
                r = Utils.random();
                // 50% chance to jump high / low
                if (r < 0.5f) 
                    jumpHighShell();
                else
                    jumpShell();
            }
        }
    }
    
    private boolean acted = false;
    /**
     * NPC change direction according to sign
     */
    protected void playSamuelSays(){
        super.playSamuelSays();
        if((!acted) && (thisSamuel.getFlagManSign().getJustChecked())){
            int rightOrWrong = Greenfoot.getRandomNumber(10) + 1; //[1 - 10]
            //80% chance to get it right
            if(rightOrWrong <= 8){
                if(thisSamuel.getFlagManSign().getDirection().equals("LEFT")){
                    playerDirection = PlayerDirection.LEFT;
                }
                else{
                    playerDirection = PlayerDirection.RIGHT;
                }
            }
            else{
                if(thisSamuel.getFlagManSign().getDirection().equals("LEFT")){
                    playerDirection = PlayerDirection.RIGHT;
                }
                else{
                    playerDirection = PlayerDirection.LEFT;
                }
            }
            acted = true;
        }
        if(!thisSamuel.getFlagManSign().getJustChecked()){
            acted = false;
        }
    }

    public void resetTarget() {
        super.resetTarget();
        timer.mark();
    }
}
