import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @param string name
 * @param float scale
 */
public class HumanPlayer extends Player
{
    
    public HumanPlayer(String name, float scale) {
        super(name, scale);
    }
    
    protected void playerMovement(float speed) { 
        if (Greenfoot.isKeyDown("w")) {
            move(new Vector2(0, -speed));
        } else if (Greenfoot.isKeyDown("s")) { 
            move(new Vector2(0, speed));
        }
        if (Greenfoot.isKeyDown("a")) {
            move(new Vector2(-speed, 0));
        } else if (Greenfoot.isKeyDown("d")) { 
            move(new Vector2(speed, 0));
        }
    }

    protected void playMemoryMatch() {
        super.playMemoryMatch();
        playerMovement(3f);
    }

    protected void playLook() {
        super.playLook();
        int w = getWorld().getWidth();
        int h = getWorld().getHeight();
        int d = 180;
        if (Greenfoot.isKeyDown("w")) {
            lookTarget = new Vector2(w/2, d);
        } else if (Greenfoot.isKeyDown("s")) { 
            lookTarget = new Vector2(w/2, h-d);
        } else if (Greenfoot.isKeyDown("a")) { 
            lookTarget = new Vector2(d, h/2);
        } else if (Greenfoot.isKeyDown("d")) { 
            lookTarget = new Vector2(w-d, h/2);
        }
    }

}
