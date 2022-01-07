import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MapCharacter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class MapCharacter extends SmoothMover
{
    private String name;
    protected Animation lWalk, rWalk, lIdle, rIdle;
    private int pathIdx;
    
    private enum State { IDLE, WALK };
    private State state;
    
    private enum Direction { LEFT, RIGHT };
    private Direction dir; 
    
    public MapCharacter() {
        this("Unnamed");
        pathIdx = 0;
        dir = Direction.LEFT;
        state = State.IDLE;
        setupAnim();
    }
    
    public MapCharacter(String name) {
        this.name = name;
    }
    
    public void act() {
        updateAnim();
        
    }
    
    private void updateAnim() {
        if (state == State.IDLE) {
            switch (dir) {
                case LEFT: lIdle.animate(); break;
                case RIGHT: rIdle.animate(); break;
            }
        } else if (state == State.WALK) {
            switch (dir) {
                case LEFT: lWalk.animate(); break;
                case RIGHT: rWalk.animate(); break;
            }
        }
    }
    
    protected abstract void setupAnim();
    
    public String getName() { return this.name; }
}
