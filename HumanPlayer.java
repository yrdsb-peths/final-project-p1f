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

    protected void playMemoryMatch() {
        super.playMemoryMatch();
        float speed = 3f;
        Vector2 d = new Vector2();
        if (Greenfoot.isKeyDown("w")) {
            d = Vector2.add(d, new Vector2(0, -speed));
        } else if (Greenfoot.isKeyDown("s")) { 
            d = Vector2.add(d, new Vector2(0, speed));
        }
        if (Greenfoot.isKeyDown("a")) {
            d = Vector2.add(d, new Vector2(-speed, 0));
        } else if (Greenfoot.isKeyDown("d")) { 
            d = Vector2.add(d, new Vector2(speed, 0));
        }
        move(d);
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

    protected void playBombsAway() {
        super.playBombsAway();
        float speed = 5f;
        Vector2 d = new Vector2();
        if (Greenfoot.isKeyDown("a")) {
            d = Vector2.add(d, new Vector2(-speed, 0));
        }
        if (Greenfoot.isKeyDown("d")) { 
            d = Vector2.add(d, new Vector2(speed, 0));
        }
        move(d); 
    }

}
