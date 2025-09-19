// Implements a singly-linked list.


public class SinglyLinkedList<E> {
	private ListNode<E> head;
	private ListNode<E> tail;
	private int nodeCount;

	// Constructor: creates an empty list
	public SinglyLinkedList() {
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	public SinglyLinkedList(Object[] values) {
	}
	
	public ListNode<E> getHead() {
		return head;
	}
	
	public ListNode<E> getTail() {
		return tail;
	}

	// Returns true if this list is empty; otherwise returns false.
	public boolean isEmpty() {
		if (nodeCount == 0) {
			return true;
		}
		return false;
	}

	// Returns the number of elements in this list.
	public int size() {
		return nodeCount;
	}

	// Returns true if this list contains an element equal to obj;
	// otherwise returns false.
	public boolean contains(E obj) {
		ListNode<E> thisNode = getHead();
		while (thisNode != null) {
			if (thisNode == obj) {
				return true;
			}
			thisNode = thisNode.getNext();
		}
		return false;
	}
	// DONE

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(E obj) {
		ListNode<E> thisNode = getHead();
		int index = 0;
		while (thisNode != null) {
			index++;
			if (thisNode == obj) {
				return index;
			}
			thisNode = thisNode.getNext();
		}
		return -1;
	}
	// DONE

	// Adds obj to this collection.  Returns true if successful;
	// otherwise returns false.
	public boolean add(E obj) {
		ListNode<E> addition = new ListNode(obj);
		if (isEmpty()) {
			set(0, obj);
		}
		getTail().setNext(addition);
		tail = addition;
		return true;
	}
	// DONE

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(E obj) {
		if (getHead().getValue() == obj || getHead().getValue().equals(obj)) {
			remove(0);
		}
		ListNode<E> thisNode = getHead().getNext();
		ListNode<E> prevNode = getHead();
		while (thisNode != null) {
			if (thisNode == obj) {
				prevNode.setNext(thisNode.getNext());
				return true;
			}
			thisNode = thisNode.getNext();
			prevNode = prevNode.getNext();
		}
		return false;
	}
	// DONE

	// Returns the i-th element.               
	public E get(int i) {
		ListNode<E> thisNode = getHead();
		for (int j = 0; j < i; j++) {
			if (thisNode == null) {
				throw new IndexOutOfBoundsException();
			}
			thisNode = thisNode.getNext();
		}
		return thisNode.getValue();
	}
	// DONE

	// Replaces the i-th element with obj and returns the old value.
	public E set(int i, Object obj) {
		
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Object obj) {
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public E remove(int i) {
		
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {
		ListNode<E> thisNode = getHead();
		String theToString = "";
		while (thisNode != null) {
			theToString = theToString + thisNode.getValue();
			thisNode = thisNode.getNext();
			if (thisNode != null) {
				theToString = theToString + ", ";
			}
		}
		return theToString;
	}
	

}
