package by.epam.kisel.task01.service;

import by.epam.kisel.task01.collection.IntArray;

/**
 * Class which sorts array in different ways
 * @author Kate Kisel
 *
 */
public class SortArray {
	/**
	 * sorts numbers using the bubble sort algorithm
	 * @param array the array to sort
	 */
	public static boolean bubbleSort(IntArray array) {
		if(isNull(array)) return false;
		for (int i = 0; i < array.size(); i++) {
			for (int j = 0; j < array.size(); j++) {
				replaceNeighborNumbers(array, i, j);
			}
		}
		return true;
	}
	
	/** 
	 * swaps the highest and the lowest positions
	 * @param array the array whose numbers are swapped
	 * @param i the lowest number
	 * @param j the highest number
	 */
	private static void replaceNumbers(IntArray array, int i, int j) {
		int temp;
		
		temp = array.get(j);
		array.set(j, array.get(i));
		array.set(i, temp);
	}
	
	/**
	 * if the number on the left is smaller than on the right, then replaces them
	 * @param array the array to search
	 * @param left the left number
	 * @param right the right number
	 */
	private static void replaceNeighborNumbers(IntArray array, int left, int right) {
		if (array.get(left) < array.get(right)) {
			replaceNumbers(array, left, right);
		}
	}
	
	private static boolean isNull(IntArray array) {
		return array == null;
	}

	/**
	 * sorts numbers from the largest to the smaller
	 * @param array the array to sort
	 */
	public static void reverseSort(IntArray array) {
		bubbleSort(array);
		reverse(array);
	}
	
	/**
	 * sorts numbers in reverse order
	 * @param array the array to sort
	 * @return false, if array is null, otherwise returns true
	 */
	public static boolean reverse(IntArray array) {
		if(array == null) return false;
		int i = array.size() - 1;
		for (int j = 0; j < array.size() / 2; j++) {
			replaceNumbers(array, i, j);
			i--;
		}
		return true;
	}


	
	

	
	
}
