package datastructures;

import exceptions.InvalidSizeException;
import exceptions.MaximumCapacityException;

public class ArrayList<E extends Comparable<E>> {
	private final static int DEFCAP = 50;
	private int origCap;
	private int numElements;
	private Object[] list;

	/*
	 * Method Name : ArrayList Parameters : None Return value(s) : None Partners
	 * : None Description : constructor which initializes the Arraylist object.
	 */
	public ArrayList() {
		origCap = DEFCAP;
		list = new Object[this.origCap];
		numElements = 0;
	}

	/*
	 * Method Name : ArrayList Parameters : size, an int Return value(s) : None
	 * Partners : None Description : constructor which initializes the arraylist
	 * object and sets the attributes to the values passed.
	 */
	public ArrayList(int size) throws InvalidSizeException {

		if (!(size < DEFCAP && size > 1)) {
			throw new IllegalArgumentException("Illegal Capacity: " + origCap);
		}
		list = new Object[size];
	}

	/*
	 * Method Name : addItem Parameters : ArralyLIst Item Return value(s) : None
	 * Partners : None Description : Method adds item to the ArrayList.
	 */
	public void addItem(E item) throws MaximumCapacityException {
		if (numElements == list.length) {
			if (list.length > DEFCAP) {
				throw new MaximumCapacityException("Arraylist is full. Item cannot be inserted");
			} else {
				enlarge();
			}
		}
		list[numElements] = item;
		numElements++;
	}

	/*
	 * Method Name : removeItem Parameters : ArralyLIst Item Return value(s) :
	 * None Partners : None Description : Method to remove item from the
	 * ArrayList.
	 */
	@SuppressWarnings("unchecked")
	public E removeItem(int index) throws IndexOutOfBoundsException {

		if (list.length >= DEFCAP) {
			throw new IndexOutOfBoundsException("Index out of Range");
		} else {
			E temp = null;
			list[index] = list[numElements - 1];
			temp = (E) list[index];
			numElements--;
			return temp;
		}

	}

	public int findItem(E item) {
		for (int i = 0; i < numElements; i++) {
			if (list[i] == item) {
				return i;
			}
		}
		return -1;
	}

	/*
	 * Method Name : isEmpty Parameters : None Return value(s) : boolean
	 * Partners : None Description : Method to check if the arraylist is empty.
	 */
	public boolean isEmpty() {
		return numElements == 0 ? true : false;
	}

	/*
	 * Method Name : lengthIs Parameters : None Return value(s) : numelements,
	 * an int Partners : None Description : Method to return number of elements.
	 */
	public int lengthIs() {
		return numElements;
	}

	/*
	 * Method Name : clear Parameters : None Return value(s) : None Partners :
	 * None Description : Method to clear elements in the arraylist.
	 */
	@SuppressWarnings("unchecked")
	public void clear() {
		numElements = 0;
		list = (E[]) new Object[this.origCap];
	}

	/*
	 * Method Name : toString Parameters : None Return value(s) : Formatted
	 * String, a string Partners : None Description : Method to format the input
	 * values into required format
	 */
	public String toString() {

		String tempStr = "";
		if (isEmpty()) {
			tempStr = "\t*** No Items ***";
		} else {
			for (int i = 0; i < numElements; i++) {
				tempStr += list[i] + "\n";
			}
		}
		return tempStr;
	}

	@SuppressWarnings("unchecked")
	public E getItem(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= numElements) {
			throw new IndexOutOfBoundsException("Index is out of range");
		} else {
			return (E) list[index];
		}
	}

	public void setItem(int index, E item) throws IndexOutOfBoundsException {

		if (index > DEFCAP || index < 0) {
			throw new IndexOutOfBoundsException("Index is out of range");
		} else {
			list[index] = item;
		}
	}

	/*
	 * Method Name : equals Parameters : Arraylist, a object Return value(s) :
	 * boolean Partners : None Description : Method to compare passed my
	 * arraylist object with current object and gives true or false
	 */
	public boolean equals(ArrayList<E> otherList) {
		boolean areEqual = true;
		if (otherList == null)
			areEqual = false;
		else if (otherList == this)
			areEqual = true;
		else if (list.length != otherList.list.length)
			areEqual = false;
		else {
			// compare all items in the lists for equality
			int x = 0;
			while (x < list.length && areEqual) {
				if (!list[x].equals(otherList.list[x]))
					areEqual = false;
				x++;
			}
		}
		return areEqual;
	}

	/*
	 * Method Name : enlarge Parameters : None Return value(s) : None Partners :
	 * None Description : Method to enlarge the ArrayList by the value of
	 * origCap
	 */
	private void enlarge() throws MaximumCapacityException {

		int i = 0;
		i = origCap + list.length;
		if (i >= DEFCAP) {
			throw new MaximumCapacityException("The item cannot be added");
		} else {
			Object[] larger = new Object[origCap + list.length];// Array.newInstance(elementType,
																// origCap +
																// list.length);
			System.arraycopy(list, 0, larger, 0, list.length);

			list = larger;
			System.out.println(list.length);
		}
	}

	public void sort() {
		this.sort();
	}

	public static void main(String args[]) throws MaximumCapacityException {
		try {
			ArrayList<String> arr = new ArrayList<String>(3);
			arr.addItem("abc");
			arr.addItem("def");
			arr.addItem("ghi");
			System.out.println(arr.toString());
		} catch (InvalidSizeException e) {
			e.printStackTrace();
		}
	}

}
