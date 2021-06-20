package by.epam.kisel.task01.service.minMaxNumber;

import by.epam.kisel.task01.collection.IntArray;

/**
 * Class that implements MinMaxInterface for minimum numbers
 * @author Kate Kisel
 *
 */
public class Min implements MinMaxNumber {
	
	@Override
	public int findNumber(IntArray array, int elementOfArray, int min) {
		if(elementOfArray < min) {
			min = elementOfArray;
		}
		return min;
	}
}
