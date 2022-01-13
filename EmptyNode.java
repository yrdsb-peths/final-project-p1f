/**
 * Write a description of class EmptyNode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
