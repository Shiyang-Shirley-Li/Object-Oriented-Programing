package test;

import java.util.Scanner;

/**
 * 
 * @author Shiyang(Shirley) Li
 */

public class MethodCollection {

	/**
	 * @param args
	 * In main, it exercises all the methods below. This code will call the methods with
	 * different arguments and print out results. 
	 */
	public static void main(String[] args) {
		System.out.println(countTokens("this is a test"));
		System.out.println(countTokens(""));
		
		System.out.println(countTokensThatAreNotInt("this is 12 a test"));
		System.out.println(countTokensThatAreNotInt("12"));
		
		System.out.println(describeSign(7));
		System.out.println(describeSign(0));
		System.out.println(describeSign(-2));
		
		System.out.println(isEvenlyDivisibleBySeven(14));
		System.out.println(isEvenlyDivisibleBySeven(16));
		
		System.out.println(makeLine('+', '-', 8));
		
		System.out.println(makeSquare(7));
		
		System.out.println(capitalizeLastCharacter("hello"));
		System.out.println(capitalizeLastCharacter("JACK"));
		
		System.out.println(capitalizeLastCharactersInSentence("Hello there"));
	}

	/**
	 * @param sentence - a string of a sentence
	 * @return the number of tokens (as identified by the s.next() method on a
	 * Scanner s) that appears in the parameter sentence.
	 */
	public static int countTokens(String sentence) {
		Scanner sentenceScanner = new Scanner(sentence);
		int numOfTokens = 0;
		
		while(sentenceScanner.hasNext()) {
			sentenceScanner.next();
			numOfTokens ++;
		}
		
		sentenceScanner.close();
		return numOfTokens;
	}

	/**
	 * 
	 * @param sentence - a string of a sentence
	 * @return the number of tokens (as identified by the s.next() method on
	 * Scanners s) in the parameter sentence that are not an int, as identified by
	 * s.hasNextInt().
	 */
	public static int countTokensThatAreNotInt(String sentence) {
		Scanner sentenceScanner = new Scanner(sentence);
		int numOfNotIntTokens = 0;
		
		while(sentenceScanner.hasNext()) {
			if(!sentenceScanner.hasNextInt()) {
				numOfNotIntTokens ++;
			}
			sentenceScanner.next();
		}
		
		sentenceScanner.close();
		return numOfNotIntTokens;
	}

	/**
	 * @param value - an integer
	 * @return returns a string literal "negative" if the parameter is less than zero and
	 * returns the string literal "non-negative" if the value is greater than or
	 * equal to zero.
	 */
	public static String describeSign(int value) {
		if(value < 0) {
			return "negative";
		}
		return "non-negative";
	}

	/**
	 * @param value - an integer
	 * @return true if the value parameter is evenly divisible by 7 and false
	 * otherwise.
	 */
	public static boolean isEvenlyDivisibleBySeven(int value) {
		if(value % 7 != 0) {
			return false;
		}
		return true;
	}

	/**
	 * @param edge - a character of the edge notation
	 * @param inner - a character of the inner notation
	 * @param width - the number of edge and inner notations
	 * @return a String of length width that begins and ends with the character edge
	 * and contains width-2 copies of the character inner in between.
	 */
	public static String makeLine(char edge, char inner, int width) {
		String line = "";
		int i = 0;
		while (i < width - 2) {
			line = line + inner;
			i = i + 1;
		}
		return edge + line + edge;
	}
	
	/**
	 * @param width - number of lines and must be greater than or equal to 2
	 * @return a string which, when printed out, will be a square shaped like this,
	 * but of varying size:
	 * 
	 * <pre>
	 * +-----+
	 * |     |
	 * |     |
	 * |     |
	 * |     |
	 * |     |
	 * +-----+
	 * </pre>
	 */
	public static String makeSquare(int width) {
		String square = "";
		for(int i = 0; i < width; i++) {
			if(i == 0 || i == width - 1) {
				square += makeLine('+', '-', width) + '\n';
			}
			else {
				square += makeLine('|', ' ', width) + '\n';
			}
		}
		return square;
	}

	/**
	 * @param word - a string 
	 * @return the string that results from capitalizing the last character of word,
	 * which is required to have at least one character.
	 */
	public static String capitalizeLastCharacter(String word) {
		String capLastCharWord = "";
		int lenOfWord = word.length();
		
		capLastCharWord += word.substring(0, lenOfWord-1);
		capLastCharWord += Character.toUpperCase(word.charAt(lenOfWord-1));
		
		return capLastCharWord;
	}

	/**
	 * @param sentence
	 * @return the string that results from capitalizing the last character of every
	 * word in the input parameter sentence, which is required to have at least one
	 * character.
	 */
	public static String capitalizeLastCharactersInSentence(String sentence) {
		String newSentence = "";
		Scanner sentenceSc = new Scanner(sentence);
		
		while(sentenceSc.hasNext()) {
			newSentence += capitalizeLastCharacter(sentenceSc.next()) + " ";
		}
		
		newSentence = newSentence.substring(0, newSentence.length()-1);//delete the last space at the end
		
		sentenceSc.close();
		return newSentence;
	}

}
