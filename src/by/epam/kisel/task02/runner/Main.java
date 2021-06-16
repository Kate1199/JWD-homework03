package by.epam.kisel.task02.runner;

import by.epam.kisel.task02.logic.ArrayLogic;
import by.epam.kisel.task02.view.ArrayView;

public class Main {

	public static void main(String[] args) {
		
		int[] iA1 = { 5, 4, 6 };
		int[] iA2 = { 2, 1, 45, 3, -6 };
		int[] iA3 = { 9, 56, 7, 23 };
		int[][] array = { iA1, iA2, iA3 };
		
		int[] sum = ArrayLogic.sortSum(array);
		int[] reverseSum = ArrayLogic.reverseSortSum(array);
		int[] max = ArrayLogic.sortMax(array);
		int[] reverseMax = ArrayLogic.reverseSortMax(array);
		int[] min = ArrayLogic.sortMin(array);
		int[] reverseMin = ArrayLogic.reverseSortMin(array);
		
		ArrayView.printArray(array);
		System.out.println();
		
		ArrayView.printArray("sum", sum);
		ArrayView.printArray("reverseSum", reverseSum);
		ArrayView.printArray("max", max);
		ArrayView.printArray("reverseMax", reverseMax);
		ArrayView.printArray("min", min);
		ArrayView.printArray("reverseMin", reverseMin);



	}

}
