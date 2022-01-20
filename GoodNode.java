import greenfoot.*;
/**
 * Nodes on the world map that win players coins
 * 
 * @author Eric Zhang
 * @version January 2022
 */
public class GoodNode extends MapNode 
{ 
    private GreenfootSound goodNodeSound = new GreenfootSound("goodNodeSound.wav");
    public GoodNode(float x, float y) {
        super(x, y);
    }

    /**
     * Countes the number of steps a character has used.
     * 
     * @param character Character who passed the GoodNode
     */
    public void pass(MapCharacter character) {
        character.decreaseStep();
    }
    
    /**
     * Character that lands on a GoodNode is rewarded by gaining coins.
     * 
     * @param character Character who activated the GoodNode
     */
    public void activate(MapCharacter character) {
        // do good to player
        character.addCoins(3);
        goodNodeSound.play();
    }
    
}
