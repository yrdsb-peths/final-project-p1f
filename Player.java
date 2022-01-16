import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/* 
 * Player that plays minigames
 * 
 * @param name player name (eg mario, luigi)
 * @param scale player sprite size scale
 */
public class Player extends SmoothMover {
    private String name;
    private float scale;
    protected Animation lWalk, rWalk, lIdle, rIdle;

    protected enum Direction {
        LEFT, RIGHT
    };

    protected Direction dir;

    protected enum AnimState {
        IDLE, MOVE
    };

    protected AnimState animState;

    public Player(String name, float scale) {
        this.name = name;
        this.scale = scale;
        dir = Direction.RIGHT;
        animState = AnimState.IDLE;
        setupAnim();
    }

    public void act() {
        if (getWorld().getClass() == MemoryMatch.class) {
            playMemoryMatch();
        } else if (getWorld().getClass() == Look.class) {
            playLook();
        }
        updateAnim();
    }

    protected void updateAnim() {
        if (lastMove.getExactX() > 0) {
            dir = Direction.RIGHT;
        } else if (lastMove.getExactX() < 0) {
            dir = Direction.LEFT;
        }

        if (lastMove.getExactX() == 0 && lastMove.getExactY() == 0) {
            animState = AnimState.IDLE;
        } else {
            animState = AnimState.MOVE;
        }

        if (animState == AnimState.IDLE) {
            switch (dir) {
                case LEFT:
                    lIdle.animate();
                    break;
                case RIGHT:
                    rIdle.animate();
                    break;
            }
        } else if (animState == AnimState.MOVE) {
            switch (dir) {
                case LEFT:
                    lWalk.animate();
                    break;
                case RIGHT:
                    rWalk.animate();
                    break;
            }
        }
    }

    /**
     * setup animation based on name
     */
    private void setupAnim() {
        String file = "";
        switch (name) {
            case "Mario":
                file = "Mario/anim/L";
                break;
            case "Luigi":
                file = "Luigi/anim/L";
                break;
            case "Red":
                file = "koopa/redL";
                break;
            case "Green":
                file = "koopa/greenL";
                break;
            case "Yellow":
                file = "koopa/yellowL";
                break;
            case "Purple":
                file = "koopa/purpleL";
                break;
            case "Silver":
                file = "koopa/silverL";
                break;
            default:
                file = "Mario/anim/L";
                break;
        }
        lWalk = new Animation(this, file, 2, 5, this.scale);
        rWalk = new Animation(this, file, 2, 5, this.scale, true);
        lIdle = new Animation(this, file, 1, 5, this.scale);
        rIdle = new Animation(this, file, 1, 5, this.scale, true);
    }

    protected void playMemoryMatch() { }

    protected Vector2 lookTarget;
    private int suitType = -1;
    protected void playLook() {
        if (lookTarget != null) {
            if (moveTowards(lookTarget, 5f)) {
                // get object within range of Suit.class
                List<Suit> near = getObjectsInRange(200, Suit.class);
                assert near.size() <= 2 : "too many Suits near player";
                for (Suit suit : near) {
                    if (suit.isCenter()) continue;
                    suitType = suit.getType();
                }
            } else {
                suitType = -1;
            }
        }
    }
    public int getSuit() { return suitType;  }
    public void resetTarget() { lookTarget = null; }

    public String getName() {
        return this.name;
    }

    public GreenfootImage getRightImage() {
        return rWalk.getImage(0);
    }
}
