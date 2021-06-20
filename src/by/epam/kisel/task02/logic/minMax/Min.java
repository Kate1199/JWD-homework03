package by.epam.kisel.task02.logic.minMax;

public class Min implements MaxMinNumbers{

	@Override
	public boolean findNumbers(int min, int element) {
		return min > element;
	}
	
}
