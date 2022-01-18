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
        character.decreaseStep();
    }
    
    public void activate(MapCharacter character) {
        // do good to player
        character.addCoins(3);
    }
    
}
