package by.epam.kisel.task01.utility;

import java.util.Scanner;

import by.epam.kisel.task01.collection.IntArray;

public class InputUtility {

	private static Scanner sc = new Scanner(System.in);

	public static IntArray inputArray(String text) {
		IntArray numbers = new IntArray();

		int size = inputInt("Input size of array");

		System.out.println(text);
		for (int i = 1; i <= size; i++) {
			while (!sc.hasNextInt()) {
				sc.next();
			}
			numbers.add(sc.nextInt());
		}
		return numbers;
	}

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
