/* See ArrayList documentation here:
 * http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
 */

/*
 * Your indexed functions should throw IndexOutOfBoundsException if index is invalid!
 */

// import java.util.StringBuilder;

public class MyArrayList<E> {

	/* Internal Object counter */
	protected int objectCount;

	/* Internal Object array */
	protected E [] internalArray;

	/* Constructor: Create it with whatever capacity you want? */
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		this.internalArray = (E[])new Object[100];
	}

	/* Constructor with initial capacity */
	@SuppressWarnings("unchecked")
	public MyArrayList(int initialCapacity){
		this.internalArray = (E[])new Object[initialCapacity];
	}

	/* Return the number of active slots in the array list */
	public int size() {
		return objectCount;
		// DONE
		// O(1)
	}

	public E[] internalArray() {
		return internalArray;
		// DONE
		// O(1)
	}

	/* Are there zero objects in the array list? */
	public boolean isEmpty() {
		if (objectCount == 0) {
			return true;
		}
		return false;
		// DONE
		// O(1)
	}

	/* Get the index-th object in the list. */
	public E get(int index) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("Index Out of Bounds");
		}
		return internalArray[index];
		// DONE
		// O(1)
	}

	/* Replace the object at index with obj.  returns object that was replaced. */
	public E set(int index, E obj) {
		if (index < 0 || index > internalArray().length) {
			throw new IndexOutOfBoundsException("Index Out of Bounds");
		}
		E original = get(index);
		internalArray[index] = obj;
		return original;
		// DONE
		// O(1)
	}

	/* Returns true if this list contains an element equal to obj;
	 otherwise returns false. */
	public boolean contains(E obj) {
		for (int i = 0; i < objectCount; i++) {
			if (get(i) == obj || get(i).equals(obj)) {
				return true;
			}
		}
		return false;
		// DONE
		// O(1)
	}

	/* Insert an object at index */
	@SuppressWarnings("unchecked")
	public void add(int index, E obj) {
		if (index < 0 || index > internalArray().length) {
			throw new IndexOutOfBoundsException("Index Out of Bounds");
		}
		if (obj == null){
			throw new NullPointerException("Trying to Add Null Object");
		}
		adjustSize();
		// Object[] result = new Object[size() + 1];
		Object[] store = new Object[size()];
		for (int i = 0; i < size(); i++) {
			store[i] = internalArray[i];
		}
		set(index, obj);
		for (int i = index; i < size(); i++) {
			// System.out.println("here");
			set(i + 1, (E) store[i]);
		}
		objectCount ++;
		
	}

	/* Add an object to the end of the list; returns true */
	@SuppressWarnings("unchecked")
	public boolean add(E obj) {
		// if (obj == null) {
		// 	throw new NullPointerException("Trying to Add Null Object");
		// }
		adjustSize();
		objectCount ++;
		// Object[] result = new Object[size()];
		// for (int i = 0; i < size(); i++) {
		// 	if (i < size() - 1) {
		// 		result[i] = get(i);
		// 	}
		// 	else{
		// 		result[i] = obj;
		// 	}
		// }
		set(size() - 1, obj);
		return true;
	}

	/* Remove the object at index and shift.  Returns removed object. */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public E remove(int index) {
		if (index < 0 || index > internalArray().length) {
			throw new IndexOutOfBoundsException("Index Out of Bounds");
		}
		MyArrayList<E> store = new MyArrayList(size());
		E removed = get(index);
		for (int i = 0; i < size(); i++) {
			store.add(get(i));
		}
		// System.out.println(store.toString());
		if (index != size() - 1) {
			for (int j = 0; j < size() - 1; j++) {
				// System.out.println("here");
				if (j < index) {
					set(j, (E) store.get(j));
				} else {
					set(j, (E) store.get(j + 1));
				}
			}
		}
		objectCount --;
		return removed;
		// DONE
		// O(n)
	}

	/* Removes the first occurrence of the specified element from this list, 
	 * if it is present. If the list does not contain the element, it is unchanged. 
	 * More formally, removes the element with the lowest index i such that
	 * (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists). 
	 * Returns true if this list contained the specified element (or equivalently, 
	 * if this list changed as a result of the call). */
	public boolean remove(E obj) {
		int index;
		int length = internalArray.length;
		int i = 0;
		while (i < length) {
			if (get(i) == obj || get(i).equals(obj)) {
				index = i;
				remove(index);
				objectCount--;
				return true;
			}
			i++;
			// else if (i == size() - 1) {
			// 	throw new NullPointerException("Object Not in List");
			// }
		}
		return false;
		// is continuing with for loop when it should be done (why???)
	}

	/* For testing; your string should output as "[X, X, X, X, ...]" where X, X, X, X, ... are the elements in the ArrayList.
	 * If the array is empty, it should return "[]".  If there is one element, "[X]", etc.
	 * Elements are separated by a comma and a space. */
	public String toString() {
		String result = new String("[");
		for (int i = 0; i < size(); i++) {
			result = result + get(i);
			if (i != size() - 1) {
				result = result + ", ";
			}
		}
		result = result + "]";
		System.out.println(result);
		return result;
		// O(n)
	}

	// HELPER METHODS
	@SuppressWarnings("unchecked")
	private void adjustSize(){
		if (internalArray.length - size() <= 0) {
			// System.out.println("here #1");
			int ogLength = internalArray().length;
			// System.out.println(ogLength);
			// System.out.println(internalArray().length);
			int newCount = internalArray.length * 2;
			Object[] replacement = new Object[newCount];
			// MyArrayList store = new MyArrayList(newCount);
			// System.out.println(internalArray().length);
			for (int i = 0; i < ogLength; i++) {
				// System.out.println("here #2, i: " + i);
				replacement[i] = internalArray()[i];
			}
			internalArray = (E[]) replacement;
			// System.out.println("Preserve: " + preserve.toString());
			// internalArray = (E[]) store.internalArray();
		}
	}

}