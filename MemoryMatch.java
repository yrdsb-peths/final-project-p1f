import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Card matching game with a time limit of 30 seconds 
 * and prepares 12 random cards each round 
 * 
 * @author Eric Zhang, Tanya Gu, Victoria Zhang, Kevin Wang
 * @version January 2022
 */
public class MemoryMatch extends MiniGame
{
    private SimpleTimer tim = new SimpleTimer();
    private Counter timeCount = new Counter();
    private int gameTime = 30; //30s time limit
    private int coinCount = 0;
    private boolean finished = false;
    private Vector2[] cardPositions = new Vector2[12];

    /**
     * Constructor for objects of class MemoryMatch.
     * 
     */
    public MemoryMatch() {
        super();
        setBackground("waterbg.png"); 
        prepare();
        prepareCards();
    }

    /**
     * Method that prepares time countdown, music, and players   
     */
    public void prepare() {
        addObject(timeCount,100,65);
        timeCount.setValue(gameTime);  

        MainSound.setSound(new GreenfootSound("MemoryMatchBGM.mp3"));
        MainSound.play();
        
        setupPlayers(3f); // set up players and their locations
        int pos=80, distance=40;
        for (Player p : players) {
            addObject(p, pos, 340);
            pos += distance;
        }
    }

    /**
     * Method that prepares cards and their locations 
     */
    public void prepareCards() {
        int[] cardVal = {1,1,2,2,3,3,4,4,5,5,6,6};
        shuffle(cardVal);
        int i = 0;
        // create grid of cards
        for (int x=100; x<=900; x+=155) {
            for (int y=200; y<=500; y+=290) {
                addObject(new Card(cardVal[i]), x, y);
                cardPositions[i] = new Vector2(x, y);
                i++;
            }
        }
    }

    /**
     * Method that shuffles an array
     * 
     * @param arr 
     */
    public void shuffle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = Greenfoot.getRandomNumber(arr.length - i) + i;
            // switch
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    /**
     * Method that tracks time and coins
     */
    public void act() {
        timeCountDown();
        checkCoin();
    }

    /**
     * Method that updates the time counter every second
     * Updates world when reached time limit
     */
    public void timeCountDown() {    
        if(!finished && tim.millisElapsed() > 1000) { // time count down every second
            timeCount.add(-1);
            tim.mark();
            if (timeCount.getValue() == 0) { // time limit reached
                finished = true; 
            }
        }

        if (finished && tim.millisElapsed() > 2000) { // time limit reached
            updateWorld();
        }

    }
    
    /**
     * Method that checks coin count
     * Finish the game if all coins are collected
     */
    public void checkCoin() {
        if (!finished && coinCount == 6) {
            MainSound.stop();
            Greenfoot.playSound("IWin.wav");
            tim.mark();
            finished = true;
        }
    } 

    /**
     * Method that updates coin count and player score
     * 
     * @param c
     */
    public void addCoin(int c) {
        coinCount += c;
        players.get(0).addScore(1);
    }
    
    /**
     * Method to get card positions
     * 
     * @return this.cardPositions
     */
    public Vector2[] getCardPositions() {
        return this.cardPositions;
    }

    /**
     * Method to get game name
     * 
     * @return game name - MemoryMatch
     */
    public String toString() {
        return "MemoryMatch";
    }
}
