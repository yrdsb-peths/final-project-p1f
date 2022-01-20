/**
 * Nodes on the world map that does nothing to players - just act as a stop
 * 
 * @author Eric Zhang
 * @version January 2022
 */
public class EmptyNode extends MapNode 
{
    public EmptyNode(float x, float y) {
        super(x, y);
    }
    
    public void pass(MapCharacter character) {
        // do nothing, just so the player can turn to next location 
    }
    
    public void activate(MapCharacter character) {
        // do nothing, just so the player can turn to next location
    }
    
}
