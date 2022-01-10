/**
 * Write a description of class BadNode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BadNode extends MapNode 
{
    public BadNode(float x, float y) {
        super(x,y);
    } 

    public void pass(MapCharacter character) {
        // -1 dice
    } 
    
    public void activate(MapCharacter character) {
        // do something bad to character
        System.out.println(character.getName() + " landed on a bad node");
    }
}
