import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class MemoryMatch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 * Need: card flip delay
 */
public class MemoryMatch extends MiniGame
{
    private SimpleTimer tim = new SimpleTimer();
    private Counter timeCount = new Counter();
    private int gameTime = 30;
    private int coinCount = 0;
    private Label coinLabel; 
    private boolean finished = false;
    private Coin coin;
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

    public void prepare() {
        addObject(timeCount,100,65);
        timeCount.setValue(gameTime);  

        MainSound.setSound(new GreenfootSound("MemoryMatchBGM.mp3"));
        MainSound.play();

        coin = new Coin();
        addObject(coin, 220, 70);
        coinLabel = new Label(coinCount,50);
        addObject(coinLabel,290,70);
        
        setupPlayers(3f);
        int pos=80, distance=40;
        for (Player p : players) {
            addObject(p, pos, 340);
            pos += distance;
        }
    }

    public void prepareCards() {
        int[] cardVal = {1,1,2,2,3,3,4,4,5,5,6,6};
        shuffle(cardVal);
        int i = 0;
        for (int x=100; x<=900; x+=155) {
            for (int y=200; y<=500; y+=290) {
                addObject(new Card(cardVal[i]), x, y);
                cardPositions[i] = new Vector2(x, y);
                i++;
            }
        }
    }

    public void shuffle(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            int j = Greenfoot.getRandomNumber(arr.length - i) + i;

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public void act() {
        timeCountDown();
        checkCoin();
    }

    /**
     * Called every act; updates the time counter every second.
     * If time limit is reached, return to main world.
     */
    public void timeCountDown()
    {    
        if(!finished && tim.millisElapsed() > 1000) { //time count down every second
            timeCount.add(-1);
            tim.mark();
            if (timeCount.getValue() == 0) {
                finished = true; 
            }
        }

        if (finished && tim.millisElapsed() > 2000) { //if time limit is reached
            updateWorld();
        }

    }

    public void checkCoin() {
        if (!finished && coinCount == 6) {
            MainSound.stop();
            Greenfoot.playSound("IWin.wav");
            tim.mark();
            finished = true;
        }
    } 

    public void addCoin(int c) {
        coinCount += c;
        coin.setSpin(3);
        coinLabel.setValue(coinCount);
    }
    
    public Vector2[] getCardPositions() {
        return this.cardPositions;
    }

    public String toString() {
        return "MemoryMatch";
    }

}
