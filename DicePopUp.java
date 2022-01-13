import java.util.Map;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DicePopUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DicePopUp extends PopUp
{
    
    private Dice dice;
    private MapCharacter player;
    public DicePopUp(MapCharacter player) {
        super();
        this.player = player;  

        GreenfootImage img = new GreenfootImage(player.getRightImage());
        float scale = 2;
        img.scale((int)(img.getWidth()*scale), (int)(img.getHeight()*scale));
        panel.drawImage(img, 200, 200);
    }

    public void firstAct() {
        super.firstAct();
        dice = new Dice();
        WorldMap.instance.addObject(dice, 500, 300);
        player.startDice(dice);
        canClose = false; 
        
    }

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

    protected void onExit() {
        super.onExit();
        dice.hide();
    }
    
    public int rollResult() {
        return dice.rollResult();
    }
}
