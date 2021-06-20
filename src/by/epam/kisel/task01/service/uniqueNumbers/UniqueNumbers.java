package by.epam.kisel.task01.service.uniqueNumbers;

import by.epam.kisel.task01.collection.IntArray;
import by.epam.kisel.task01.exception.EmptyArrayException;

/**
 * Class that search array for simple numbers, fibonacci numbers and unique three digit numbers
 * @author Kate Kisel
 *
 */
public class UniqueNumbers {

	/**
	 * search array for simple numbers
	 * @param array the array to search
	 * @return collection of simple numbers
	 */
	public static IntArray findSimpleNumbers(IntArray array) {
		
		return findUniqueNumbers(array, new SimpleNumbers());
	}
	
	/**
	 * adds all numbers to new array depending on is it simple, fibonacci or unique three-digit number 
	 * @param array the array to search
	 * @param number Simple, fibonacci or unique three-digit number
	 * @return collection of unique numbers
	 */
	private static IntArray findUniqueNumbers(IntArray array, WhichNumber number) {
		if(array == null) {
			return new IntArray();
		}
		IntArray newArray = new IntArray();
		for(int elementOfArray : array) {
			addNumberToArray(newArray, number, elementOfArray);
		}
		return newArray;
	}
	
	/**
	 * adds number to array, if it is unique (simple, fibonacci, uniaue three-digit)
	 * @param newArray the array to search
	 * @param number simple, fibpnacci or unique three-digit number
	 * @param elementOfArray current element of array
	 */
	private static void addNumberToArray(IntArray newArray, WhichNumber number, int elementOfArray) {
		if(number.isSuchNumber(elementOfArray)) {
			newArray.add(elementOfArray);
		}
	}

	/**
	 * search array for fibonacci numbers
	 * @param array the array to search
	 * @return collection of fibonacci numbers
	 */
	public static IntArray findFibonacciNumbers(IntArray array) {
		
		return findUniqueNumbers(array, new FibonacciNumbers());
	}

	/**
	 * search for unique three-digit numbers
	 * @param array the array to search
	 * @return collection of unique three-digit numbers
	 */
	public static IntArray findUniqueTreeDigitNumbers(IntArray array) {
		
		return findUniqueNumbers(array, new UniqueThreeDigitNumbers());
	}
}
