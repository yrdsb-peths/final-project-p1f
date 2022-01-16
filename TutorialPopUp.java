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
        this.game = game;
        switch (game.toString()) {
            case "Memory Match":
                setImage(new GreenfootImage("tutorial_memorymatch.png"));
                break;
            case "Look":
                setImage(new GreenfootImage("tutorial_look.png"));
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
