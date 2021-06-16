package by.epam.kisel.task01.utility;

import by.epam.kisel.task01.collection.IntArray;

public class RandomIntArrayUtility {
	
	private static final int MAX_POWER_OF_TEN = 5;
	private static final int MIN_POWER_OF_TEN = 0;
	

	public static IntArray createRandomIntArray(int size) {
		IntArray array = new IntArray();
		for (int i = 1; i <= size; i++) {
			array.add((int) (Math.random() * createRandomPowerOfTen()));
		}
		return array;
	}
	
	private static int createRandomPowerOfTen() {
		int power = (int) ((Math.random() * (MAX_POWER_OF_TEN - MIN_POWER_OF_TEN) + 1) + MIN_POWER_OF_TEN);
		return (int) Math.pow(10, power);
	}
}
