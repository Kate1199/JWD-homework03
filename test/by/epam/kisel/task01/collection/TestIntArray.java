package by.epam.kisel.task01.collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import by.epam.kisel.task01.exception.NumberNotFoundException;

public class TestIntArray {

	private int[] inputArray = { 1, 2, 6, 9, 125, -56 };
	private IntArray emptyArray;
	private IntArray intArrayFromArray;
	private ArrayList<Integer> collection;

	@Before
	public void setUp() throws Exception {
		emptyArray = new IntArray();
		intArrayFromArray = new IntArray(inputArray);
		collection = new ArrayList<>();
		collection.add(1);
		collection.add(2);
		collection.add(-56);
	}

	@Test
	public void size() {
		int expected = intArrayFromArray.size();
		int actual = 6;
		assertEquals(expected, actual);
	}

	@Test
	public void size_EMPTY_ARRAY() {
		int expected = emptyArray.size();
		int actual = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void isEmpty() {
		boolean condition = emptyArray.isEmpty();
		assertTrue(condition);
	}

	@Test
	public void contains() {
		boolean condition = intArrayFromArray.contains(9);
		assertTrue(condition);
	}
	
	@Test
	public void contains_EMPTY() {
		boolean expected = emptyArray.contains(1);
		boolean actual = false;
		assertEquals(expected, actual);
	}

	@Test
	public void add() {
		boolean condition = intArrayFromArray.add(12);
		assertTrue(condition);
	}
	
	@Test
	public void remove() {
		boolean condition = intArrayFromArray.remove(1);
		assertTrue(condition);
	}
	
	@Test
	public void remove_EMPTY() {
		boolean expected = emptyArray.remove(1);
		boolean actual = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void removeByIndex() {
		boolean condition = intArrayFromArray.removeByIndex(0);
		assertTrue(condition);
	}
	
	@Test
	public void removeByIndex_EMPTY() {
		boolean expected = emptyArray.removeByIndex(0);
		boolean actual = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void containsAll() {	
		boolean condition = intArrayFromArray.containsAll(collection);
		assertTrue(condition);
	}
	
	@Test
	public void containsAll_NULL() {
		boolean expected = intArrayFromArray.containsAll(null);
		boolean actual = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void containsAll_EMPTY() {
		boolean expected = emptyArray.containsAll(collection);
		boolean actual = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void containsAll_NULL_EEMENT() {
		collection.add(null);
		boolean expected = emptyArray.containsAll(collection);
		boolean actual = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void addAll() {
		boolean condition = intArrayFromArray.addAll(collection);
		assertTrue(condition);
	}
	
	@Test
	public void addAll_NULL() {
		boolean expected = intArrayFromArray.addAll(null);
		boolean actual = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void removeAll() {
		boolean condition = intArrayFromArray.removeAll(collection);
		assertTrue(condition);
	}
	
	@Test
	public void removeAll_NULL() {
		boolean expected = intArrayFromArray.removeAll(null);
		boolean actual = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void removeAll_EMPTY_INTARRAY() {
		boolean expected = emptyArray.removeAll(collection);
		boolean actual = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void removeAll_NULL_ELEMENT() {
		collection.add(null);
		boolean condition = intArrayFromArray.removeAll(collection);
		assertTrue(condition);
	}
	
	@Test
	public void clear() {
		intArrayFromArray.clear();
		IntArray expected = intArrayFromArray;
		IntArray actual = emptyArray;
		assertEquals(expected, actual);
	}
	
	@Test
	public void get() throws NumberNotFoundException {
		int expected = intArrayFromArray.get(1);
		int actual = 2;
		assertEquals(expected, actual);
	}
	
	@Ignore
	public void get_EMPTY() {
		Integer object = emptyArray.get(3);
		assertNull(object);
	}
	
	@Test
	public void set() throws NumberNotFoundException {
		boolean condition = intArrayFromArray.set(1, -63);
		assertTrue(condition);
	}
	
	@Test
	public void set_INDEX_LESS_THAN_ZERO() {
		boolean expected = intArrayFromArray.set(-1, 3);
		boolean actual = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void set_INDEX_MORE_THAN_SIZE() {
		boolean expected = intArrayFromArray.set(12, 5);
		boolean actual = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void copy() {
		IntArray expected = intArrayFromArray.copy();
		IntArray actual = intArrayFromArray;
		assertEquals(expected, actual);
	}
}
