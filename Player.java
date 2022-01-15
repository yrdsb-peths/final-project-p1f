import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

// public class Player extends Players
// {
//     char playerOrientation;
//     Player() {
//         setPlayerImage("Mario/WalkF1.png");
//     }

//     private void setPlayerImage(String file) {
//         GreenfootImage image = new GreenfootImage(file);
//         image.scale(image.getWidth()+100, image.getHeight()+100);
//         setImage(image);
//     }

//     /**
//      * Act - do whatever the Player wants to do. This method is called whenever
//      * the 'Act' or 'Run' button gets pressed in the environment.
//      */
//     public void act() {
//         if (Greenfoot.isKeyDown("up")) {
//             playerOrientation = 'U';
//             setPlayerImage("Mario/U1.png"); 
//         } else if (Greenfoot.isKeyDown("down")) {
//             playerOrientation = 'D';
//             setPlayerImage("Mario/D1.png"); 
//         } else if (Greenfoot.isKeyDown("left")) {
//             playerOrientation = 'L';
//             setPlayerImage("Mario/L1.png"); 
//         } else if (Greenfoot.isKeyDown("right")) {
//             playerOrientation = 'R';
//             setPlayerImage("Mario/R1.png"); 
//         } else if (Greenfoot.isKeyDown("space")) {
//             playerOrientation = 'F';
//             setPlayerImage("Mario/WalkF1.png"); //img need to be changed
//         }
//     }

//     public int checkPlayer() {
//         if (playerOrientation == 'F') {
//             return 0;
//         } else if (playerOrientation == 'U') {
//             return 1;
//         } else if (playerOrientation == 'D') {
//             return 2;
//         } else if (playerOrientation == 'L') {
//             return 3;
//         } else if (playerOrientation == 'R') {
//             return 4;
//         }
//         return -1;
//     }
// }

/* 
 * Player that plays minigames
 * 
 * @param name player name (eg mario, luigi)
 * @param scale player sprite size scale
 */
public class Player extends SmoothMover {
    private String name;
    private float scale;
    protected Animation lWalk, rWalk, lIdle, rIdle;
    
    protected enum Direction { LEFT, RIGHT };
    protected Direction dir;
    
    protected enum AnimState { IDLE, MOVE };
    protected AnimState animState;
    
    public Player(String name, float scale) {
        this.name = name;
        dir = Direction.RIGHT;
        animState = AnimState.IDLE;
        setupAnim();
    }
    
    public void act() {
        if (getWorldOfType(MemoryMatch.class) != null) {
            playMemoryMatch();
        }
        updateAnim();
    }
    
    protected void updateAnim() {
        if (lastMove.getExactX() > 0) {
            dir = Direction.RIGHT; 
        } else if (lastMove.getExactX() < 0) {
            dir = Direction.LEFT;
        }
        
        if (lastMove.getExactX()==0 && lastMove.getExactY()==0) {
            animState = AnimState.IDLE;
        } else {
            animState = AnimState.MOVE;
        }
        
        if (animState == animState.IDLE) {
            switch (dir) {
                case LEFT: lIdle.animate(); break;
                case RIGHT: rIdle.animate(); break;
            }
        } else if (animState == animState.MOVE) {
            switch (dir) {
                case LEFT: lWalk.animate(); break;
                case RIGHT: rWalk.animate(); break;
            }
        }
    }
    
    /**
     * setup animation based on name
     */
    private void setupAnim() {
        String file = "";
        switch (name) {
            case "Mario": file = "Mario/anim/L"; break;
            case "Luigi": file = "Luigi/anim/L"; break;
            case "Red": file = "koopa/redL"; break;
            case "Green": file = "koopa/greenL"; break;
            case "Yellow": file = "koopa/yellowL"; break;
            case "Purple": file = "koopa/purpleL"; break;
            case "Silver": file = "koopa/silverL"; break;
            default: file = "Mario/anim/L"; break;
        } 
        lWalk = new Animation(this, file, 2, 5, 3);
        rWalk = new Animation(this, file, 2, 5, 3, true);
        lIdle = new Animation(this, file, 1, 5, 3);
        rIdle = new Animation(this, file, 1, 5, 3, true);
    }
    
    protected void playMemoryMatch() {}
    protected void playLook() {}
    
    public String getName() { return this.name; }
    public GreenfootImage getRightImage() { return rWalk.getImage(0); }
}
