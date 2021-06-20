package by.epam.kisel.task01.service.search;

import by.epam.kisel.task01.collection.IntArray;

public interface Range {
	
	public int moveSide(int middleIndex);
	public int findNewMiddle(IntArray copy, int middleIndex);

}
