package by.epam.kisel.task01.service.minMaxNumber;

import by.epam.kisel.task01.collection.IntArray;

/**
 * interface to search array for minimum or maximum numbers
 * @author Kate kisel
 *
 */
public interface MinMaxNumber {
	
	/**
	 * finds minimum or maximum number of array
	 * @param array the array to search
	 * @param elementOfArray current element of the array
	 * @param minOrMax current minimum or maximum number of the array
	 * @return minimum or maximum number of the array
	 */
	public int findNumber(IntArray array, int elementOfArray, int minOrMax);
}
