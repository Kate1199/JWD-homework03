package by.epam.kisel.task01.service.uniqueNumbers;

/**
 * Class that checks is this number fibonacci
 * @author Kate Kisel
 *
 */
public class FibonacciNumbers implements WhichNumber {
	
	private final static int FIRST_FIBONACCI_NUMBER = 1;
	

	@Override
	public boolean isSuchNumber(int number) {
		int twoNumbersBack = FIRST_FIBONACCI_NUMBER;
		int oneNumberBack = FIRST_FIBONACCI_NUMBER;
		int currentNumber = twoNumbersBack + oneNumberBack;
		while (currentNumber < number) {
			twoNumbersBack = oneNumberBack;
			oneNumberBack = currentNumber;
			currentNumber = twoNumbersBack + oneNumberBack;
		}
		return (number == currentNumber) || (number == FIRST_FIBONACCI_NUMBER);
	}
}
