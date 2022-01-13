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
    private int pathIdx, steps;
    
    public enum State { DICE, MOVE, IDLE };
    private State state;
    
    private enum Direction { LEFT, RIGHT };
    private Direction dir; 
    
    public MapCharacter() {
        this("Unnamed"); 
    }
    
    public MapCharacter(String name) {
        this.name = name;
        pathIdx = 0;
        // Vector2 startPos = WorldMap.instance.getPath().get(0).getPos();
        // pos = new Vector2(startPos); 
        dir = Direction.LEFT;
        state = State.IDLE;
        setupAnim();
    }
    
    public void act() {
        updateAnim();
    }
    
    public boolean followPath() {
        MapNode nextNode = WorldMap.instance.getPath().get(pathIdx);
        if (moveTowards(nextNode.getPos(), 2.5f)) {
            nextNode.pass(this);
            pathIdx = (pathIdx+1) % WorldMap.instance.getPath().size();
            if (steps==0) {
                nextNode.activate(this);
                System.out.println("finished walking");
                return true;
            }
        }
        return false;
    }
    
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
    
    protected abstract void setupAnim();
    public abstract void dice();
    
    public String getName() { return this.name; }
    public State getState() { return this.state; }
    public void setState(State state) { this.state = state; }
    public void setSteps(int steps) { this.steps = steps; }
    public void decreaseStep() { this.steps--; }
}
