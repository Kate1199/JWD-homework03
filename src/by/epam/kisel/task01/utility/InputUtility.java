package by.epam.kisel.task01.utility;

import java.util.Scanner;

import by.epam.kisel.task01.collection.IntArray;

/**
 * Class for input an array from console
 * @author Kate Kisel
 *
 */
public class InputUtility {

	private static Scanner sc = new Scanner(System.in);

	/**
	 * inputs array from console
	 * @param text message that appears in console before input 
	 * @return collection of numbers
	 */
	public static IntArray inputArray(String text) {
		IntArray numbers = new IntArray();

		int size = inputInt("Input size of array");

		System.out.println(text);
		for (int i = 1; i <= size; i++) {
			numbers.add(inputInt());
		}
		return numbers;
	}

	/**
	 * inputs one number
	 * @return inputed number
	 */
	private static int inputInt() {
		int x;
		while (!sc.hasNextInt()) {
			sc.next();
		}
		x = sc.nextInt();

		return x;
	}
	
	/**
	 * inputs number
	 * @param text message that appears before input
	 * @return inputed number
	 */
	private static int inputInt(String text) {

		int x;
		System.out.println(text);

		while (!sc.hasNextInt()) {
			sc.next();
		}
		x = sc.nextInt();

		return x;

	}

}
