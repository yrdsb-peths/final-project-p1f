import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    
    private GreenfootImage image;
    private int hoverFrame = 0;
    private float scale;
    private String text;

    private enum ButtonState { HOVER, DOWN, NORMAL, CLICK };
    private ButtonState state;

    public Button(String text) {
        // some default image
        this(text, 1);
    }
    
    public Button(String text, float scale) {
        this.text = text;
        this.scale = scale;
        onRelease(); 
        state = ButtonState.NORMAL;
    }
    
    public void act() {
        if (state == ButtonState.CLICK) {
            state = ButtonState.NORMAL;
        }
        
        if (Greenfoot.mouseMoved(null)) {
            if (Greenfoot.mouseMoved(this)) { 
                state = ButtonState.HOVER;
            } else { 
                state = ButtonState.NORMAL;
            }
        }
        if (Greenfoot.mousePressed(this)) { 
            state = ButtonState.DOWN;
        } else if (state == ButtonState.DOWN && Greenfoot.mouseClicked(null)) { 
            state = ButtonState.CLICK;
        }

        switch (state) {
            case DOWN:
                onPress(); break;
            case HOVER:
                onHover(); break;
            default:
                onRelease(); break;
        }
    }
    
    /**
     * change image of button to "hover" image
     */
    private void onHover() {
        // slowly increase and decrease size of image
        float a = 3f;
        float s = 1 + (float)Math.sin(a * hoverFrame * Math.PI / 180) / 20f;
        setImage("button.png", s * this.scale);
        hoverFrame++;
    }
    
    /**
     * change image of button to "click" image
     */
    private void onPress() {
        setImage("button_click.png", this.scale);
    }

    /**
     * change image of button to "released" image 
     */
    private void onRelease() {
        setImage("button.png", this.scale);
    }

    private void setImage(String file, float scale) {
        image = new GreenfootImage(file);

        image.setFont(Utils.getFont());
        image.drawString(text, 80, 47);
        
        image.scale((int)(image.getWidth() * scale), (int)(image.getHeight() * scale));
        setImage(image);
    }
    
    /**
     * return true if mouse clicked on button
     * (returns when mouse released after pressing on button)
     * 
     */
    public boolean clicked() { 
        return (state == ButtonState.CLICK);
    }
    
}
