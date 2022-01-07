import greenfoot.*;
/**
 * Animation component
 * For animating actors
 * 
 */
public class Animation  
{
    private Actor actor;
    private GreenfootImage[] frames;
    private int numberFrames;
    private int fps;

    /**
     * Constructor for Animation
     */
    public Animation(Actor actor, String filepath, int numberFrames, int fps, double scale) {
        this(actor, filepath, numberFrames, fps, scale, false);
    }
    
    public Animation(Actor actor, String filepath, int numberFrames, int fps, double scale, boolean mirror) {
        this.actor = actor;
        this.numberFrames = numberFrames;
        this.fps = fps;
        this.frames = new GreenfootImage[numberFrames];
        for (int i=0;i<numberFrames;i++) {
            GreenfootImage img = new GreenfootImage(filepath + "" + String.valueOf(i+1) + ".png");
            int w = img.getWidth();
            int h = img.getHeight();
            img.scale((int)(w * scale), (int)(h * scale));
            if (mirror) {
                img.mirrorHorizontally();
            }
            this.frames[i] = new GreenfootImage(img);
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
        actor.setImage(frames[(int)(frame / fr)]);
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
