import greenfoot.*;
/**
 * Nodes on the world map that make players loose coins
 * 
 * @author Victoria Zhang, Eric Zhang
 * @version January 2022
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
     * Character that lands on a BadNode is punished by losing coins.
     * 
     * @param character Character who activated the BadNode
     */
    public void activate(MapCharacter character) {
        // do something bad to character
        character.addCoins(-5);
        badNodeSound.play();
    }
    
}
