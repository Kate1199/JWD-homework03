package by.epam.kisel.task01.service.search;

import by.epam.kisel.task01.collection.IntArray;

public class RightRange implements Range {
	
	private int right;
	public RightRange() {
		
	}
	
	public RightRange(int right) {
		this.right = right;
	}

	@Override
	public int moveSide(int middleIndex) {
		right = right - middleIndex;
		return right;
	}

	@Override
	public int findNewMiddle(IntArray copy, int middleIndex) {
		return copy.get(right - middleIndex);
	}
	
	
}
