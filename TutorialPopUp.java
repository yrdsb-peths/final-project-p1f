import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Display tutorials of mini-games to users by popping up before player each mini-game
 * 
 * @author Eric Zhang
 * @version January 2022
 */
public class TutorialPopUp extends PopUp
{
    private MiniGame game;
    
    /**
     * Constructor for the class TutorialPopUp - display instruction images based on game name
     * 
     * @param game Game that will be played 
     */
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
                System.out.println("game now found");
                break;
        }
    }

    protected void onExit() {
        super.onExit();
        Greenfoot.setWorld(game);
    }

}
