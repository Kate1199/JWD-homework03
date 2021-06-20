package by.epam.kisel.task01.service.minMaxNumber;

import by.epam.kisel.task01.collection.IntArray;

/**
 * Class that implements MinMaxInterface for maximum numbers
 * @author Kate Kisel
 *
 */
public class Max implements MinMaxNumber {

	@Override
	public int findNumber(IntArray array, int elementOfArray, int max) {
		if(elementOfArray > max) {
			max = elementOfArray;
		}
		return max;
	}
}
