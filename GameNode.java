/**
 * Write a description of class GameNode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameNode extends MapNode 
{ 
    public GameNode(float x, float y) {
        super(x, y);
    }

    public void pass(MapCharacter character) {
        character.decreaseStep();
    }
    
    public void activate(MapCharacter character) {
        // start minigame
        System.out.println(character.getName() + " landed on a minigame node");
    }
    
}
