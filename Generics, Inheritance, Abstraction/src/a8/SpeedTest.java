package a8;
import java.util.Random;
/**
 * 
 * @author Shiyang(Shirley) Li
 */

/***
 * Tests the time to add N elements to a DynamicArray compared to DynamicArray2
 *
 */
public class SpeedTest {

    public static void main(String[] args) {

        DynamicArray<Integer> slowDA = new DynamicArray<Integer>();
        DynamicArrayCustom<Integer> fastDA = new DynamicArrayCustom<Integer>();

        Random randIndex = new Random();
        int  n = randIndex.nextInt(slowDA.size()+1);

        int N = 50_000;


        long startTime = System.nanoTime();
        for(int i = 0; i < N; i++) {
            slowDA.add(n, i);  
        }
        long endTime = System.nanoTime();
        System.out.println("DynamicArray took " + (endTime - startTime) / 1000000000.0 + 
                " sec to add " + N + " elements.");

        startTime = System.nanoTime();
        for(int i = 0; i < N; i++) {
            fastDA.add(n, i);   
        }
        endTime = System.nanoTime();
        System.out.println("DynamicArray2 took " + (endTime - startTime) / 1000000000.0 + 
                " sec to add " + N + " elements.");
    }

}
