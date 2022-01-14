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
    private Label coinLabel;
    private static GreenfootSound bgm = new GreenfootSound("MemoryMatchBGM.mp3");
    private boolean finished = false;
    private Coin coin;

    /**
     * Constructor for objects of class MemoryMatch.
     * 
     */
    public MemoryMatch() {
        setBackground("waterbg.png");
        prepare();
        prepareCards();
    }

    public void prepare() {
        addObject(timeCount,100,65);
        timeCount.setValue(gameTime);  

        //bgm.play();

        coin = new Coin();
        addObject(coin, 220, 70);
        coinLabel = new Label(coinCount,50);
        addObject(coinLabel,290,70);
        

        HumanPlayer player = new HumanPlayer();
        addObject(player, 80,340);
    }

    public void prepareCards() {
        int[] cardVal = {1,1,2,2,3,3,4,4,5,5,6,6};
        shuffle(cardVal);
        int i = 0;
        for (int x=100; x<=900; x+=155) {
            for (int y=200; y<=500; y+=290) {
                addObject(new Card(cardVal[i]), x, y);
                i++;
            }
        }

        /*
        Vector2[][] positions = new Vector2[4][3];
        for (int i=0;i<4;i++) {
        for (int j=0;j<3;j++) {
        int x = i*160 + 200;
        int y = j*160 + 100;
        positions[i][j] = new Vector2(x,y);
        }
        }

        for (int i=1;i<=3;i++) {
        int iX = Utils.random(3);
        int iY = Utils.random(2);
        Vector2 pos = positions[iX][iY];
        addObject(new Card(i), pos.getX(), pos.getY()); 
        } */
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
            bgm.stop();
            Greenfoot.setWorld(new WorldMap());
        }

    }

    
    public void checkCoin() {
        if (!finished && coinCount == 6) {
            bgm.stop();
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

}
