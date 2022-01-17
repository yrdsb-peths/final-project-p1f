import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BombsAway here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BombsAway extends World
{
    private SimpleTimer timer = new SimpleTimer();
    private Counter timeCount = new Counter();
    private int time = 60;
    private SimpleTimer levelTimer = new SimpleTimer();
    
    private GreenfootSound main = new GreenfootSound("Mario Party 1 OST - Ducking and Dodging (Mini-Game).mp3");
    
    private GreenfootImage background = new GreenfootImage("BombsAwayBKG.png");
    
    private int numBombs = 0;
    
    /**
     * Constructor for objects of class BombsAway.
     * 
     */
    public BombsAway()
    {    
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        
        Bomb aBomb = new Bomb(Greenfoot.getRandomNumber(50) + 50, Greenfoot.getRandomNumber(359));
        addObject(aBomb, Greenfoot.getRandomNumber(1000), 0);
        
        PlayerOne playerOne = new PlayerOne();
        PlayerOne.alive = true;
        addObject(playerOne, 500, 470);
        
        addObject(timeCount,300,90);
        timeCount.setValue(time); 
        levelTimer.mark();
        
        this.setBackground(background);
    }
    
    public void act(){
        main.play();
        if (timer.millisElapsed() > 1000) { //count down one second
            timeCount.add(-1);
            timer.mark();
        }
        if(timer.millisElapsed() >= 6000 - (10 * numBombs)){
            Bomb bomb = new Bomb(Greenfoot.getRandomNumber(50) + 100, Greenfoot.getRandomNumber(359));
            addObject(bomb, Greenfoot.getRandomNumber(1000), 0);
        }
        if(timer.millisElapsed() * 1000 == timeCount.getValue() || levelTimer.millisElapsed() >= 60000 || !PlayerOne.alive){
            GameEnded gameOver = new GameEnded();
            Greenfoot.setWorld(gameOver);
            main.stop();
        }
    }
}
