import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A variation of an actor that maintains a precise location (using floats for the co-ordinates
 * instead of ints).  This allows small precise movements (e.g. movements of 1 pixel or less)
 * that do not lose precision.
 * 
 * @author Poul Henriksen
 * @author Michael Kolling
 * @author Neil Brown
 * 
 * @version 3.0
 */
public abstract class SmoothMover extends Actor
{ 
    protected Vector2 pos = new Vector2();
    protected Vector2 lastMove = new Vector2();
    
    /**
     * Move forward by the specified distance.
     * (Overrides the method in Actor).
     */
    @Override
    public void move(int distance)
    {
        move((float)distance);
    }
    
    /**
     * Move forward by the specified exact distance.
     */
    public void move(float distance)
    {
        float radians = (float) Math.toRadians(getRotation());
        float dx = (float) Math.cos(radians) * distance;
        float dy = (float) Math.sin(radians) * distance;
        setLocation(pos.getExactX() + dx, pos.getExactY() + dy);
    }
    
    /**
     * Move towards Vector2 position
     * Return true when finished
     */
    public boolean moveTowards(Vector2 target, float speed) { 
        if (Vector2.distance(this.pos, target) <= speed) return true; 
        Vector2 d = Vector2.sub(target, this.pos);
        d = d.normalize();
        d = d.mult(speed);
        lastMove = d;
        setLocation(pos.getExactX() + d.getExactX(), pos.getExactY() + d.getExactY());
        return false;
    }
    
    /**
     * Set positiong using vector2 coordinates
     */
    public void setLocation(Vector2 v)
    {
        setLocation(v.getExactX(), v.getExactY());
    }
    
    /**
     * Set the location using exact coordinates.
     */
    public void setLocation(float x, float y) 
    { 
        pos.setX(x);
        pos.setY(y);
        super.setLocation(Math.round(x), Math.round(y));
    } 
    
    /**
     * Set the location using integer coordinates.
     * (Overrides the method in Actor.)
     */
    @Override
    public void setLocation(int x, int y) {
        setLocation((float)x, (float)y);
    }
    
    /**
     * Return the exact x-coordinate (as a float).
     */
    public float getExactX() 
    {
        return pos.getExactX();
    }

    /**
     * Return the exact y-coordinate (as a float).
     */
    public float getExactY() 
    {
        return pos.getExactY();
    }
}
