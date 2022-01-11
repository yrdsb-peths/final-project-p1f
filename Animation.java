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
    private boolean shuffle;

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
        this.shuffle = false;
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
    private int frameIdx = 0;
    /**
     * Animate method (should called on every act())
     */
    public void animate() {
        frame++;
        int fr = 60 / fps;
        if (frame == fr * numberFrames) {
            frame = 0; 
        }
        if (shuffle) {
            if (frame % fr == 0) {
                int prev = frameIdx;
                while (frameIdx == prev) 
                    frameIdx = Utils.random(0, numberFrames-1);
            }
        } else {
            frameIdx = (int)(frame / fr);
        }
        actor.setImage(frames[frameIdx]);
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
     * Set shuffle true
     */
    public void shuffle() {
        this.shuffle = true;
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
    
    /**
     * return current frame index
     * @return frameIdx
     */
    public int getFrame() {
        return this.frameIdx;
    }
    
    /**
     * set to some frame
     */
    public void setFrame(int f) {
        actor.setImage(frames[f]);
    }
    
}
