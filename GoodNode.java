/**
 * Write a description of class GoodNode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoodNode extends MapNode 
{ 
    public GoodNode(float x, float y) {
        super(x, y);
    }

    public void pass(MapCharacter character) {
        // -1 dice
    }
    
    public void activate(MapCharacter character) {
        // do good to player
        System.out.println(character.getName() + " landed on a good node");
    }
    
}
