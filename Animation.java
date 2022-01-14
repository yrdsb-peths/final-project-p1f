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
    private boolean isPaused;
    private int hoverFrame;
    private float scale;

    /**
     * Constructor for Animation
     */
    public Animation(Actor actor, String filepath, int numberFrames, int fps, float scale) {
        this(actor, filepath, numberFrames, fps, scale, false);
    }
    
    public Animation(Actor actor, String filepath, int numberFrames, int fps, float scale, boolean mirror) {
        this.actor = actor;
        this.numberFrames = numberFrames;
        this.fps = fps;
        this.frames = new GreenfootImage[numberFrames];
        this.shuffle = false;
        this.isPaused = false;
        this.hoverFrame = -1;
        this.scale = scale;
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
        if (!isPaused) {
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
        }
        
        // hoverFrame >= 0 means that we are in hover state
        if (hoverFrame >= 0) {
            float a = 3f;
            float s = 1 + (float)Math.sin(a * hoverFrame * Math.PI / 180) / 20f;
            setImage(frames[frameIdx], s);
            hoverFrame++;
        } else {
            setImage(frames[frameIdx]);
        }
    }

    /**
     * Set the image of the actor to the current frame
     * @param img
     */
    private void setImage(GreenfootImage img) {
        actor.setImage(img);
    }

    /**
     * Set the image of the actor to the current frame
     * @param image
     * @param scale
     */
    private void setImage(GreenfootImage image, float scale) {
        GreenfootImage img = new GreenfootImage(image);
        img.scale((int)(image.getWidth() * scale), (int)(image.getHeight() * scale));
        actor.setImage(img);
    }

    /**
     * Either start periodically resize or stop resizing
     * @param action
     * 
     */
    public void periodicResize(boolean action) {
        if (action) {
            if (hoverFrame == -1) {
                hoverFrame = 0;
            }
        } else {
            hoverFrame = -1;
        }
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
     * set the animation to shuffle mode
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
     * @param frameIdx the frame index
     */
    public void setFrame(int f) {
        actor.setImage(frames[f]);
    }

    
    /**
     * pause the animation
     */
    public void pause() {
        isPaused = true;
    }

    /**
     * resumes the animation
     */
    public void resume() {
        isPaused = false;
    }

    /**
     * get image of an index
     * @param idx
     * @return image
     */
    public GreenfootImage getImage(int i) {
        return frames[i];
    }

}
