/**
 * Write a description of class FrameTimer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FrameTimer  
{
    // instance variables - replace the example below with your own
    private int time;

    /**
     * Constructor for objects of class FrameTimer
     */
    public FrameTimer()
    {
        time = 0;
    }
    
    public void act(){
        time += 1;
    }
    
    public void frameMark(){
        time = 0;
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int framesElapsed()
    {
        // put your code here
        return time;
    }
}
