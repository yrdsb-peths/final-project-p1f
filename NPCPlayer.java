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
        super.playMemoryMatch();
        if (targetPos == null || moveTowards(targetPos, 3f)) {
            MemoryMatch world = getWorldOfType(MemoryMatch.class);
            Vector2[] cards = world.getCardPositions();
            int idx = Utils.random(cards.length-1);
            targetPos = cards[idx];
        }
    }

    protected void playLook() {
        super.playLook();
        if (lookTarget == null) {
            int w = getWorld().getWidth();
            int h = getWorld().getHeight();
            int d = 180;
            float r = Utils.random();
            if (r < 0.25) {
                lookTarget = new Vector2(w/2, d);
            } else if (r < 0.5) { 
                lookTarget = new Vector2(w/2, h-d);
            } else if (r < 0.75) { 
                lookTarget = new Vector2(d, h/2);
            } else {
                lookTarget = new Vector2(w-d, h/2);
            }
        }
    }
    
}
