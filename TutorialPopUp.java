import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TutorialPopUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialPopUp extends PopUp
{
    
    private MiniGame game;
    public TutorialPopUp(MiniGame game) {
        super();
        this.game = game;
        switch (game.toString()) {
            case "MemoryMatch":
                setImage(new GreenfootImage("Instruction/MemoryMatch.png"));
                break;
            case "Look":
                setImage(new GreenfootImage("Instruction/Look.png"));
                break;
            case "BombsAway":
                setImage(new GreenfootImage("Instruction/BombsAway.png"));
                break;
            default:
                assert false:"Tutorial Popup: Unknown game " + game.toString(); 
                break;
        }
    }

    protected void onExit() {
        super.onExit();
        Greenfoot.setWorld(game);
    }

}
