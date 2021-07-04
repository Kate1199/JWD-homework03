package by.epam.kisel.task01.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import by.epam.kisel.task01.collection.IntArray;
import by.epam.kisel.task01.exception.EmptyArrayException;
import by.epam.kisel.task01.service.minMaxNumber.MinMaxSearch;
import by.epam.kisel.task01.service.search.NumberSearch;
import by.epam.kisel.task01.service.uniqueNumbers.UniqueNumbers;

public class TestService {
	int[] inputArray = { 1, 2, 8, -89, 87, -13, 458, -963, 554};
	private IntArray testIntArray;
	private IntArray emptyArray;

	@Before
	public void setUp() {
		testIntArray = new IntArray(inputArray);
		emptyArray = new IntArray();
	}

	@Test
	public void bubleSort() {
		SortArray.bubbleSort(testIntArray);
		IntArray expected = testIntArray;
		int[] a = {-963, -89, -13, 1, 2, 8, 87, 458, 554};
		IntArray actual = new IntArray(a);
		assertEquals(expected, actual);
	}

	@Test
	public void bubbleSort_NULL() {
		boolean expected = SortArray.bubbleSort(null);
		boolean actual = false;
		assertEquals(expected, actual);
	}

	@Test
	public void reverseBubbleSort() {
		SortArray.reverseBubbleSort(testIntArray);
		IntArray expected = testIntArray;
		int[] a = { 554, 458, 87, 8, 2, 1, -13, -89, -963 };
		IntArray actual = new IntArray(a);
		assertEquals(expected, actual);
	}

	@Test
	public void reverseBubbleSort_NULL() {
		boolean expected = SortArray.reverseBubbleSort(null);
		boolean actual = false;
		assertEquals(expected, actual);
	}

	@Test
	public void reverse() {
		SortArray.reverse(testIntArray);
		IntArray expected = testIntArray;
		int[] a = { 554, -963, 458, -13, 87, -89, 8, 2, 1 };
		IntArray actual = new IntArray(a);
		assertEquals(expected, actual);
	}

	@Test
	public void reverse_NULL() {
		boolean expected = SortArray.reverseBubbleSort(null);
		boolean actual = false;
		assertEquals(expected, actual);
	}

	@Test
	public void findMin() throws EmptyArrayException {
		int expected = MinMaxSearch.findMin(testIntArray);
		int actual = -963;
		assertEquals(expected, actual);
	}
	
	@Test(expected = EmptyArrayException.class)
	public void findMin_EMPTY() throws EmptyArrayException {
		MinMaxSearch.findMin(emptyArray);
	}
	
	@Test(expected = EmptyArrayException.class)
	public void findMin_NULL() throws EmptyArrayException {
		MinMaxSearch.findMin(null);
	}
	
	@Test
	public void findMax() throws EmptyArrayException {
		int expected = MinMaxSearch.findMax(testIntArray);
		int actual = 554;
		assertEquals(expected, actual);
	}
	
	@Test (expected = EmptyArrayException.class)
	public void findMax_EMPTY() throws EmptyArrayException {
		MinMaxSearch.findMax(emptyArray);
	}
	
	@Test (expected = EmptyArrayException.class)
	public void findMax_NULL() throws EmptyArrayException {
		MinMaxSearch.findMax(null);
	}
	
	@Test
	public void findItemBinarySearch() {
		boolean condition = NumberSearch.findItemBinarySearch(87, testIntArray);
		assertTrue(condition);
	}
	
	@Test
	public void findItemBinarySearch_NULL() {
		boolean expected = NumberSearch.findItemBinarySearch(87, null);
		boolean actual = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void findItemBinarySearch_EMPTY() {
		boolean expected = NumberSearch.findItemBinarySearch(87, emptyArray);
		boolean actual = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void findSimpleNumbers() {
		IntArray expected = UniqueNumbers.findSimpleNumbers(testIntArray);
		IntArray actual = new IntArray();
		actual.add(2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void findSimpleNumbers_NULL() {
		IntArray expected = UniqueNumbers.findSimpleNumbers(null);
		IntArray actual = new IntArray();
		assertEquals(expected, actual);
	}
	
	@Test
	public void findSimpleNumbers_ENPTY() {
		IntArray expected = UniqueNumbers.findSimpleNumbers(emptyArray);
		IntArray actual = new IntArray();
		assertEquals(expected, actual);
	}
	
	@Test
	public void findFibonacciNumbers() {
		IntArray expected = UniqueNumbers.findFibonacciNumbers(testIntArray);
		int[] a = {1, 2, 8}; 
		IntArray actual = new IntArray(a);
		assertEquals(expected, actual);
	}
	
	@Test
	public void findFibonacciNumber_NULL() {
		IntArray expected = UniqueNumbers.findFibonacciNumbers(null);
		IntArray actual = new IntArray();
		assertEquals(expected, actual);
	}
	
	@Test
	public void findFibonacciNumber_EMPTY() {
		IntArray expected = UniqueNumbers.findFibonacciNumbers(emptyArray);
		IntArray actual = new IntArray();
		assertEquals(expected, actual);
	}
	
	@Test
	public void findUnoqueThreeDigitNumber() {
		IntArray expected = UniqueNumbers.findUniqueTreeDigitNumbers(testIntArray);
		int[] a = {458, -963};
		IntArray actual = new IntArray(a);
		assertEquals(expected, actual);
	}
	
	@Test
	public void findUnoqueThreeDigitNumber_NULL() {
		IntArray expected = UniqueNumbers.findUniqueTreeDigitNumbers(null);
		IntArray actual = new IntArray();
		assertEquals(expected, actual);
	}
	
	@Test
	public void findUnoqueThreeDigitNumber_EMPTY() {
		IntArray expected = UniqueNumbers.findUniqueTreeDigitNumbers(emptyArray);
		IntArray actual = new IntArray();
		assertEquals(expected, actual);
	}
}
