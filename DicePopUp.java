import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays players' dice before playing each mini-game.
 * 
 * @author Eric Zhang
 * @version January 2022 
 */
public class DicePopUp extends PopUp
{
    private Dice dice;
    private MapCharacter player;
    /**
     * Constructor for the ScorePopUp class - calls its superclass and initializes player images 
     * 
     * @param player player to roll dice
     */
    public DicePopUp(MapCharacter player) {
        super();
        this.player = player;

        GreenfootImage img = new GreenfootImage(player.getRightImage());
        float scale = 3f;
        img.scale((int)(img.getWidth()*scale), (int)(img.getHeight()*scale));
        panel.drawImage(img, 200, 200);
    }

    /**
     * Method that displays current player dice
     */
    public void firstAct() {
        super.firstAct();
        dice = new Dice();
        WorldMap.instance.addObject(dice, 500, 300);
        player.startDice(dice);
        canClose = false;

        if (player.getClass() == MapNPC.class) {
            WorldMap.instance.removeObject(exitButton);
        }
    }

    /**
     * Method that controls dice disappearance when finished
     */
    public void act() {
        super.act();
        if (player.stopDice(dice)) {
            canClose = true;
            dice.stopRoll();
        }
        if (canClose && player.closePopUp()) {
            onExit();
        }
    }

    /**
     * Method to exit dice screen
     */
    protected void onExit() {
        super.onExit();
        dice.hide();
    }
    
    /**
     * Method to return the result of dice roll
     * 
     * @return dice.rollResult()
     */
    public int rollResult() {
        return dice.rollResult();
    }
}
