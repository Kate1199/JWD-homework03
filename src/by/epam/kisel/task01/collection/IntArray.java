package by.epam.kisel.task01.collection;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import by.epam.kisel.task01.exception.NumberNotFoundException;

/**
 * Класс-оболочка массива целого типа
 * 
 * @author kate kisel
 */
public class IntArray implements Serializable, Iterable<Integer> {

	private static final long serialVersionUID = 1L;
	private final static int[] EMPTY_ARRAY = {};
	private int[] array;

	public IntArray() {
		array = EMPTY_ARRAY;
	}

	public IntArray(int[] inputArray) {
		if (inputArray.length != 0) {
			array = inputArray;
		} else {
			array = EMPTY_ARRAY;
		}
	}

	public IntArray(Collection<Integer> collection) {

		Object[] collectionArray = collection.toArray();
		array = new int[collectionArray.length];
		if (!isEmpty()) {
			copyCollectionToArray(collectionArray);
		} 
	}
	
	private void copyCollectionToArray(Object[] collectionArray) {
		for (int i = 0; i < collectionArray.length; i++) {
			array[i] = (int) collectionArray[i];
		}
	}

	private void expand() {
		array = Arrays.copyOf(array, array.length + 1);
	}
	
	public int size() {
		return array.length;
	}

	public boolean isEmpty() {
		return array.equals(EMPTY_ARRAY);
	}

	public boolean contains(int number) {
		boolean contains = false;
		for (int a : array) {
			contains = areSimilar(a, number);
			if(contains) {
				break;
			}
		}
		return contains;
	}

	private boolean areSimilar(int number, int elementOfArray) {
		boolean contains = false;
		if (number == elementOfArray) {
			contains = true;
		}
		return contains;
	}

	public boolean add(int number) {
		expand();
		array[array.length - 1] = number;
		return true;
	}

	public boolean remove(int numberToRemove) {
		int indexOfRemovingNumber = indexOf(numberToRemove);
		return removeByIndex(indexOfRemovingNumber);
	}
	
	private int indexOf(int element) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == element) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean removeByIndex(int index) {
		boolean indexExists = index >= 0 && index < array.length;
		if (indexExists) {
			replaceWithNextNumber(index);
			reduce();
		}
		return indexExists;
	}
	
	private void replaceWithNextNumber(int index) {
		for (int i = index; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
	}

	private void reduce() {
		array = Arrays.copyOf(array, array.length - 1);
	}


	public boolean containsAll(Collection<Integer> c) {
		boolean[] contains = {};
		boolean result = false;
		int count = 0;

		if (c != null && !c.contains(null)) {
			contains = new boolean[c.size()];
			for (int elementOfCollection : c) {
				if (contains(elementOfCollection)) {
					contains[count++] = true;
					result = true;
				}
			}
		}
		return findOutState(contains, result);
	}

	private boolean findOutState(boolean[] arrayOfStates, boolean controlState) {
		for (boolean state : arrayOfStates) {
			controlState = controlState && state;
		}
		return controlState;
	}

	public boolean addAll(Collection<Integer> c) {
		return (c != null) && fastAdd(c);
	}

	private boolean fastAdd(Collection<Integer> collection) {
		boolean add = true;
		for (int element : collection) {
			add = add && add(element);
		}
		return add;
	}

	public boolean removeAll(Collection<Integer> c) {
		return (c != null) && fastRemove(c);
	}

	private boolean fastRemove(Collection<Integer> c) {
		boolean remove = false;
		
		for (int i = 0; i < array.length; i++) {
			if (c.contains(array[i])) {
				remove = true;
				removeByIndex(i);
				i = 0;
				continue;
			}
		}
		return remove;
	}

	public void clear() {
		array = EMPTY_ARRAY;
	}
	
	public int[] toArray() {
		return Arrays.copyOf(array, array.length);
	}
	
	public int get(int index) {
		return array[index];
	}
	
	public boolean set(int index, int value) {
		boolean set;
		if(index < 0 || index >= array.length) {
			set = false;
		} else {
			array[index] = value;
			set = true;
		}
		return set;
	}
	
	public IntArray copy() {
		IntArray copy = new IntArray();
		for(int a : array) {
			copy.add(a);
		}
		return copy;
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(array);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;
		IntArray other = (IntArray) o;

		return isTheSameWith(other);
	}
	
	private boolean isTheSameWith(IntArray other) {
		boolean[] arrayOfStates = new boolean[array.length];
		if(other.size() == array.length) {
			for(int i = 0; i < array.length; i++) {
				arrayOfStates[i] = (array[i] == other.toArray()[i]);
			}
		}
		return findOutState(arrayOfStates, true);
	}

	@Override
	public String toString() {
		String arrayString = "[";
		for (int i = 0; i < array.length; i++) {
			arrayString = arrayString + " " + array[i];
		}
		arrayString = arrayString + "]";
		return arrayString;
	}

	@Override
	public Iterator<Integer> iterator() {
		Iterator<Integer> it = new Iterator<Integer>() {

			private int currentIndex = 0;

			@Override
			public boolean hasNext() {
				return currentIndex < array.length;
			}

			@Override
			public Integer next() {
				return array[currentIndex++];
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
		return it;
	}

}
