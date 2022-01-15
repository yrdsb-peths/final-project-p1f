import greenfoot.*;

/**
 * Extra utilities / tools for dev
 * 
 */
public class Utils  
{    
    
    private final static Font font = new Font("Arial", 28);
    public static Font getFont() {
        return font;
    }
    
    /**
     * Method to get random float [0, 1] (inclusize)
     */
    public static float random() {
        // [0, 10001) ==> [0, 10000]
        float f = Greenfoot.getRandomNumber(10001);
        return f / 10000;
    }
    
    /**
     * Method to get random float [0, a] (inclusive)
     * 
     * @param float a
     * @return random number
     */
    public static float random(float a) {
        // [0, 1] * a ==> [0, a]
        return random()*a;
    }
    
    /**
     * Method to get random float [a, b] (inclusive)
     * 
     * @param float a
     * @param float b
     * @return random number
     */
    public static float random(float a, float b) {
        // [0+a, b-a+a] ==> [a, b]
        return random(b-a) + a;
    }
    
    /**
     * Method to get random number [0, a] (inclusive)
     * 
     * @param int a
     * @return random number
     */
    public static int random(int a) {
       // [0, a+1) ==> [0, a]
       return Greenfoot.getRandomNumber(a+1);
    }
    
    /**
     * Method to get random between [a, b]
     * 
     * @param int a
     * @param int b
     * @return random number
     */
    public static int random(int a, int b) {
       // [0 + a, b-a+1 + a) ==> [a, b]
       return Greenfoot.getRandomNumber(b-a+1) + a;
    }
}
