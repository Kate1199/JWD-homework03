package by.epam.kisel.task01.service.search;

import by.epam.kisel.task01.collection.IntArray;

public class LeftRange implements Range {
	
	private int left;
	
	public LeftRange() {

	}
	
	public LeftRange(int left) {
		this.left = left;
	}

	@Override
	public int moveSide(int middleIndex) {
		left = left + middleIndex;
		return left;
	}

	@Override
	public int findNewMiddle(IntArray array, int middleIndex) {
		return array.get(left + middleIndex);
	}
	
}
