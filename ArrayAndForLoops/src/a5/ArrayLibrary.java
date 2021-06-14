package a5;
/**
 * 
 * @author Shiyang(Shirley) Li
 */
public class ArrayLibrary {
	/**
	 * Put a zero in each element of the arr array.
	 * 
	 * @param arr: An int array. You may assume that this is not null. It may be zero length.
	 */
	public static void clear(int[] arr) {
		for(int i =0; i < arr.length; i++) {
			arr[i] = 0;
		}
	}
	
	/**
	 * Make our own version to Arrays.toString for an int array. The format is curly braces
	 * instead of square brackets, with a comma and space between elements. So
	 * arrayToString([1,2,3]) -> "{1, 2, 3}"
	 * arrayToString([]) -> "{}"
	 * @param arr: an integer array. You may assume it is not null, but it may be length 0.
	 * @return a String as described above.
	 */
	public static String arrayToString(int[] arr ) {
		String arrString = "{";
		for(int i = 0; i < arr.length; i++) {
			arrString += arr[i] + ", ";
		}
		
		if(arr.length > 0) {
			arrString = arrString.substring(0, arrString.length() - 2) + "}";
		}
		else {
			arrString += "}";
		}
		
		return arrString;
	}
	
	/**
	 * Searches to see if any element has a duplicate value in the array.
	 * @param arr: an Array of String. You may assume that arr is not null, and no element of arr is null.
	 * 			   arr may be zero length and the String elements may be zero length.
	 * @return true if there is a duplicate value, false otherwise.
	 * Note: You may not use convert the Array to another type and use methods like
	 * contains() to solve this problem.
	 */
	public static boolean containsDuplicate(String[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if((arr[i]).equals(arr[j])) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Computes the average of all the elements in the integer array parameter.
	 * @param arr : An integer array. You may assume arr is not null and has at least 1 element.
	 * @return the average of all the element values.
	 */
	public static double averageArrayValues(int[] arr) {
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return (double)sum/arr.length;
	}
	
	/**
	 * frequencyCount takes in an array of integer values that must be from 0 to 9. You can assume
	 * the values are in that range. The method produces a new array of 10 integers. The value at index
	 * 0 is the number of times 0 appears in the elements of the array parameter. The value at index 1 is
	 * the number of times 1 appears in the elements of the array parameter - and so on up to index 9.
	 * @param arr: An array of integers. The integers must only be valued 0-9. The array can be length 0.
	 * @return an array of size 10 holding the counts for each digit in the parameter array. If we call
	 * 			frequencyCount([0,0,1,1,1,7]), then it would return [2,3,0,0,0,0,0,1,0,0] since there are
	 * 		   2 zeroes and 3 ones and 1 seven, and no other digits.
	 */
	public static int[] frequencyCount(int[] arr) {
		int[] frequencyArr = new int[10];
		for(int i = 0; i < arr.length; i++) {
			frequencyArr[arr[i]] += 1;
		}
		return frequencyArr;
	}
		
}
