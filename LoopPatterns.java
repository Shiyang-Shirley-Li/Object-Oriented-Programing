/**
 * @author Shiyang Li, LoopPatterns
 */
package test;
import java.util.Scanner;
public class LoopPatterns {
	/**
	 * displaying the smallest positive number to the console
	 * displaying true or false for judging if a string is the same forwards and backwards
	 * displaying true or false for judging if a string of numbers has more even than odd
	 * dispalying camalCase of a string of words
	 * displaying the lowest alphabetically word in a string of words
	 * displaying a times table
	 */
	public static void main(String[] args) {
		System.out.println("Find Smallest Positive Number:");
		System.out.println(findSmallestPositiveNumber("2 -4 -5 "));
		System.out.println(findSmallestPositiveNumber("-2 0 1 5 1"));
		System.out.println(findSmallestPositiveNumber("0  3 -2 -5 2 1"));
		System.out.println();
		System.out.println("Is palindrome or not:");
		System.out.println(isPalindrome("abba") );
		System.out.println(isPalindrome("abca") );
		System.out.println(isPalindrome("syyys") );
		System.out.println();
		System.out.println("Has more even than odd or not:");
		System.out.println(hasMoreEvenThanOdd("1 3 4 6 -8"));
		System.out.println(hasMoreEvenThanOdd("2 4 7 9 11 -1"));
		System.out.println(hasMoreEvenThanOdd("4 8 1 -1"));
		System.out.println();
		System.out.println("Camal case:");
		System.out.println(camalCase("first letter in word"));
		System.out.println(camalCase("i love sy"));
		System.out.println(camalCase("hi how are you"));
		System.out.println();
		System.out.println("Find the lowest alphavetically:");
		System.out.println(lowestAlphabetically("cat dog apple fish") );
		System.out.println(lowestAlphabetically("america china japan ") );
		System.out.println(lowestAlphabetically("orange blue green yellow") );
		System.out.println();
		System.out.println("Draw times table");
		System.out.println(timesTable(3, 3));
		System.out.println(timesTable(6, 6));
		System.out.println(timesTable(9, 9));
		System.out.println();
	}
	/**
	 * find and returns the smallest positive number
	 * @param sentence, a string holds at least one positive number
	 * @return smallestSoFar, an int value that is the smallest positive number
	 */
	public static int findSmallestPositiveNumber(String sentence){
		Scanner s = new Scanner (sentence);
		int smallestSoFar = 0;
		String positiveSentence = "";
		while (s.hasNext()) {
			smallestSoFar = s.nextInt();
			if (smallestSoFar > 0 ) {
				positiveSentence += " " + smallestSoFar;
			}
		}
		Scanner r = new Scanner (positiveSentence);
		smallestSoFar = r.nextInt();
		while (r.hasNextInt()) {
			int num = r.nextInt();
			if (num < smallestSoFar) 
				smallestSoFar = num;
		}
		return smallestSoFar;
	}
	/**
	 * To check if the string reads the same forwards as backwards
	 * @param word, a string holds a word
	 * @return true or false, return true if the string reads the same forwards as backwards, 
	 * otherwise return false. 
	 */
	public static boolean isPalindrome(String word) {
		int number = word.length() - 1;
		int index = 0;
		String half1 = "";
		String half2 = "";
		while ( number > 0) {
			half1 = half1 + word.charAt(number);
			half2 = half2 + word.charAt(index);
			number--;
			index++;
		}
		if (half1.equals(half2)) {
			return true;
		}
		else
			return false;
	}
	/**
	 * To check if a string of number has more even than odd
	 * @param numbers, a string holds integer numbers separated by space
	 * @return true or false, true if the number of even numbers in the String 
	 * is greater than the number of odd numbers and false otherwise
	 */
	public static boolean hasMoreEvenThanOdd(String numbers) {
		Scanner s = new Scanner(numbers);
		int numberOfEven = 0;
		int numberOfOdd = 0;
		while(s.hasNextInt()){
			int num = s.nextInt();
			if(num % 2 == 0) {
				numberOfEven++;
			}
			else
				numberOfOdd++;		
		}
		if (numberOfEven > numberOfOdd) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * To change a string of the words into camelCase form
	 * @param sentence, a string of lower-case words separated by spaces
	 * @return firstCharacter + capitalizedWord, a String of the words in camelCase form
	 */
	public static String camalCase(String sentence) {
		Scanner s = new Scanner(sentence);
		String firstCharacter = "";
		String word = "";
		String character = "";
		String capitalizedWord = "";
		if(s.hasNext()) {
			firstCharacter = s.next();
		}
		while(s.hasNext()){
			word = s.next();
			character = word.substring(0,1);
			capitalizedWord = capitalizedWord + character.toUpperCase() + word.substring(1, word.length());
		}
		return firstCharacter + capitalizedWord;
	}
	/**
	 * To find a String containing the lowest alphabetical word
	 * @param words, a not empty String of lower-case words separated by spaces
	 * @return lowestAlphaWord, a String containing the lowest alphabetical word
	 */
	public static String lowestAlphabetically (String words){
		Scanner s = new Scanner(words);
		String word = "";
		String lowestAlphaWord = "";
		int result = 0;
		if (s.hasNext()) {
			lowestAlphaWord = s.next();
		}
		while(s.hasNext()) {
			word = s.next();
			result = lowestAlphaWord.compareTo(word);
			if(result > 0) {
				lowestAlphaWord = word;
			}
		}
		return lowestAlphaWord;
	}

	/**
	 * 
	 * @param maxNumber, an integer number from 1-9 (inclusive) representing
	 *  how many rows and columns there are in a times table
	 * @param spacing, an integer number that is a number greater than 1 
	 *  which represents the width a column of the times table must take up
	 * @return times table
	 */
	public static String timesTable(int maxNumber, int spacing) {
		String returnVal = "";
		String notation = minusNotation(maxNumber, spacing);
		
		for(int j = 0; j <= maxNumber+1; j++) {
			if(j == 0) {
				returnVal += "  " + numRows(maxNumber, spacing, 1) + "\n";
			}
			if(j == 1) {
				returnVal += "  " + notation + "\n";
			}
			else if(j >= 2){
				int headNum = j - 1;
				returnVal += headNum + "|" + numRows(maxNumber, spacing, headNum) + "\n";
			}
		}
		
		return returnVal;
	}
	
	private static String numRows(int maxNumber, int spacing, int rowNum) {
		
		String numRow = "";
		String spaces = space(spacing);
		
		for(int i = 1; i <= maxNumber; i++) {
			int num = rowNum * i;
			int numLen = String.valueOf(num).length();
			if(numLen > 1) {
				numRow += spaces.substring(numLen - 1) + num;
			}
			else if(numLen == 1){
				numRow += spaces + num;
			}		
		}
		
		return numRow;
	}
	
	private static String minusNotation(int maxNumber, int spacing) {
		String minus = "";
		for(int i = 0; i < spacing * maxNumber; i++) {
			minus += "-";
		}
		return minus;
	}
	
	private static String space(int spacing) {
		int intervals = spacing - 1;
		String spaces = "";
		
		for(int i = 0; i < intervals; i++) {
			spaces += " ";
		}
		
		return spaces;
	}
}
