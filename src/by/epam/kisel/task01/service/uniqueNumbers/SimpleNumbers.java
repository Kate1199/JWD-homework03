package by.epam.kisel.task01.service.uniqueNumbers;

/**
 * Class that checks is this number simple
 * @author Kate Kisel
 *
 */
public class SimpleNumbers implements WhichNumber {
	
	private static final int FIRST_SIMPLE_NUMBER = 2;

	@Override
	public boolean isSuchNumber(int number) {
		boolean isSimple = true;
		isSimple = number >= FIRST_SIMPLE_NUMBER;
		for (int divisor = FIRST_SIMPLE_NUMBER; divisor < number; divisor++) {
			if (number % divisor == 0 || number < 0) {
				isSimple = false;
				break;
			}
		}
		return isSimple;
	}	

}
