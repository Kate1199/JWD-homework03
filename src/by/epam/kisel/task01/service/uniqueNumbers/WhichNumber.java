package by.epam.kisel.task01.service.uniqueNumbers;

public interface WhichNumber {
	
	/**
	 * checks is this number matches the condition
	 * @param number number which is checked
	 * @return {@code true} if number matches and {@code false} if not
	 */
	public boolean isSuchNumber(int number);

}
