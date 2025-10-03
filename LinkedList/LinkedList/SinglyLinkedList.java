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
		// head = new ListNode((E) values[0]);
		// ListNode thisNode = head;
		// for (int i = 1; i < values.length; i++) {
		// 	ListNode next = new ListNode((E) values[i]);
		// 	thisNode.setNext(next);
		// 	thisNode = thisNode.getNext();
		// }

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
			// System.out.print("here: is empty; adding ");
			System.out.println(addition.getValue());
			set(0, obj);
			head = addition;
		} else {
			// System.out.print("here: adding ");
			// System.out.println(addition.getValue());
			tail.setNext(addition);
		}
		tail = addition;
		nodeCount +=1;
		return true;
	}
	// NOT DONE
	// adding null in else block :(

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(E obj) {
		if (getHead().getValue() == obj || getHead().getValue().equals(obj)) {
			head = head.getNext();
			nodeCount -= 1;
			return true;
		}
		ListNode<E> thisNode = getHead();
		// ListNode<E> prevNode = getHead();
		while (thisNode != null) {
			if (thisNode.getNext().getValue() == obj) {
				// System.out.println("here (if statement)");
				thisNode.setNext(thisNode.getNext().getNext());
				nodeCount -=1;
				return true;
			}
			thisNode = thisNode.getNext();
			// prevNode = prevNode.getNext();
		}
		return false;
	}
	// DONE

	// Returns the i-th element.               
	public E get(int i) {
		if (i < 0 || i >= size()) {
			throw new IndexOutOfBoundsException();
		}
		ListNode<E> thisNode = getHead();
		for (int j = 0; j < i; j++) {
			if (thisNode == null) {
				throw new NullPointerException();
			}
			thisNode = thisNode.getNext();
		}
		return thisNode.getValue();
	}
	// NOT DONE

	// Replaces the i-th element with obj and returns the old value.
	public E set(int i, Object obj) {
		if (isEmpty()) {
			String toReturn = "No previous object";
			ListNode newNode = new ListNode((E) obj);
			head = newNode;
			return (E) toReturn;
		}
		Object toReturn = get(i);
		ListNode newNode = new ListNode((E) obj);
		((ListNode<E>) get(i - 1)).setNext(newNode);
		return (E) toReturn;
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Object obj) {
		ListNode<E> addition = new ListNode(obj);
		SinglyLinkedList preserve = this;
		// System.out.println(this.toString());
		nodeCount +=1;
		if (i < 0 || i > size()) {
			throw new IndexOutOfBoundsException();
		}
		if (i == 0) {
			//FILL IN
		}
		// for (int j = i; j < size(); j++) {
		// 	System.out.println("here");
		// 	getNode(i).setNext(getNode(i+1).getNext());
		// }
		getNode(i - 1).setNext(addition);
		for (int j = i; j < size(); j++) {
			System.out.println("here");
			getNode(j-1).setNext(preserve.getNode(j));
		}
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public E remove(int i) {
		if (i < 0 || i >= size()) {
			throw new IndexOutOfBoundsException();
		}
		Object toReturn = get(i);
		nodeCount -=1;
		((ListNode<E>) getNode(i - 1)).setNext(((ListNode<E>) getNode(i)).getNext());
		return (E) toReturn;
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {
		ListNode<E> thisNode = getHead();
		String theToString = "[";
		while (thisNode != null) {
			theToString = theToString + thisNode.getValue();
			thisNode = thisNode.getNext();
			if (thisNode != null) {
				theToString = theToString + ", ";
			}
		}
		return theToString + "]";
	}
	
	// HELPER METHODS
	public ListNode getNode(int i) {
		ListNode<E> thisNode = getHead();
		for (int j = 0; j < i; j++) {
			// if (thisNode == null) {
			// 	throw new NullPointerException();
			// }
			thisNode = thisNode.getNext();
		}
		return thisNode;
	}

}
