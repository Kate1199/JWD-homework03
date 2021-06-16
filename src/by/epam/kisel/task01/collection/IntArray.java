package by.epam.kisel.task01.collection;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Класс-оболочка массива целого типа
 * 
 * @author kate kisel
 */
public class IntArray implements Serializable, Iterable<Integer> {// Collection

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

		if (collectionArray.length != 0) {
			array = new int[collection.size()];
			for (int i = 0; i < collectionArray.length; i++) {
				array[i] = (int) collectionArray[i];
			}
		} else {
			array = EMPTY_ARRAY;
		}
	}

	private void expand() {
		array = Arrays.copyOf(array, array.length + 1);
	}

	private int indexOf(int element) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == element) {
				return i;
			}
		}
		return -1;
	}

	public int size() {
		return array.length;
	}

	public boolean isEmpty() {
		return array.equals(EMPTY_ARRAY);
	}

	public boolean contains(Object o) {
		boolean contains = false;
		for (int a : array) {
			contains = areSimilar(a, o, contains);
		}
		return contains;
	}

	private boolean areSimilar(int number, Object o, boolean contains) {
		if (number == (int) o) {
			contains = true;
		}
		return contains;
	}

	public boolean add(int number) {
		expand();
		array[array.length - 1] = number;
		return true;
	}

	public boolean removeByIndex(int index) {
		boolean checkIndex = index >= 0 && index < array.length;
		if (checkIndex) {
			replaceWithNextNumber(index);
			reduce();
		}
		return checkIndex;
	}

	private void reduce() {
		array = Arrays.copyOf(array, array.length - 1);
	}

	private void replaceWithNextNumber(int index) {
		for (int i = index; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}

	}

	public boolean remove(int numberToRemove) {
		int indexOfRemovingNumber = indexOf(numberToRemove);
		return removeByIndex(indexOfRemovingNumber);
	}

	public boolean containsAll(Collection<?> c) {
		boolean[] contains = new boolean[c.size()];
		boolean result = false;
		int count = 0;

		if (!c.contains(null) && c != null) {
			for (Object elementOfCollection : c) {
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

	public boolean addAll(Collection<? extends Integer> c) {
		return (c != null) && fastAdd(c);
	}

	private boolean fastAdd(Collection<? extends Integer> collection) {
		boolean add = true;
		for (int element : collection) {
			add = add && add(element);
		}
		return add;
	}

	public boolean removeAll(Collection<?> c) {
		return (c != null) && fastRemove(c);
	}

	private boolean fastRemove(Collection<?> c) {
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
	
	public int findByIndex(int index) {
		return array[index];
	}
	
	public void place(int index, int number) {
		array[index] = number;
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
				arrayOfStates[i] = (array[i] == other.indexOf(i));
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
