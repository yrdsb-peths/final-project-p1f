import greenfoot.*;
/**
 * Write a description of class BadNode here.
 * 
 * @author Victoria, Eric
 * @version (a version number or a date)
 */
public class BadNode extends MapNode 
{
    private GreenfootSound badNodeSound = new GreenfootSound("badNodeSound.wav");
    public BadNode(float x, float y) {
        super(x,y);
    } 

    /**
     * Countes the number of steps a character has used.
     * 
     * @param character Character who passed the BadNode
     */
    public void pass(MapCharacter character) {
        character.decreaseStep();
    } 
    
    /**
     * Character that lands on a BadNode is punished by losing 3 coins.
     * 
     * @param character Character who activated the BadNode
     */
    public void activate(MapCharacter character) {
        // do something bad to character
        character.addCoins(-3);
        badNodeSound.play();
    }
    
}
