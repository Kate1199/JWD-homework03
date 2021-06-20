package by.epam.kisel.task02.logic;

import by.epam.kisel.task02.logic.minMax.Max;
import by.epam.kisel.task02.logic.minMax.MaxMinNumbers;
import by.epam.kisel.task02.logic.minMax.Min;

public class ArrayLogic {

	public static int[] sortSum(int[][] array) {
		int[] sum = findSum(array);
		return sort(sum);
	}

	private static int[] findSum(int[][] array) {
		int[] sum = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				sum[i] = sum[i] + array[i][j];
			}
		}
		return sum;
	}

	private static int[] sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				replaceElements(array, i, j);
			}
		}
		return array;
	}

	private static void replaceElements(int[] array, int i, int j) {
		if (array[j] > array[j + 1]) {
			int temp;
			temp = array[j];
			array[j] = array[j + 1];
			array[j + 1] = temp;
		}
	}

	public static int[] reverseSortSum(int[][] array) {
		int[] sortedArray = sortSum(array);
		return reverse(sortedArray);
	}

	private static int[] reverse(int[] array) {
		for (int j = 0; j < array.length / 2; j++) {
			for (int i = array.length - 1; i > array.length / 2; i--) {
				reverseElements(array, i, j);
			}
		}
		return array;
	}

	private static void reverseElements(int array[], int i, int j) {
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static int[] sortMax(int[][] array) {
		int max[] = findMinOrMaxArray(array, new Max());
		return sort(max);
	}

	private static int[] findMinOrMaxArray(int[][] array, MaxMinNumbers number) {
		int[] minOrMaxArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			minOrMaxArray[i] = findMinOrMaxNumber(array[i], number);
		}
		return minOrMaxArray;
	}

	private static int findMinOrMaxNumber(int[] array, MaxMinNumbers number) {
		int minOrMaxNumber = array[0];

		for (int elementOfArray : array) {
			assignMinMax(number, elementOfArray, minOrMaxNumber);
		}
		return minOrMaxNumber;
	}

	private static int assignMinMax(MaxMinNumbers number, int element, int minMax) {
		if (number.findNumbers(minMax, element)) {
			minMax = element;
		}
		return minMax;
	}

	public static int[] reverseSortMax(int[][] array) {
		int[] reverseMax = sortMax(array);
		return reverse(reverseMax);
	}

	public static int[] sortMin(int[][] array) {
		int min[] = findMinOrMaxArray(array, new Min());
		return sort(min);
	}

	public static int[] reverseSortMin(int[][] array) {
		int[] reverseMin = sortMin(array);
		return reverse(reverseMin);
	}

}
