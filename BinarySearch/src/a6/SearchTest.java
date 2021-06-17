package a6;

import java.util.Arrays;
import java.util.Random;

/**
 * This class has methods to compare the performance of 
 * sequential search and binary search.
 *
 */
public class SearchTest {

    /**
     * Call the test method with an array size and repetition count and output results.
     * This method has been fully implemented for you. You may change it
     * if it aids your investigation.
     * @param args
     */
    public static void main(String[] args) {
        int test_array_size = 10_000;
        int N = 100;
        double[] results = testNRepetitions(test_array_size, N);
        System.out.println("For an array of size " + test_array_size + " the average search costs are:");
        System.out.println("     binaryAvg    : " + results[0] + " equality tests");
        System.out.println("     sequentialAvg: " + results[1] + " equality tests");
        double[] results1 = testNRepetitions(32, N);
        System.out.println("For an array of size 32 the average search costs are:");
        System.out.println("     binaryAvg    : " + results1[0] + " equality tests");
        System.out.println("     sequentialAvg: " + results1[1] + " equality tests");
        double[] results2 = testNRepetitions(64, N);
        System.out.println("For an array of size 64 the average search costs are:");
        System.out.println("     binaryAvg    : " + results2[0] + " equality tests");
        System.out.println("     sequentialAvg: " + results2[1] + " equality tests");
        double[] results3 = testNRepetitions(128, N);
        System.out.println("For an array of size 128 the average search costs are:");
        System.out.println("     binaryAvg    : " + results3[0] + " equality tests");
        System.out.println("     sequentialAvg: " + results3[1] + " equality tests");
        double[] results4 = testNRepetitions(256, N);
        System.out.println("For an array of size 256 the average search costs are:");
        System.out.println("     binaryAvg    : " + results4[0] + " equality tests");
        System.out.println("     sequentialAvg: " + results4[1] + " equality tests");
        double[] results5 = testNRepetitions(512, N);
        System.out.println("For an array of size 512 the average search costs are:");
        System.out.println("     binaryAvg    : " + results5[0] + " equality tests");
        System.out.println("     sequentialAvg: " + results5[1] + " equality tests");
    }

    /**
     * This method constructs an int array of size arraySize and fills it with random
     * numbers ranging from 0 to arraySize - 1 (inclusive). Fill this array
     * with the method implemented below.
     * 
     * Then, pick a random key from the same integer range. Search for this key in the array and
     * measure the number of array/key == tests using sequential search and binary search
     * using the methods that need to be implemented below.
     * 
     * Repeat this search on the same array but a new key for N times.
     * 
     * Calculate the average counts for each search style.
     * 
     * @param arraySize: the number of elements in the test array
     * @param N: the number of times to repeat the tests.
     * @return a 2-element double array with the binary average at index 0 and
     * the sequential average at index 1.
     * 
     * Assumes N > 0 and arraySize > 0.
     */
    public static double[] testNRepetitions(int arraySize, int N) {
        int[] array = new int [arraySize];
        int randomKey = 0;
        randomSortedFill(array);
        Random key = new Random();
        int times = 0;
        int binaryCount = 0;
        int sequentialCount = 0;
        while(times < N) {
            randomKey = key.nextInt(arraySize);
            binaryCount += binarySearchForKeyWithCount(array, randomKey);
            sequentialCount += sequentialSearchForKeyWithCount(array, randomKey);
            times ++;
        }
        double[] average = new double[] {(double) binaryCount/N, (double) sequentialCount/N};
        return average;
    }


    /**
     * Given an array with length elements, fill the array
     * with random values from 0 to length-1 (inclusive) int values.
     * Use the Random class to generate these values.
     * The array can have duplicate values, this is not a shuffle of 
     * all values from 0 to length-1, but instead length values picked 
     * randomly from 0 to length-1.
     * 
     * The values are then sorted in ascending order.
     * 
     * This method has been implemented for you.
     * You do not need to change the documentation for this method.
     * 
     * @param vals: an array to be filled with random values in ascending order.
     */
    public static void randomSortedFill(int[] vals) {
        Random generator = new Random();

        for (int index = 0; index < vals.length; index++) {
            vals[index] = generator.nextInt(vals.length);
        }

        Arrays.sort(vals);
    }

    /**
     * Search vals for the key using binary search. 
     * Assumes vals is sorted in ascending order.
     * This code is provided as a reminder of how binary search works.
     * You do not need to run it or modify it.
     * 
     * @param vals
     * @param key
     * @return the index where val is found, or -1 otherwise.
     */
    public static int binarySearchForKey(int[] vals, int key) {
        int lo = 0;
        int hi = vals.length - 1;
        while (lo <= hi) {
            int arrayLength = hi + 1 - lo;
            int mid = arrayLength / 2 + lo;
            if (vals[mid] == key)
                return mid;
            if (vals[mid] < key)
                lo = mid + 1;
            else //if (vals[mid] > key) is the only case left, so we don't need to check it.
                hi = mid - 1;
        }
        return -1;
    }

    /**
     * Search vals for the key using binary search. 
     * Assumes vals is sorted in ascending order.
     * @param vals
     * @param key
     * @return the number of == tests performed during the search.
     */
    public static int binarySearchForKeyWithCount(int[] vals, int key) {
        int lo = 0;
        int hi = vals.length - 1;
        int count = 0;
        while (lo <= hi) {
            int arrayLength = hi + 1 - lo;
            int mid = arrayLength / 2 + lo;
            count ++;
            if (vals[mid] == key)
                return count;
            if (vals[mid] < key)
                lo = mid + 1;
            else //if (vals[mid] > key) is the only case left, so we don't need to check it.
                hi = mid - 1;
        }
        return count; 
    }

    /**
     * Search vals for the key using sequential search. 
     * This code is provided as a reminder of how sequential search works.
     * You do not need to run it or modify it.
     * @param vals
     * @param key
     * @return the index where val is found, or -1 otherwise.
     */
    public static int sequentialSearchForKey(int[] vals, int key) {
        for (int index = 0; index < vals.length; index++) {
            if (key == vals[index])
                return index;
        }
        return -1;
    }

    /**
     * Search vals for the key using sequential search. 
     * @param vals
     * @param key
     * @return the number of == tests performed during the search.
     */
    public static int sequentialSearchForKeyWithCount(int[] vals, int key) {
        for (int index = 0; index < vals.length; index++) {
            if (key == vals[index])
                return index + 1;
        }
        return vals.length; 
    }

}
