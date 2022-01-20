import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Decides how animated players act in different mini-games
 * 
 * @author Eric Zhang
 * @version January 2022 
 */
public class Player extends SmoothMover implements Comparable<Player> {
    private String name;
    private float scale;
    private int score;
    protected Animation lWalk, rWalk, lIdle, rIdle;
    
    protected GreenfootSound jumpSound = new GreenfootSound("jump.mp3");

    protected enum Direction {
        LEFT, RIGHT
    };

    protected Direction dir;

    protected enum AnimState {
        IDLE, MOVE
    };

    protected AnimState animState;

    /**
     * Constructor for the Player superclass 
     * 
     * @param name player name (eg mario, luigi)
     * @param scale player sprite size scale
     */
    public Player(String name, float scale) {
        this.name = name;
        this.scale = scale;
        dir = Direction.RIGHT;
        animState = AnimState.IDLE;
        setupAnim();
        jumpSound.setVolume(40);
    }

    /**
     * Method that decides the animation and method of playing in different mini-games
     */
    public void act() {
        if (getWorld().getClass() == MemoryMatch.class) {
            playMemoryMatch();
            anim2D();
        } else if (getWorld().getClass() == Look.class) {
            playLook();
            anim2D();
        } else if (getWorld().getClass() == BombsAway.class) {
            playBombsAway();
            anim1D();
        } else if (getWorld().getClass() == SpeedyShells.class) {
            playSpeedyShells();
            anim1D();
        }
        updateAnim();
    }

    /**
     * Method to enable players to walk in left/right
     */
    private void anim1D() {
        if (lastMove.getExactX() == 0) {
            animState = AnimState.IDLE;
        } else {
            animState = AnimState.MOVE;
        }
    }

    /**
     * Method to enable players to walk in up/down/left/right
     */
    private void anim2D() {
        if (lastMove.getExactX() == 0 && lastMove.getExactY() == 0) {
            animState = AnimState.IDLE;
        } else {
            animState = AnimState.MOVE;
        }
    }

    /**
     * Method that
     */
    protected void updateAnim() {
        if (lastMove.getExactX() > 0) {
            dir = Direction.RIGHT;
        } else if (lastMove.getExactX() < 0) {
            dir = Direction.LEFT;
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
     * Method that setups animation based on player name
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
            case "KoopaRed":
                file = "koopa/redL";
                break;
            case "KoopaGreen":
                file = "koopa/greenL";
                break;
            case "KoopaYellow":
                file = "koopa/yellowL";
                break;
            case "KoopaPurple":
                file = "koopa/purpleL";
                break;
            case "KoopaSilver":
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

    /**
     * Method that decides the final score of the BombsAway mini-game based on time 
     * and how players die
     */
    protected void playBombsAway() {
        score = getWorldOfType(BombsAway.class).getTime();
        if (this.isTouching(Bomb.class)){
            GreenfootSound death = new GreenfootSound("death.mp3");
            death.play();
            getWorld().removeObject(this);
        }
    }

    protected float yVel = 0;
    protected void playSpeedyShells() { 
        // gravity
        yVel += 0.5f;
        if (yVel > 10) {
            yVel = 10f;
        }
        move(new Vector2(0, yVel)); 
        if (touchShellGround()) {
            yVel = 0;
            setLocation(getExactX(), SpeedyShells.getGround()-20);
        }
        
        // update score
        score = getWorldOfType(SpeedyShells.class).getTime();
        // if touching shell, this player loses
        if (this.isTouching(Shell.class)) {
            GreenfootSound death = new GreenfootSound("death.mp3");
            death.play();
            getWorld().removeObject(this);
        }
    }

    protected void jumpShell() {
        jumpSound.play();
        yVel = -9.5f;
    }
    
    protected void jumpHighShell() {
        jumpSound.play();
        yVel = -13;
    }
    
    protected boolean touchShellGround() {
        return getExactY() >= SpeedyShells.getGround()-20;
    }

    /**
     * Method that compares players based on score
     * 
     * @param other player
     * @return -1 if this player has lower score, 1 if higher, 0 if equal
     */
    public int compareTo(Player other) {
        if (getScore() == other.getScore()) { 
            return 0;
        } else if (getScore() > other.getScore()) {
            return 1;
        } else {
            return -1;
        } 
    }

    public int getSuit() { 
        return suitType;  
    }
    
    public void resetTarget() { 
        lookTarget = null;
    }

    public void setScore(int x) {
        this.score = x;
    }

    public void addScore(int x) {
        this.score += x;
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return this.name;
    }

    public GreenfootImage getRightImage() {
        return rWalk.getImage(0);
    }
}
