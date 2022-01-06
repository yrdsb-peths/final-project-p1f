/**
 * 2D Vector of the form (x,y)
 * 
 */
public class Vector2 {
    private float x, y;
 
    /**
     * Construct Vector2 as (0,0)
     */
    public Vector2() {
        this(0, 0);
    }
    
    /**
     * Construct Vector2
     * 
     * @param float x
     * @param float y
     */
    public Vector2(float x, float y) {
        this.x = x; this.y = y;
    } 
    
    /**
     * Construct Vector2
     * 
     * @param int x
     * @param int y
     */
    public Vector2(int x, int y) {
        this.x = x; this.y = y;
    }        
    
    /**
     * Return addition of vector a and vector b
     * 
     * @param Vector2 a
     * @param Vector2 b
     * @return Vector2 sum
     */
    public static Vector2 add(Vector2 a, Vector2 b) {
        return new Vector2(a.x + b.x, a.y + b.y);
    }
    
    /**
     * Return subtraction of vector b from vector a
     * 
     * @param Vector2 a
     * @param Vector2
     * @return Vector2 result
     */
    public static Vector2 sub(Vector2 a, Vector2 b) {
        return new Vector2(a.x - b.x, a.y - b.y);
    }
    
    /**
     * Return multiplication of this vector by a constant c
     * 
     * @param float c
     * @return Vector2 product
     */
    public Vector2 mult(float c) { 
        return new Vector2(x * c, y * c);
    }
    
    /**
     * Return magnitude of this vector
     * 
     * @return float magnitude
     */
    public float mag() { 
        return (float)Math.sqrt(x*x + y*y);
    }
    
    /**
     * Return euclidean distance between vector a and vector b
     * 
     * @param Vector2 a
     * @param Vector2 b
     * @return float distance
     */
    public static float distance(Vector2 a, Vector2 b) {
        Vector2 temp = Vector2.sub(a,b);
        return temp.mag();
    }
    
    /**
     * Returns a normalized version of this vector
     * 
     * @return Vector2 result
     */
    public Vector2 normalize() {
        return new Vector2(x / mag(), y / mag());
    }
    
    /**
     * Return x value
     * @return x
     */
    public int getX() { return Math.round(this.x); }
    
    /**
     * Return y value
     * @return y
     */
    public int getY() { return Math.round(this.y); }
    
    /**
     * Return exact x value
     * @return x
     */
    public float getExactX() { return this.x; }
    
    /**
     * Return exact y value
     * @return y
     */
    public float getExactY() { return this.y; }

    /**
     * Sets the x value
     * @param float x
     */
    public void setX(float x) { this.x = x; }
    
    /**
     * Sets the y value
     * @param float y
     */
    public void setY(float y) { this.y = y; }
    
    /**
     * Sets the x value
     * @param int x
     */
    public void setX(int x) { this.x = x; }
    
    /**
     * Sets the y value
     * @param int y
     */
    public void setY(int y) { this.y = y; }
    
    /**
     * Returns copy of this vector
     * @return copy
     */
    public Vector2 get() { return new Vector2(x, y); } 
        
    /**
     * Override tostring method
     * @return String (x, y)
     */
    public String toString() { return (this.x + " " + this.y); }
    
}
