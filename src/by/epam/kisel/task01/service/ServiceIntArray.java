package by.epam.kisel.task01.service;

import by.epam.kisel.task01.collection.IntArray;
import by.epam.kisel.task01.exception.EmptyArrayException;
import by.epam.kisel.task01.exception.NumberNotFoundException;

public class ServiceIntArray {

	public static void sort(IntArray array) throws EmptyArrayException {
		throwEmptyArrayException(array);
		for (int i = 0; i < array.size(); i++) {
			for (int j = 0; j < array.size(); j++) {
				replaceNumbers(array, i, j);
			}
		}
	}
	
	private static void throwEmptyArrayException(IntArray array) throws EmptyArrayException {
		if (array == null || array.isEmpty()) {
			throw new EmptyArrayException("Array is empty");
		}
	}

	private static void replaceNumbers(IntArray array, int i, int j) {
		int temp;

		if (array.findByIndex(i) < array.findByIndex(j)) {
			temp = array.findByIndex(j);
			array.place(j, array.findByIndex(i));
			array.place(i, temp);
		}
	}

	public static void reverseSort(IntArray array) throws EmptyArrayException {
		sort(array);
		reverse(array);
	}

	public static void reverse(IntArray array) throws EmptyArrayException {
		throwEmptyArrayException(array);
		int j = array.size() - 1;
		for (int i = 0; i < array.size() / 2; i++) {
				reverseElements(array, i, j);
				j--;
		}
	}

	private static void reverseElements(IntArray array, int i, int j) {
		int temp;
		temp = array.findByIndex(i);
		array.place(i, array.findByIndex(j));
		array.place(j, temp);
	}

	public static int findElement(int key, IntArray array) throws NumberNotFoundException, EmptyArrayException {
		IntArray copy = array.copy();
		sort(copy);

		int left = 0;
		int right = copy.size() - 1;
		int middleIndex = copy.size() / 2;
		int middle = copy.findByIndex(middleIndex);

		while (left < right) {

			if (key < middle) {
				right = right - middleIndex;
				middleIndex = correctMiddleIndex(middleIndex, left, right);
				middle = copy.findByIndex(right - middleIndex);
			} else if (key == middle) {
				break;
			} else {
				left = left + middleIndex;
				middleIndex = correctMiddleIndex(middleIndex, left, right);
				middle = copy.findByIndex(left + middleIndex);
			}
		}
		throwNumberNotFoumdException(key, middle);
		return middle;
	}

	private static int correctMiddleIndex(int middleIndex, int left, int right) {
		middleIndex = middleIndex / 2;
		if (middleIndex < 1) {
			middleIndex = 1;
		}
		if (left == right) {
			middleIndex = 0;
		}
		return middleIndex;
	}

	private static void throwNumberNotFoumdException(int key, int middle) throws NumberNotFoundException {
		if (key != middle) {
			throw new NumberNotFoundException("number not found");
		}
	}

	public static int findMin(IntArray array) throws EmptyArrayException {
		return findMinOrMaxNumber(array, false);
	}

	public static int findMax(IntArray array) throws EmptyArrayException {
		return findMinOrMaxNumber(array, true);
	}

	private static int findMinOrMaxNumber(IntArray array, boolean minOrMax) throws EmptyArrayException {

		throwEmptyArrayException(array);
		int minOrMaxNumber = array.findByIndex(0);

		for (int elementOfArray : array) {
			boolean statement = chooseStatement(minOrMax, elementOfArray, minOrMaxNumber);
			minOrMaxNumber = assignMinMax(minOrMaxNumber, elementOfArray, statement);
		}
		return minOrMaxNumber;
	}

	private static boolean chooseStatement(boolean max, int elementOfArray, int minOrMaxNumber) {
		if (max) {
			return elementOfArray > minOrMaxNumber;
		} else {
			return elementOfArray < minOrMaxNumber;
		}
	}

	private static int assignMinMax(int minOrMax, int element, boolean statement) {
		if (statement) {
			minOrMax = element;
		}
		return minOrMax;
	}

	public static IntArray findSimpleNumbers(IntArray array) throws EmptyArrayException {
		IntArray copy = array.copy();
		IntArray simpleNumbers = new IntArray();

		throwEmptyArrayException(array);
		for (int i = 0; i < array.size(); i++) {
			replaceNegativeNumbersWithZeros(copy, i);
			replaceNotSimpleNumbersWithZeros(copy, i);
			addSimpleNumbersToArray(i, copy, simpleNumbers);
		}
		return simpleNumbers;
	}

	private static void replaceNotSimpleNumbersWithZeros(IntArray copy, int i) {
		for (int divisor = 2; divisor < copy.findByIndex(i); divisor++) {
			if (copy.findByIndex(i) % divisor == 0) {
				copy.place(i, 0);
				break;
			}
		}
	}

	private static void replaceNegativeNumbersWithZeros(IntArray copy, int i) {
		if (copy.findByIndex(i) < 2) {
			copy.place(i, 0);
		}
	}

	private static void addSimpleNumbersToArray(int i, IntArray copy, IntArray simpleNumbers) {
		if (copy.findByIndex(i) != 0) {
			simpleNumbers.add(copy.findByIndex(i));
		}
	}

	public static IntArray findFibonacciNumbers(IntArray array) throws EmptyArrayException {
		IntArray fibonacciNumbers = new IntArray();
		IntArray copy = array.copy();

		throwEmptyArrayException(array);
		addFibonacciNumbersToArray(copy, fibonacciNumbers);
		return fibonacciNumbers;

	}

	private static void addFibonacciNumbersToArray(IntArray copy, IntArray fibonacciNumbers) {
		for (int number : copy) {
			if (isFibonacci(number)) {
				fibonacciNumbers.add(number);
			}
		}
	}

	private static boolean isFibonacci(int number) {
		int f1 = 1;
		int f2 = 1;
		int f = f1 + f2;
		while (f < number) {
			f1 = f2;
			f2 = f;
			f = f1 + f2;
		}
		return (number == f) || (number == 1);
	}

	public static IntArray findUniqueTreeDigitNumbers(IntArray array) throws EmptyArrayException {
		IntArray threeDigitNumbers = new IntArray();
		throwEmptyArrayException(array);
		addUniqueThreeDigitNumbersToArray(array, threeDigitNumbers);
		return threeDigitNumbers;
	}

	private static void addUniqueThreeDigitNumbersToArray(IntArray array, IntArray threeDigitNumbers) {
		for (int number : array) {
			if (isUnique(number)) {
				threeDigitNumbers.add(number);
			}
		}
	}

	private static boolean isUnique(int number) {
		boolean unique = false;
		
		if (Math.abs(number) >= 100 && Math.abs(number) < 1000) {
			int digit1 = number / 100;
			int digit2 = (number / 10) % 10;
			int digit3 = number % 10;
			unique = digit1 != digit2 && digit1 != digit3 && digit2 != digit3;
		}
		return unique;
	}

}
