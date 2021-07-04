package by.epam.kisel.task01.service.search;

import by.epam.kisel.task01.collection.IntArray;
/**
 * Interface that defines the searching range
 * @author Kate Kisel
 *
 */

public interface Range {
	/**
	 * moves right or left boarder of search
	 * @param middleIndex index of range middle number
	 * @return index of extreme right or left side
	 */
	public int moveSide(int middleIndex);
	
	/**
	 * finds middle number of the range
	 * @param array array to search for
	 * @param middleIndex index of range middle number
	 * @return value of the range middle number
	 */
	public int findNewMiddle(IntArray array, int middleIndex);

}
