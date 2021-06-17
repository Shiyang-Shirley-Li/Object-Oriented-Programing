package a6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


/**
 * 
 * Code that reads in some common 5-word phrases, then asks the user
 * for the start of a phrase, and then provides up to N phrases
 * that start with the user input.
 * 
 * Quit by entering an empty phrase.
 * 
 * @author Shiyang(Shirley) Li
 *
 */
public class PhraseCompleter {

    /**
     * main has been fully implemented for you.
     * You do not need to change this documentation for this method.
     * @param args
     */
    public static void main(String[] args) {
        // Read the phrases text file. One phrase per line.

        // This file is a reduced set of phrases provided from a site that
        // does not want the full set copied onto the Internet. Please
        // just use for this assignment.
        String[] phrases = readPhrases("w5_10.txt");

        // The phrases must be sorted to be searched.
        // The sample file is sorted already but sort anyway.
        Arrays.sort(phrases);

        // Get input from the user until an empty line.
        String inputPhrase = null;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter a starting phrase: ");
            inputPhrase = input.nextLine();

            if (inputPhrase.length() == 0)
                break; // This stops the loop.

            // Search for any phrase that starts with the inputPhrase.
            int index = binarySearchForPartialKeyMatch(phrases, inputPhrase);
            if (index == -1) {
                System.out.println("Phrase not found");
                continue; // skip the rest of the loop iteration
            }

            // Look for up to numMatches suggested phrases
            int numMatches = 7;
            // Look for up to numMatches phrases that start with the inputPhrase knowing at least one 
            // match is at index.
            String[] suggestions = getUpToNumKeyMatches(phrases, inputPhrase, index, numMatches);
            // Output the suggestions
            for (int suggestionIndex = 0; suggestionIndex < numMatches && suggestions[suggestionIndex] != null; suggestionIndex++)
                System.out.println((suggestionIndex+1) + ": " + suggestions[suggestionIndex]);
        }

        // Cleanup
        input.close();
        System.out.println("Session complete");
    }

    /**
     * Given a phrase, return a new String that is the shorter of
     * phrase.length() or subLength characters long.
     * 
     * Basically, return a substring from phrase that is the first
     * subLength characters, unless phrase is too short, in which
     * case return the phrase.
     * 
     * This method has been fully implemented for you.
     * Use this method to help write the other methods below.
     * You do not need to modify this documentation.
     * 
     * The method assumes that phrase is not null and subLength is >= 0.
     * 
     * @param phrase : a String 
     * @param subLength : an int specifying how long the sub phrase should be
     * @return a new String that is up to subLength characters long
     */
    public static String subNCharacters(String phrase, int subLength) {
        return phrase.substring(0, Math.min(phrase.length(), subLength));
    }

    /**
     * This is a modified binary search that compares a key String with the first key length 
     * characters of the Strings in the vals array.
     * 
     * This search does not distinguish between two Strings that have the same first letters
     * as key. So for a key of "David", "David Johnson" and "David Letterman" would both
     * count as equal to the key.
     * 
     * This search uses the lexicographic ordering specified by String compareTo.
     *
     * Assumes vals is sorted in ascending order.
     * 
     * @param vals : an array of phrases
     * @param key : the start of a phrase. 
     * @return the index where the start of val matches key, or -1 otherwise.
     */
    public static int binarySearchForPartialKeyMatch(String[] vals, String key) {
        int lo = 0;
        int hi = vals.length -1;
        while(lo <= hi) {
            int valsLength = hi- lo+ 1;
            int mid = valsLength/2 + lo;
            String phrase = subNCharacters (vals[mid], key.length());
            if (phrase.compareTo(key) == 0)
                return mid;
            if (phrase.compareTo(key) < 0)
                lo = mid + 1;
            else 
                hi = mid - 1;
        }
        return -1;
    }

    /**
     * Given an array of phrases and a key phrase located at startIndex that matches the beginning 
     * of the phrase, find up to numMatches phrases that all have their beginning start with the
     * key phrase.
     * 
     * If there are numMatches or more phrases that match, then any numMatches of those can be returned.
     * If there are less than numMatches phrases that match, then all should be returned and 
     * the rest of the array should end with null values.
     * 
     * You have a lot of freedom here for your solution. Your problem-solving is
     * critical here, not just your coding.
     * 
     * @param phrases : an array of phrases
     * @param key : the string that should make the beginning of returned Strings
     * @param startIndex : the location where search found a phrase with a start matching key. 
     * @return an array of numMatches String filled with up to numMatches matching phrases and 
     * the rest null.
     */
    public static String[] getUpToNumKeyMatches(String[] phrases, String key, int startIndex, int numMatches) {
        String[] keyMatches = new String[numMatches];
        int numMatchesSoFar = 0;
        for(int i = 0; i < phrases.length; i++) {
            String phrase = phrases[i];
            if(key.charAt(startIndex) == phrase.charAt(0) && numMatchesSoFar < numMatches) {
                keyMatches[numMatchesSoFar] = phrases[i];
                numMatchesSoFar++;
            }
        }
        return keyMatches;
    }

    /**
     * Reads the file at filename. The file has lines of 5 word phrases 
     * that occur in English. 
     * 
     * This method has been implemented for you. It is almost the same
     * as the method that read a file in A5.
     * You do not need to modify this documentation.
     * 
     * @param filename
     * @return An array with all the phrase lines.
     */
    public static String[] readPhrases(String filename) {
        File file = new File(filename);
        // Count the lines in the file
        int lineCount = 0;
        try (Scanner fs = new Scanner(file)) {
            while (fs.hasNextLine()) {
                // A phrase has a line of text
                fs.nextLine();
                lineCount++;
            }
            fs.close();
        } catch (FileNotFoundException e) {
            return null;
        }

        // Store the lines from the file
        String[] lines = new String[lineCount];
        int count = 0;
        try (Scanner fs = new Scanner(file)) {
            while (fs.hasNextLine()) {
                String line = fs.nextLine();
                // Our sample file has tabs instead of spaces. Turn into spaces.
                line = line.replace('\u0009',  ' ');
                // get rid of a space at the beginning
                lines[count] = line.substring(1);
                count++;
            }
            fs.close();
        } catch (FileNotFoundException e) {
            return null;
        }
		
		return lines;
	}
}
