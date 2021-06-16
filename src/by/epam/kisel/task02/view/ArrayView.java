package by.epam.kisel.task02.view;

public class ArrayView {

	public static void printArray(int[][] array) {
		System.out.print("{ ");
		for (int i = 0; i < array.length; i++) {
			printArray(array[i]);
		}
		System.out.println("}");
	}

	public static void printArray(int[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length - 1; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println(array[array.length - 1] + "]");
	}

	public static void printArray(String text, int[] array) {
		System.out.print(text + ": ");
		printArray(array);
	}
}
