import greenfoot.*;
/**
 * Super good node! Like hitting a jackpot (not really)
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SuperNode extends MapNode 
{ 
    private GreenfootSound goodNodeSound = new GreenfootSound("goodNodeSound.wav");
    public SuperNode(float x, float y) {
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
     * Character that lands on a super node gets a whopping 10 coins
     * 
     * @param character Character who activated the GoodNode
     */
    public void activate(MapCharacter character) {
        // do good to player
        character.addCoins(10);
        goodNodeSound.play();
    }
    
}
