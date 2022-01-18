import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Extra utilities / tools for dev
 * 
 */
public class Utils  
{    
    
    private final static Font font = new Font("Arial", 28);
    public static Font getFont() {
        return font;
    }
    
    /**
     * Method to get random float [0, 1] (inclusize)
     */
    public static float random() {
        // [0, 10001) ==> [0, 10000]
        float f = Greenfoot.getRandomNumber(10001);
        return f / 10000;
    }
    
    /**
     * Method to get random float [0, a] (inclusive)
     * 
     * @param float a
     * @return random number
     */
    public static float random(float a) {
        // [0, 1] * a ==> [0, a]
        return random()*a;
    }
    
    /**
     * Method to get random float [a, b] (inclusive)
     * 
     * @param float a
     * @param float b
     * @return random number
     */
    public static float random(float a, float b) {
        // [0+a, b-a+a] ==> [a, b]
        return random(b-a) + a;
    }
    
    /**
     * Method to get random number [0, a] (inclusive)
     * 
     * @param int a
     * @return random number
     */
    public static int random(int a) {
       // [0, a+1) ==> [0, a]
       return Greenfoot.getRandomNumber(a+1);
    }
    
    /**
     * Method to get random between [a, b]
     * 
     * @param int a
     * @param int b
     * @return random number
     */
    public static int random(int a, int b) {
       // [0 + a, b-a+1 + a) ==> [a, b]
       return Greenfoot.getRandomNumber(b-a+1) + a;
    }

    /**
     * Sort array of comparable objects using merge sort
     * Sort in decreasing order (largest to smallest)
     * @param List<MapCharacter> array to be sorted
     */
    public static <T extends Comparable<T>> List<Integer> sort(List<T> ar) {
        int sz = ar.size();
        List<Integer> index = new ArrayList<Integer>();
        for (int i=0;i<4;i++) {
            index.add(i);
        }
        return mergeSort(ar, 0, sz-1, index);
    }

    /**
     * Recursive mergesort method in decreasing order
     */
    private static <T extends Comparable<T>> List<Integer> mergeSort(List<T> ar, int lo, int hi, List<Integer> index) {
        if (lo >= hi) return null;
        int mid = (lo + hi) / 2;
        mergeSort(ar, lo, mid, index);
        mergeSort(ar, mid+1, hi, index);
        
        List<T> temp = new ArrayList<T>(ar);
        List<Integer> tempI = new ArrayList<Integer>(index);

        // merge(ar, lo, mid, hi);
        int i=lo, j=mid+1, k=lo;
        while (i <= mid && j <= hi) {
            if (temp.get(i).compareTo(temp.get(j)) >= 0) {
                ar.set(k, temp.get(i));
                index.set(k, tempI.get(i));
                i++; k++;
            } else {
                ar.set(k, temp.get(j));
                index.set(k, tempI.get(j));
                j++; k++;
            }
        }
        while (i <= mid) {
            ar.set(k, temp.get(i));
            index.set(k, tempI.get(i));
            i++; k++;
        }
        while (j <= hi) {
            ar.set(k, temp.get(j));
            index.set(k, tempI.get(j));
            j++; k++;
        }

        return index;
    }
}
