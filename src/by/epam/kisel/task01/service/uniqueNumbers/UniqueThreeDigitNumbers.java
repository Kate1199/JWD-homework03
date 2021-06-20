package by.epam.kisel.task01.service.uniqueNumbers;

/**
 * Class checks is this number unique three-digit number
 * @author Kate Kisel
 *
 */
public class UniqueThreeDigitNumbers implements WhichNumber {

	@Override
	public boolean isSuchNumber(int number) {
		boolean unique = false;

		if (Math.abs(number) >= 100 && Math.abs(number) < 1000) {
			int digit1 = number / 100;
			int digit2 = (number / 10) % 10;
			int digit3 = number % 10;
			unique = digit1 != digit2 && digit1 != digit3 && digit2 != digit3;
		}
		return unique;
	}

}
