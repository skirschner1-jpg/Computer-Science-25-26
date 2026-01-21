// Implements a singly-linked list.

import java.util.NoSuchElementException;

import org.w3c.dom.Node;

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
		if(values== null){
			throw new NullPointerException();
		}
		for (int i = 0; i < values.length; i++) {
			add((E) values[i]);
		}
		nodeCount = values.length;
		// head = new ListNode((E) values[0]);
		// ListNode thisNode = head;
		// for (int i = 1; i < values.length; i++) {
		// 	ListNode next = new ListNode((E) values[i]);
		// 	thisNode.setNext(next);
		// 	thisNode = thisNode.getNext();
		// }

	}
	
	public ListNode<E> getHead() {
		if (isEmpty()) {
			return null;
		}
		return head;
	}
	
	public ListNode<E> getTail() {
		if (isEmpty()) {
			return null;
		}
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
			if (thisNode.getValue() == obj || thisNode.getValue().equals(obj)) {
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
		// if (!contains(obj)) {
		// 	return -1;
		// }
		ListNode<E> thisNode = getHead();
		int index = 0;
		while (thisNode != null) {
			index++;
			if (thisNode.getValue() == obj || thisNode.getValue().equals(obj)) {
				return index -1;
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
			head = addition;
		} else {
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
		if (isEmpty()) {
			return false;
		}
		if (contains(obj) == false) {
			return false;
		}
		if (getHead().getValue() == obj || getHead().getValue().equals(obj)) {
			head = head.getNext();
			nodeCount -= 1;
			if (isEmpty()) {
				tail = null;
			}
			return true;
		}
		ListNode<E> thisNode = getHead();
		int counter = 0;
		// ListNode<E> prevNode = getHead();
		while (thisNode != null) {
			counter++;
			if (thisNode.getNext().getValue() == obj || thisNode.getNext().getValue().equals(obj)) {
				// System.out.println("here (if statement)");
				if (counter == size() - 1) {
					tail = thisNode;
				} //yayyyyayayayayay :)) je suis ecstatique
				thisNode.setNext(thisNode.getNext().getNext());
				nodeCount -= 1;
				if (isEmpty()) {
					tail = null;
				}
				return true;
			}
			thisNode = thisNode.getNext();
			// prevNode = prevNode.getNext();
		}
		return false;
		// ATTEMPT 2
		// if (!contains(obj)) {
		// 	return false;
		// }
		// if (getHead().getValue() == obj || getHead().getValue().equals(obj)) {
		// 	head = head.getNext();
		// 	nodeCount -= 1;
		// 	if (isEmpty()) {
		// 		tail = null;
		// 	}
		// 	return true;
		// }
		// if (getTail().getValue() == obj || getTail().getValue().equals(obj)) {
		// 	remove(size() - 1);
		// 	nodeCount -= 1;
		// 	// if (isEmpty()) {
		// 	// 	tail = null;
		// 	// }
		// 	return true;
		// }
		// ListNode<E> thisNode = getHead();
		// // ListNode<E> prevNode = getHead();
		// while (thisNode != null) {
		// 	if (thisNode.getNext().getValue() == obj) {
		// 		// System.out.println("here (if statement)");
		// 		thisNode.setNext(thisNode.getNext().getNext());
		// 		nodeCount -= 1;
		// 		if (isEmpty()) {
		// 			tail = null;
		// 		}
		// 		return true;
		// 	}
		// 	thisNode = thisNode.getNext();
		// 	// prevNode = prevNode.getNext();
		// }
		// return false;
	}
	// DONE

	// Returns the i-th element.               
	public E get(int i) {
		if (i < 0 || i >= size()) {
			throw new IndexOutOfBoundsException();
		}
		ListNode<E> thisNode = getHead();
		for (int j = 0; j < i; j++) {
			if (thisNode == null || thisNode.equals(null)) {
				throw new NullPointerException();
			}
			thisNode = thisNode.getNext();
		}
		return thisNode.getValue();
	}
	// DONE

	// Replaces the i-th element with obj and returns the old value.
	public E set(int i, Object obj) {
		if (isEmpty() && i == 0) {
			String toReturn = "No previous object";
			ListNode newNode = new ListNode((E) obj);
			head = newNode;
			return (E) toReturn;
		}
		if (i < 0 || i >= size()) {
			throw new IndexOutOfBoundsException();
		}
		if (i == 0) { // DIDN'T CHANGE CODEGRADE
			Object toReturn = get(i);
			ListNode newNode = new ListNode((E) obj);
			newNode.setNext(head.getNext());
			head = newNode;
			return (E) toReturn;
		}
		if (i == size() - 1) {
			// System.out.println("here");
			ListNode newNode = new ListNode((E) obj);
			tail = newNode;
		}
		Object toReturn = get(i);
		ListNode newNode = new ListNode((E) obj);
		newNode.setNext(getNode(i).getNext());
		getNode(i - 1).setNext(newNode);
		return (E) toReturn;
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Object obj) {
		// ATTEMPT 1
		// ListNode<E> addition = new ListNode(obj);
		// SinglyLinkedList preserve = this;
		// // System.out.println("Preserve: " + preserve.get(3));
		if (i < 0 || i > size()) {
			throw new IndexOutOfBoundsException();
		}
		ListNode newNode = new ListNode(obj);

		if (i == 0) {
			newNode.setNext(head);
			head = newNode;
		}
			if (i == size()) { // FIXED TAIL AND DIDN'T CHANGEG TESTER
				add((E) obj);
				nodeCount--; // didn't fix tester!!
			// tail = newNode;
		}
    	else {
            ListNode current = head;
            for (int j = 0; j < i - 1; j++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext()) ;
            current.setNext(newNode);
        }
        nodeCount++;

	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public E remove(int i) {
		if (isEmpty()) {
			return (E) "trying to remove from empty list";
		}
		if (i < 0 || i >= size()) {
			throw new IndexOutOfBoundsException();
		}
		if (i == 0) {
			head = head.getNext();
		}
		if (i == size() - 1) {
			tail = getNode(size() - 2);
		}
		Object toReturn = get(i);
		nodeCount -=1;
		((ListNode<E>) getNode(i - 1)).setNext(((ListNode<E>) getNode(i)).getNext());
		return (E) toReturn;
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {
		// if(isEmpty()){
		// 	System.out.println("[]");
		// }
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
