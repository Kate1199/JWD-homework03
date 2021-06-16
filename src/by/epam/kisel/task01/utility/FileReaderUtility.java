package by.epam.kisel.task01.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import by.epam.kisel.task01.collection.IntArray;

public class FileReaderUtility {

	private static final String SPLITER = ",";

	public static IntArray readNumbers(final String fileName) throws IOException {
		IntArray numbers = new IntArray();
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
			
			String readenNumbers;
			while ((readenNumbers = reader.readLine()) != null) {
				String[] splitedNumbers = readenNumbers.split(SPLITER);
				numbers = parseIntArray(splitedNumbers);
			}
		return numbers;
	}

	private static IntArray parseIntArray(String[] splitedNumbers) {
		IntArray numbers = new IntArray();
		for (String s : splitedNumbers) {
			numbers.add(Integer.parseInt(s));
		}
		return numbers;
	}
}
