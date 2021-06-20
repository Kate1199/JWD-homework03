package by.epam.kisel.task01.service.uniqueNumbers;

/**
 * Class that checks is this number fibonacci
 * @author Kate Kisel
 *
 */
public class FibonacciNumbers implements WhichNumber {

	@Override
	public boolean isSuchNumber(int number) {
		int f1 = 1;
		int f2 = 1;
		int f = f1 + f2;
		while (f < number) {
			f1 = f2;
			f2 = f;
			f = f1 + f2;
		}
		return (number == f) || (number == 1);
	}
}
