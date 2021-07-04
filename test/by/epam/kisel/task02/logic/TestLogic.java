package by.epam.kisel.task02.logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLogic {
	
	private int[] iA1 = { 5, 4, 6 };
	private int[] iA2 = { 2, 1, 45, 3, -6 };
	private int[] iA3 = { 9, 56, 7, 23 };
	private int[] iANull = null;
	private int[][] array = { iA1, iA2, iA3 };
	private int[][] arrayNull = { iA1, iA2, iANull };
	
	@Test
	public void sortSum() {
		int[] expecteds = ArrayLogic.sortSum(array);
		int[] actuals = {15, 45, 95};
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void sortSum_NULL() {
		int[] expecteds = ArrayLogic.sortSum(null);
		int[] actuals = {};
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void sortSum_NULL_ELEMENT() {
		int[] expecteds = ArrayLogic.sortSum(arrayNull);
		int[] actuals = {0, 15, 45};
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void reverseSortSum() {
		int[] expecteds = ArrayLogic.reverseSortSum(array);
		int[] actuals = {95, 45, 15};
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void reverseSortSum_NULL() {
		int[] expecteds = ArrayLogic.reverseSortSum(null);
		int[] actuals = {};
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void reverseSortSum_NULL_ELEMENT() {
		int[] expecteds = ArrayLogic.reverseSortSum(arrayNull);
		int[] actuals = {45, 15, 0};
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void sortMax() {
		int[] expecteds = ArrayLogic.sortMax(array);
		int[] actuals = {6, 45, 56};
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void sortMax_NULL() {
		int[] expecteds = ArrayLogic.sortMax(null);
		int[] actuals = {};
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void sortMax_NULL_ELEMENT() {
		int[] expecteds = ArrayLogic.sortMax(arrayNull);
		int[] actuals = {0, 6, 45};
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void reverseSortMax() {
		int[] expecteds = ArrayLogic.reverseSortMax(array);
		int[] actuals = {56, 45, 6};
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void reverseSortMax_NULL() {
		int[] expecteds = ArrayLogic.reverseSortMax(null);
		int[] actuals = {};
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void reverseSortMax_NULL_ELEMENT() {
		int[] expecteds = ArrayLogic.reverseSortMax(arrayNull);
		int[] actuals = {45, 6, 0};
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void sortMin() {
		int[] expecteds = ArrayLogic.sortMin(array);
		int[] actuals = {-6, 4, 7};
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void sortMin_NULL() {
		int[] expecteds = ArrayLogic.sortMin(null);
		int[] actuals = {};
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void sortMin_NULL_ELEMENT() {
		int[] expecteds = ArrayLogic.sortMin(arrayNull);
		int[] actuals = {-6, 0, 4};
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void reverseSortMin() {
		int[] expecteds = ArrayLogic.reverseSortMin(array);
		int[] actuals = {7, 4, -6};
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void reverseSortMin_NULL() {
		int[] expecteds = ArrayLogic.reverseSortMin(null);
		int[] actuals = {};
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void reverseSortMin_NULL_ELEMENT() {
		int[] expecteds = ArrayLogic.reverseSortMin(arrayNull);
		int[] actuals = {4, 0, -6};
		assertArrayEquals(expecteds, actuals);
	}
	
	
	
}
