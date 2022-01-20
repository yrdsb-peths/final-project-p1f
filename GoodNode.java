import greenfoot.*;
/**
 * Write a description of class GoodNode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
     * Character that lands on a BadNode is rewarded by gaining 3 coins.
     * 
     * @param character Character who activated the GoodNode
     */
    public void activate(MapCharacter character) {
        // do good to player
        character.addCoins(3);
        goodNodeSound.play();
    }
    
}
