import greenfoot.*; 
/**
 * Game's main sound player
 * 
 */
public class MainSound {
    
    private static GreenfootSound sound;
    
    /**
     * Method that sets the current sound
     * 
     * @param GreenfootSound sound
     */
    public static void setSound(GreenfootSound s) {
        stop();
        sound = s;
    }
    
    /**
     * Method that plays the sound on repeat
     * 
     */
    public static void play() {
        sound.playLoop();
    }
    
    /**
     * Method that stops the current sound playing (does nothing if there is no sound)
     * 
     */
    public static void stop() {
        if (sound != null && sound.isPlaying()) {
            sound.stop();
        }
    }

    /**
     * Method that sets volume
     */
    public static void setVolume(int volume) {
        sound.setVolume(volume);
    }
    
}
