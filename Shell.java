import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Shell object that moves left / right to attack player
 * 
 * @param int initDir -1 for left, 1 for right
 */
public class Shell extends SmoothMover
{
    
    private final int leftBorder = 150;
    private final int rightBorder = 850;
    
    private Animation anim;
    private float speed = 4f;

    public Shell(int initDir) {
        // randomly choose color
        int r = Utils.random(1,4);
        String col;
        switch (r) {
            case 1: col = "red"; break;
            case 2: col = "green"; break;
            case 3: col = "yellow"; break;
            case 4: col = "purple"; break;
            default: col = "red"; break;
        }
        this.anim = new Animation(this, "shell/" + col, 4, 24, 2f);
        this.speed *= initDir;
        
    }

    private boolean firstAct = true;
    public void act() {
        if (firstAct) {
            firstAct = false;
            if (this.speed < 0) {
                setLocation(rightBorder, SpeedyShells.getGround());
            } else {
                setLocation(leftBorder, SpeedyShells.getGround());
            }
        }

        anim.animate();
        
        // move
        move(new Vector2(speed, 0));

        // if touch shell switch direction
        if (getOneIntersectingObject(Shell.class) != null && 
                rightBorder - getX() > 100 && getX() - leftBorder > 100) {
            speed *= -1;
        }

        // remove shell if "touching" pipe
        if (getExactX() < leftBorder) 
            getWorld().removeObject(this);
        if (getExactX() > rightBorder)
            getWorld().removeObject(this);
        
    }
}
