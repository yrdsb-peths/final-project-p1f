import greenfoot.*; 
/**
 * Game's main sound player
 * 
 */
public class MainSound {
    
    private static GreenfootSound sound;
    
    /**
     * sets the current sound
     * 
     * @param GreenfootSound sound
     */
    public static void setSound(GreenfootSound s) {
        sound = s;
    }
    
    /**
     * plays the sound on repeat
     * 
     */
    public static void play() {
        sound.playLoop();
    }
    
    /**
     * stops the current sound playing (does nothing if there is no sound)
     * 
     */
    public static void stop() {
        try {
            sound.stop();
        } catch (Exception e) {
            
        }
    }
    
}
