import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class NPCPlayer here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class NPCPlayer extends Player {
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

    protected void playBombsAway() {
        //If this is touching a bomb, play the defeat sound effect and remove itself
        //The score is equal to the time survived in Bombs Away
        super.playBombsAway();

        try {
            //Initializing actors above, to the left, and to the right
            Actor up = null;
            Actor left = null;
            Actor right = null;
            
            //Check for bombs above, to the left, and to the right
            //If bombs are present, set the actor to the Bomb class
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
            //If there is a bomb above:
            if (up != null) {
                //If there are no bombs beside:
                    //-if the bomb above is closer to the left, move right
                    //else if the bomb above is closer to the right, move left
                if (left==null && right==null) { 
                    if (up.getX() < getX()) {
                        moveDir = 1;
                    } else if (up.getX() > getX()) {
                        moveDir = -1;
                    }
                } else if (left != null) {
                    //If there is a bomb to the left, move right
                    moveDir = 1;
                } else if (right != null) {
                    //If there is a bomb to the right, move left
                    moveDir = -1;
                }
            } else {
                //If there is no threat, do not move
                moveDir = 0;
            }
            //Move around the world
            move(new Vector2(moveDir * 3f, 0));
        } catch (IllegalStateException e) {
            //The NPCs throw an IllegalStateException error if the player is defeated before them, thus the code is in a try and catch
        }
    }
    
    public void resetTarget() {
        super.resetTarget();
        timer.mark();
    }
}
