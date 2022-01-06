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
    private Vector2 pos;

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
        setLocation(x, y);
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
