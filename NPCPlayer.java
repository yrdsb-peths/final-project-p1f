import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NPCPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NPCPlayer extends Player
{
    
    private Vector2 targetPos;
    public NPCPlayer(String name, float scale) {
        super(name, scale);
    }
    
    protected void playMemoryMatch() {
        if (targetPos == null || moveTowards(targetPos, 3f)) {
            MemoryMatch world = getWorldOfType(MemoryMatch.class);
            Vector2[] cards = world.getCardPositions();
            int idx = Utils.random(cards.length-1);
            targetPos = cards[idx];
        }
    }

    protected void playLook() {
        
    }
    
}
