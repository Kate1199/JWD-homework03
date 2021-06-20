package by.epam.kisel.task01.service.search;

import by.epam.kisel.task01.collection.IntArray;
import by.epam.kisel.task01.exception.NumberNotFoundException;

/**
 * Class to search array for numbers, or minimum and maximum numbers
 * @author Kate Kisel
 *
 */
public class NumberSearch {

	private static int left;
	private static int right;
	private static int middleIndex;
	private static int middle;
	private static Range rightRange;
	private static Range leftRange;

	/**
	 * searches the array for a key number
	 * 
	 * @param key   key number
	 * @param array the array to search for
	 * @return desired number
	 * @throws NumberNotFoundException
	 */
	public static boolean findItemBinarySearch(int key, IntArray array) {
		if (array == null || array.isEmpty())
			return false;
		boolean isThereSuchNumber;
		left = 0;
		right = array.size() - 1;
		middleIndex = array.size() / 2;
		middle = array.get(middleIndex);

		rightRange = new RightRange(right);
		leftRange = new LeftRange(left);

		while (left < right && !isKeyEqualsMiddle(key)) {
			defineRange(array, key);
		}
		isThereSuchNumber = isKeyEqualsMiddle(key);
		return isThereSuchNumber;
	}

	/**
	 * scans the array, defines a search range. If the key is less than middle, then
	 * the right border of the array is shifted and a middle is recalculated. Else
	 * if the key is more than middle, then the left boarder is shifted and a middle
	 * is recalculated. If key equals middle, then does nothing.
	 * 
	 * @param array the array to scan
	 * @param key   key number
	 */
	private static void defineRange(IntArray array, int key) {

		if (key < middle) {
			right = rightRange.moveSide(middleIndex);
			recalculateMiddle(rightRange, array);
		} else if (key > middle) {
			left = leftRange.moveSide(middleIndex);
			recalculateMiddle(leftRange, array);
		} else {
		}
	}

	private static boolean isKeyEqualsMiddle(int key) {
		return key == middle;
	}

	/**
	 * corrects the index of middle number and calculates middle number again
	 * 
	 * @param range right or left range for calculating new middle number
	 * @param array the array to search in
	 */
	private static void recalculateMiddle(Range range, IntArray array) {
		correctMiddleIndex();
		middle = range.findNewMiddle(array, middleIndex);
	}

	/**
	 * calculates the index of middle number. If the index is less than one, then
	 * index equals one. If left border matches right border the index of middle
	 * number is zero.
	 */
	private static void correctMiddleIndex() {
		middleIndex = middleIndex / 2;
		if (middleIndex < 1) {
			middleIndex = 1;
		}
		if (left == right) {
			middleIndex = 0;
		}
	}
}
