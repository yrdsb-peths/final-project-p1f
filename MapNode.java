/**
 * Nodes on maps where players stop on
 * 
 * @author Eric Zhang
 * @version January 2022
 */
public abstract class MapNode  
{
    Vector2 pos;
    public MapNode(float x, float y) {
        pos = new Vector2(x, y);
        
    }
    
    public abstract void pass(MapCharacter character); // called for when player passes by
    public abstract void activate(MapCharacter character); // called when player lands here
    
    public int getX() { 
        return this.pos.getX(); 
    }
    
    public int getY() { 
        return this.pos.getY(); 
    }

    public Vector2 getPos() { 
        return this.pos; 
    }
    
}
