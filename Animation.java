
import greenfoot.*;
/**
 * Animation component
 * For animating actors
 * 
 */
public class Animation  
{
    private Actor actor;
    private GreenfootImage[][] frames;
    private int numberFrames;
    private int fps;
    private int dir=0; // 0: right, 1: left

    /**
     * Constructor for Animation
     */
    public Animation(Actor actor, String filepath, int numberFrames, int fps, double scale) {
        this.actor = actor;
        this.numberFrames = numberFrames;
        this.fps = fps;
        this.frames = new GreenfootImage[numberFrames][2];
        for (int i=0;i<numberFrames;i++) {
            GreenfootImage img = new GreenfootImage(filepath + " (" + String.valueOf(i+1) + ").png");
            int w = img.getWidth();
            int h = img.getHeight();
            img.scale((int)(w * scale), (int)(h * scale)); 
            this.frames[i][0] = new GreenfootImage(img);
            img.mirrorHorizontally();
            this.frames[i][1] = new GreenfootImage(img);
        }
    }
    
    private long frame = 0;
    /**
     * Animate method (should called on every act())
     */
    public void animate() {
        frame++;
        int fr = 60 / fps;
        frame %= fr * numberFrames;
        actor.setImage(frames[(int)(frame / fr)][dir]);
    }
    
    /**
     * Returns whether the animation clip has finished (on last frame)
     * @return anim is finished
     */
    protected boolean finishedAnim() {
        int fr = 60 / fps;
        return (frame+1 == fr*numberFrames);
    }
    
    /**
     * set direction of animation (0: face right, 1: face left)
     * @return direction
     */
    public void setDir(int dir) {
        this.dir = dir;
    }
    
    /**
     * set direction based on movement
     * 
     * @param Vector2 movement
     */    
    public void setDir(Vector2 move) { 
        if (move.getX()>0) {
            setDir(0);
        } else if (move.getX()<0) {
            setDir(1);
        } else {
            // dont change direction if no movement
        }
    }
    
    /**
     * reset the animation (back to first frame)
     */
    public void resetFrame() { 
        frame = 0;
    }
    
    /**
     * returns the fps of the animation
     * @return fps
     */
    public int getFPS() { 
        return this.fps;
    }
    
}
