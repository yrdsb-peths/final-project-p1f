import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Different player control methods and player speed are determined according to 
 * different games
 * 
 * @author Eric Zhang
 * @version January 2022 
 */
public class HumanPlayer extends Player
{
    /**
     * Constructor for the HumanPlayer class - calls its superclass
     * 
     * @param name player name (eg mario, luigi)
     * @param scale player sprite size scale
     */
    public HumanPlayer(String name, float scale) {
        super(name, scale);
    } 

    /**
     * Method that particularly control the movements and speed of players in the 
     * MemoryMach mini-game. Allows users to play using WASD keys.
     */
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

    /**
     * Method that particularly control the movements and speed of players in the 
     * Look mini-game. Allows users to travel to 5 positions using WASD keys.
     */
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

    /**
     * Method that particularly control the movements and speed of players in the 
     * BombsAway mini-game. Allows users to move left and right using AD keys.
     */
    protected void playBombsAway() {
        super.playBombsAway();
        float speed = 3f;
        Vector2 d = new Vector2();
        if (Greenfoot.isKeyDown("a")) {
            d = Vector2.add(d, new Vector2(-speed, 0));
        }
        if (Greenfoot.isKeyDown("d")) { 
            d = Vector2.add(d, new Vector2(speed, 0));
        }
        move(d);
    }

    private int spaceFrames = 0;
    /**
     * Method that particularly control the jumping frames of players in the 
     * SpeedyShells mini-game. Allows users to jump low or high using the space key.
     */
    protected void playSpeedyShells() {
        super.playSpeedyShells();
        // get space key down
        if (Greenfoot.isKeyDown("space")) { 
            if (spaceFrames < 10)
                spaceFrames++;
        } 
        
        if (!Greenfoot.isKeyDown("space")) {
            if (touchShellGround()) {
                if (spaceFrames >= 10) {
                    jumpHighShell();
                } else if (spaceFrames >= 1) {
                    jumpShell();
                }
            }
            if (spaceFrames>0)
                spaceFrames--;
        }
    }
    
    protected void playSamuelSays(){
        super.playSamuelSays();
        if(Greenfoot.isKeyDown("a")){
            playerDirection = PlayerDirection.LEFT;
        }
        if(Greenfoot.isKeyDown("d")){
            playerDirection = PlayerDirection.RIGHT;
        }
    }
}
