package by.epam.kisel.task01.service.minMaxNumber;

import by.epam.kisel.task01.collection.IntArray;
import by.epam.kisel.task01.exception.EmptyArrayException;

/**
 * Class that search array for the smallest and the biggest numbers
 * @author Kate Kisel
 *
 */
public class MinMaxSearch {
	
	/**
	 * searching the array for the smallest number
	 * @param array the array to search for
	 * @return the smallest number in the array
	 * @throws EmptyArrayException
	 */
	public static int findMin(IntArray array) throws EmptyArrayException {
		return findMinOrMaxNumber(array, new Min());
	}

	/**
	 * searching the array for the biggest number
	 * @param array the array to search for
	 * @return the biggest number in the array
	 * @throws EmptyArrayException
	 */
	public static int findMax(IntArray array) throws EmptyArrayException {
		return findMinOrMaxNumber(array, new Max());
	}

	/**
	 * finds minimal or maximum number depending on implementation of the  MinMaxNumber interface.
	 * If the array is null or empty, then throws EmptyArrayException.
	 * @param array the array to search for
	 * @param number select minimum or maximum search
	 * @return minimum or maximum number
	 * @throws EmptyArrayException
	 */
	private static int findMinOrMaxNumber(IntArray array, MinMaxNumber number) throws EmptyArrayException {
		if (array == null || array.isEmpty()) {
			throw new EmptyArrayException("Array is empty");
		}
		int minOrMaxNumber = array.get(0);

		for (int elementOfArray : array) {
			minOrMaxNumber = number.findNumber(array, elementOfArray, minOrMaxNumber);
		}
		return minOrMaxNumber;
	}

}
