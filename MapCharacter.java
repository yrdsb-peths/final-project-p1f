import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Decides how animated players act in the world map
 * 
 * @author Eric Zhang
 * @version January 2022 
 */
public abstract class MapCharacter extends SmoothMover implements Comparable<MapCharacter>
{
    private String name;
    protected Animation lWalk, rWalk, lIdle, rIdle;
    private int pathIdx, steps;
    private int coins;
    
    public enum State { DICE, MOVE, IDLE };
    private State state;
    
    private enum Direction { LEFT, RIGHT };
    private Direction dir;
    
    public MapCharacter() {
        this("Unnamed");
    }
    
    /**
     * Constructor for the MapCharacter superclass 
     * 
     * @param name name of character
     */
    public MapCharacter(String name) {
        this.name = name;
        pathIdx = 0;
        dir = Direction.RIGHT;
        state = State.IDLE;
        setupAnim();
        coins = 5;
    }
    
    /**
     * Method that updates characters' animation 
     */
    public void act() {
        updateAnim();
    }

    /**
     * Method thatfollows the path of the world map
     * 
     * @return boolean true if the character has reached the next node in the path
     */
    public boolean followPath() {
        MapNode nextNode = WorldMap.instance.getPath().get(pathIdx);
        if (moveTowards(nextNode.getPos(), 2.5f)) {
            nextNode.pass(this);
            pathIdx = (pathIdx+1) % WorldMap.instance.getPath().size();
            if (steps==0) {
                nextNode.activate(this);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Method to enable animated characters to move
     */
    private void updateAnim() {
        if (lastMove.getExactX() > 0) {
            dir = Direction.RIGHT;
        } else if (lastMove.getExactX() < 0) {
            dir = Direction.LEFT;
        }
        if (state == State.IDLE) {
            switch (dir) {
                case LEFT: lIdle.animate(); break;
                case RIGHT: rIdle.animate(); break;
            }
        } else if (state == State.MOVE) {
            switch (dir) {
                case LEFT: lWalk.animate(); break;
                case RIGHT: rWalk.animate(); break;
            }
        }
    }
    
    /**
     * Method that setups animation based on character name
     */
    private void setupAnim() {
        String file = "";
        switch (name) { 
            case "Mario": file = "Mario/anim/L"; break;
            case "Luigi": file = "Luigi/anim/L"; break;
            case "KoopaRed": file = "koopa/redL"; break;
            case "KoopaGreen": file = "koopa/greenL"; break;
            case "KoopaYellow": file = "koopa/yellowL"; break;
            case "KoopaPurple": file = "koopa/purpleL"; break;
            case "KoopaSilver": file = "koopa/silverL"; break;
            default: file = "Mario/anim/L"; break;
        } 
        lWalk = new Animation(this, file, 2, 5, 2);
        rWalk = new Animation(this, file, 2, 5, 2, true);
        lIdle = new Animation(this, file, 1, 5, 2);
        rIdle = new Animation(this, file, 1, 5, 2, true);
    }

    /**
     * Method that compares to other characters
     * (will be sorted in decreasing order)
     * 
     * @param MapCharacter other
     * @return int -1 if this character is less than other, 0 if equal, 1 if greater
     */
    public int compareTo(MapCharacter other) {
        if (getCoins() == other.getCoins()) {
            return 0;
        } else if (getCoins() > other.getCoins()) {
            return 1;
        } else {
            return -1;
        }
    }

    public abstract void startDice(Dice dice);
    public abstract boolean stopDice(Dice dice);
    public abstract boolean closePopUp();

    /**
     * Method to add coins to the character
     * 
     * @param int coins
     */
    public void addCoins(int coins) {
        this.coins += coins;
        if (this.coins < 0) {
            this.coins = 0;
        }
        WorldMap.instance.updateCoinLabels();
    }
    
    /**
     * Method to get the coins of character
     * 
     * @return int coins
     */
    public int getCoins() { 
        return this.coins; 
    }

    /**
     * Method to get the name of the character
     * 
     * @return String name
     */
    public String getName() { 
        return this.name; 
    }

    /**
     * Method to get the state of the character
     * 
     * @return State mapCharacterState
     */
    public State getState() { 
        return this.state; 
    }

    /**
     * Method to set the state of the character
     * 
     * @param State mapCharacterState
     */
    public void setState(State state) { 
        this.state = state; 
    }

    /**
     * Method to set how many steps the character should take
     * 
     * @param steps number of steps
     */
    public void setSteps(int steps) { 
        this.steps = steps; 
    }

    /**
     * Method to decreases the number of steps the character has left
     */
    public void decreaseStep() { 
        this.steps--; 
    }

    /**
     * Method that returns the character's default image
     * 
     * @return GreenfootImage image
     */
    public GreenfootImage getRightImage() { 
        return rIdle.getImage(0);
    }
}
