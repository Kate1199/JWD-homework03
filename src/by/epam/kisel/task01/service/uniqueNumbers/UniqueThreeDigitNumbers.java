package by.epam.kisel.task01.service.uniqueNumbers;

/**
 * Class checks is this number unique three-digit number
 * @author Kate Kisel
 *
 */
public class UniqueThreeDigitNumbers implements WhichNumber {
	
	private final static int LOWEST_BORDER_OF_THREE_DIGITS_NUMBERS = 100;
	private final static int HIGHEST_BORDER_OF_THREE_DIGITS_NUMBERS = 1000;
	

	@Override
	public boolean isSuchNumber(int number) {
		boolean unique = false;

		if (Math.abs(number) >= LOWEST_BORDER_OF_THREE_DIGITS_NUMBERS 
				&& Math.abs(number) < HIGHEST_BORDER_OF_THREE_DIGITS_NUMBERS) {
			int digit1 = number / 100;
			int digit2 = (number / 10) % 10;
			int digit3 = number % 10;
			unique = digit1 != digit2 && digit1 != digit3 && digit2 != digit3;
		}
		return unique;
	}

}
