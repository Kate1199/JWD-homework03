package by.epam.kisel.task01.runner;

import java.io.IOException;
import by.epam.kisel.task01.collection.IntArray;
import by.epam.kisel.task01.exception.EmptyArrayException;
import by.epam.kisel.task01.service.SortArray;
import by.epam.kisel.task01.service.minMaxNumber.MinMaxSearch;
import by.epam.kisel.task01.service.search.NumberSearch;
import by.epam.kisel.task01.service.uniqueNumbers.UniqueNumbers;
import by.epam.kisel.task01.utility.FileReaderUtility;
import by.epam.kisel.task01.utility.InputUtility;
import by.epam.kisel.task01.utility.RandomIntArrayUtility;

public class Main {

	public static void main(String[] args) {
		
		IntArray ia0 = new IntArray();
		int a = ia0.get(1);

		IntArray ia1 = new IntArray();
		ia1.add(2);
		ia1.add(-105);
		ia1.add(55);
		ia1.add(-561);
		ia1.add(89);
		ia1.add(144);
		ia1.add(-9);

		System.out.println(ia1.toString());

		SortArray.bubbleSort(ia1);
		System.out.println(ia1.toString());
		
		int element = 55;
		System.out.println(NumberSearch.findItemBinarySearch(element, ia1));

		SortArray.reverseBubbleSort(ia1);
		System.out.println(ia1.toString());

		SortArray.reverse(ia1);
		System.out.println(ia1.toString());

		int x;
		try {
			x = MinMaxSearch.findMin(ia1);
			System.out.println(x);
			x = MinMaxSearch.findMax(ia1);
			System.out.println(x);
		} catch (EmptyArrayException e) {
			e.printStackTrace();
		}

		IntArray ia2 = new IntArray();
		ia2 = UniqueNumbers.findSimpleNumbers(ia1);
		System.out.println(ia2.toString());

		ia2 = UniqueNumbers.findFibonacciNumbers(ia1);
		System.out.println(ia2.toString());

		ia2 = UniqueNumbers.findUniqueTreeDigitNumbers(ia1);
		System.out.println(ia2.toString());


		IntArray ia3 = InputUtility.inputArray("Input numbers");
		System.out.println(ia3.toString());

		try {
		IntArray ia4 = FileReaderUtility.readNumbers("Numbers.TXT");
		System.out.println(ia4.toString());
		} catch(IOException e) {
			e.printStackTrace();
		} 

		IntArray ia5 = RandomIntArrayUtility.createRandomIntArray(5);
		System.out.println(ia5.toString());

	}

}
