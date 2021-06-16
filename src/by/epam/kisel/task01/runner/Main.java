package by.epam.kisel.task01.runner;

import java.io.IOException;
import java.util.ArrayList;

import by.epam.kisel.task01.collection.IntArray;
import by.epam.kisel.task01.exception.EmptyArrayException;
import by.epam.kisel.task01.exception.NumberNotFoundException;
import by.epam.kisel.task01.service.ServiceIntArray;
import by.epam.kisel.task01.utility.FileReaderUtility;
import by.epam.kisel.task01.utility.InputUtility;
import by.epam.kisel.task01.utility.RandomIntArrayUtility;
import by.epam.kisel.task01.view.IntArrayView;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> al1 = new ArrayList<>();
		al1.add(99);
		al1.add(89);
		al1.add(58);
		al1.add(-105);

		IntArray ia1 = new IntArray();
		ia1.add(2);
		ia1.add(-105);
		ia1.add(55);
		ia1.add(-561);
		ia1.add(89);
		ia1.add(144);
		ia1.add(-9);

		System.out.println(ia1.toString());
		
		try {
			ServiceIntArray.sort(ia1);
			System.out.println(ia1.toString());
		} catch (EmptyArrayException e) {
			e.printStackTrace();
		}
		

		try {
			ServiceIntArray.reverseSort(ia1);
			System.out.println(ia1.toString());
		} catch (EmptyArrayException e) {
			e.printStackTrace();
		}
		

		try {
			ServiceIntArray.reverse(ia1);
			System.out.println(ia1.toString());
		} catch (EmptyArrayException e1) {
			e1.printStackTrace();
		}
		
		int element = 55;
		int receivedElement = 0;
		try {
			receivedElement = ServiceIntArray.findElement(element, ia1);
			System.out.println(receivedElement);
		} catch (EmptyArrayException e) {
			e.printStackTrace();
		} catch (NumberNotFoundException e) {
			e.printStackTrace();
		}
		

		int x;
		try {
			x = ServiceIntArray.findMin(ia1);
			System.out.println(x);
			x = ServiceIntArray.findMax(ia1);
			System.out.println(x);
		} catch (EmptyArrayException e) {
			e.printStackTrace();
		}

		IntArray ia2 = new IntArray();
		try {
			ia2 = ServiceIntArray.findSimpleNumbers(ia1);
			System.out.println(ia2.toString());
		} catch (EmptyArrayException e) {
			e.printStackTrace();
		}

		try {
			ia2 = ServiceIntArray.findFibonacciNumbers(ia1);
			System.out.println(ia2.toString());
		} catch (EmptyArrayException e) {
			e.printStackTrace();
		}

		try {
			ia2 = ServiceIntArray.findUniqueTreeDigitNumbers(ia1);
			System.out.println(ia2.toString());
		} catch (EmptyArrayException e) {
			e.printStackTrace();
		}

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
