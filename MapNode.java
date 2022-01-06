/**
 * Write a description of class MapNode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class MapNode  
{
    Vector2 pos;
    public MapNode(float x, float y) {
        pos = new Vector2(x, y);
        
    }
    
    public abstract void activate(MapCharacter character);
    
    public int getX() { return this.pos.getX(); }
    public int getY() { return this.pos.getY(); }
    
}
