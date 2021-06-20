package by.epam.kisel.task02.logic.minMax;

public class Max implements MaxMinNumbers {

	@Override
	public boolean findNumbers(int max, int element) {
		return max < element;
	}
	
}
