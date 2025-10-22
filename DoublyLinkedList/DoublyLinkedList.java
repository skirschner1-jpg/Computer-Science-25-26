import java.rmi.server.ServerNotActiveException;

public class DoublyLinkedList {
	// Implements a circular doubly-linked list.

	private final ListNode2<Nucleotide> SENTINEL = new ListNode2<Nucleotide>(null);
	private int nodeCount;

	// Constructor: creates an empty list
	public DoublyLinkedList() {
		nodeCount = 0;
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	public DoublyLinkedList(Nucleotide[] values) {
		if (values == null) {
			throw new NullPointerException();
		}
		if (values.length > 0) {
			ListNode2 thisNode = new ListNode2(values[0]);
			SENTINEL.setNext(thisNode);
			SENTINEL.setPrevious(thisNode);
			thisNode.setNext(SENTINEL);
			thisNode.setPrevious(SENTINEL);
			nodeCount = 1;
			for (int i = 1; i < values.length; i++) {
				ListNode2 addition = new ListNode2(values[i]);
				addition.setPrevious(getTail());
				getTail().setNext(addition);
				SENTINEL.setPrevious(addition);
				addition.setNext(SENTINEL);
				// if (i == values.length - 1) {
				// 	addition.setPrevious(SENTINEL);
				// }
				nodeCount++;
			}
			// ListNode2 head = new ListNode2(values[0]);
			// // SENTINEL.setNext(head);
			// add(values[0]);
			// // ListNode2 thisNode = new ListNode2(head);
			// for (int i = 1; i < values.length; i++) {
			// 	ListNode2 addition = new ListNode2(values[i]);
			// 	this.add(values[i]);
			// 	nodeCount++;
			// }
		}
	}
	
	public ListNode2<Nucleotide> getSentinel() {
		return SENTINEL;
	}
	
	public ListNode2<Nucleotide> getHead() {
		return SENTINEL.getNext();
	}
	
	public ListNode2<Nucleotide> getTail() {
		return SENTINEL.getPrevious();
	}


	// Returns true if this list is empty; otherwise returns false.
	public boolean isEmpty() {
		return nodeCount == 0;
	}

	// Returns the number of elements in this list.
	public int size() {
		if (isEmpty()) {
			return 0;
		}
		ListNode2 thisNode = SENTINEL;
		int count = 0;
		while (thisNode.getNext().getValue() != null) {
			// get stuck HERE!!!! (in our add trap)
			// System.out.println("in loop");
			count++;
			thisNode = thisNode.getNext();
		}
		return count;
	}

	// Returns true if this list contains an element equal to obj;
	// otherwise returns false.
	public boolean contains(Nucleotide obj) {
		ListNode2 thisNode = SENTINEL;
		while (thisNode!= null && thisNode.getNext() != SENTINEL) {
			if (thisNode.getValue().equals(obj)) {
				return true;
			}
			thisNode = thisNode.getNext();
		}
		return false;
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(Nucleotide obj) {
		ListNode2 thisNode = SENTINEL;
		int index = 0;
		while (thisNode.getNext() != SENTINEL) {
			if (thisNode.getValue().equals(obj)) {
				return index;
			}
			thisNode = thisNode.getNext();
		}
		return -1;
	}

	// Adds obj to this collection.  Returns true if successful;
	// otherwise returns false.
	public boolean add(Nucleotide obj) {
		ListNode2 addition = new ListNode2(obj);
		if (size() == 0) { // STICKING POINT FOR WHEN SIZE != 0 (bc getting stuck in size becuase next is never equaling null)
			// System.out.println("here");
			addition.setPrevious(SENTINEL);
			SENTINEL.setNext(addition);
			SENTINEL.setPrevious(addition);
			addition.setNext(SENTINEL);
		} else {
			// addition.setPrevious(getTail());
			// getTail().setNext(addition);
			// SENTINEL.setPrevious(addition);
			addition.setPrevious(getTail());
			getTail().setNext(addition);
			// addition.setNext(SENTINEL); // ADDING THIS LEADS TO INFINITE LOOP???? or something??? // goes to set thrice and then just stops as far as i can tell
			SENTINEL.setPrevious(addition);
			addition.setNext(SENTINEL);
			// nodeCount++;
		}
		nodeCount++;
		// SENTINEL.setPrevious(addition);
		// if (size() != 1) {
		// 	getNode(size() - 1).setNext(addition);
		// }
		return true;
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(Nucleotide obj) {
		if (size() == 0) {
			return false;
		}
		if (obj == null) {
			throw new NullPointerException();
		}
		ListNode2<Nucleotide> thisNode = getHead();
		int indexCounter = 0;
		while (thisNode != null && !thisNode.getValue().equals(obj)) {
			thisNode = thisNode.getNext();
			indexCounter++;
		}
		if (thisNode == null) {
			return false;
		}
		remove(indexCounter);
		return true;
	}

	// Returns the i-th element.               
	public Nucleotide get(int i) {
		if(i <0 || i>= size()){
			throw new IndexOutOfBoundsException();
		}
		ListNode2 thisNode = SENTINEL;
		for (int j = 0; j <= i; j++) {
			thisNode = thisNode.getNext();
		}
		return (Nucleotide) thisNode.getValue();
	}

	// Replaces the i-th element with obj and returns the old value.
	public Nucleotide set(int i, Nucleotide obj) {
		if (i < 0 || i >= size()) {
			throw new IndexOutOfBoundsException();
		}
		Nucleotide preserve = get(i);
		ListNode2 replacement = new ListNode2(obj);
		replacement.setNext(getNode(i).getNext());
		replacement.setPrevious(getNode(i).getPrevious());
		if (i == size() - 1) {
			System.out.println("here");
			SENTINEL.setPrevious(replacement);
			getNode(i - 1).setNext(replacement);
			// remove(size()-1);
			return preserve;
		}
		getNode(i).setValue(obj);
		return preserve;
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Nucleotide obj) {
		if (i < 0 || i > size()) {
			throw new IndexOutOfBoundsException();
		}
		ListNode2 addition = new ListNode2(obj);
		if (i == 0) {
			if (getHead() == null) {
				SENTINEL.setNext(addition);
				SENTINEL.setPrevious(addition);
			} else {
				// nodeCount++;
				ListNode2 currHead = SENTINEL.getNext();
				addition.setPrevious(SENTINEL);
				addition.setNext(currHead);
				currHead.setPrevious(addition);
				SENTINEL.setNext(addition);
			}
		}
		else if (i == size()) {
			add(obj);
		} else {
			ListNode2 thisNode = SENTINEL.getNext();
			for (int j = 0; j < i - 1; j++) {
				thisNode = thisNode.getNext();
			}
			addition.setNext(thisNode.getNext());
			addition.setPrevious(thisNode);
			thisNode.getNext().setPrevious(addition);
			thisNode.setNext(addition);
		}
		nodeCount++;
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public Nucleotide remove(int i) {
		if (i < 0 || i >= size()) {
			throw new IndexOutOfBoundsException();
		}
		Nucleotide preserve = get(i);
		// System.out.println(get(i));
		if (i == 0) {
			SENTINEL.setNext(getNode(1));
			getNode(0).setPrevious(SENTINEL);
			return preserve;
		}
		if (i == size() - 1) {
			// getNode(size() - 2).setNext(SENTINEL);
			SENTINEL.setPrevious(getNode(size() - 2));
			// return preserve;
		}
		// if (i == size() - 1) {
		// 	System.out.println("here");
		// 	getNode(i - 1).setNext(SENTINEL);
		// 	System.out.println("here");
		// 	SENTINEL.setPrevious(getNode(i).getPrevious());
		// 	System.out.println("here");
		// 	nodeCount--;
		// 	return preserve;
		// } 
		else {
			getNode(i + 1).setPrevious(getNode(i).getPrevious()); // in case of tester, setting previous 
			getNode(i - 1).setNext(getNode(i).getNext()); // in case of tester, setting next of t to a, check!
		}

		// getNode(0).setPrevious(SENTINEL);
		// getNode(i + 1).setPrevious(getNode(i).getPrevious());
		nodeCount--;
		return preserve;
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {
		ListNode2 thisNode = getHead();
		String theToString = "[";
		while (thisNode.getValue() != null) {
			theToString = theToString + thisNode.getValue();
			if (thisNode.getNext().getValue() != null) {
				theToString = theToString + ", ";
			}
			thisNode = thisNode.getNext();
		}
		return theToString + "]";

	}
	
	// Like question 7 on the SinglyLinkedList test:
	// Add a "segment" (another list) onto the end of this list
	public void addSegmentToEnd(DoublyLinkedList seg) {
		for (int i = 0; i < seg.size(); i++) {
			add(seg.get(i));
		}
	}
	// DONE
	
	// Like question 8 on the SinglyLinkedList test:
	// You are to remove the next 16 nodes from the list, after the node nodeBefore.
	// (on the test these nodes were assumed to contain CCCCCCCCGGGGGGGG, but here
	// you do not need to assume or check for that)
	public void removeCCCCCCCCGGGGGGGG(ListNode2<Nucleotide> nodeBefore) {
		ListNode2 thisNode = SENTINEL.getNext();
		boolean outOfNodes = false;
		DoublyLinkedList preserve = this;
		for (int i = 0; i < size() - 1; i++) {
			if (thisNode == nodeBefore) {
				System.out.println(i);
				for (int j = 1; j <= 16; j++) {
					// System.out.println("here");
					System.out.println(i + j);
					remove(i + j);
					nodeCount++;
					if (i + j == nodeCount - 1) {
						// System.out.println("in if");
						outOfNodes = true;
						nodeCount -= j;
						j = 17;
					}
				}
			}
			thisNode = thisNode.getNext();
		}
		if (!outOfNodes) {
			nodeCount -= 16;	
		}
	}
	
	// Like question 9 on the SinglyLinkedList test:
	// You are to find and delete the first instance of seg in the list.
	// If seg is not in the list, return false, otherwise return true.
	public boolean deleteSegment(DoublyLinkedList seg) {
		if (size() < seg.size()) {
			return false;
		}
		for (int i = 0; i < size() - seg.size() - 1; i++) {
			if (get(i) == seg.get(0)) {
				for (int j = 0; j < seg.size(); j++) {
					if (get(i + j) != seg.get(j)) {
						return false;
					}
				}
				for (int k = 0; k < seg.size(); k++) {
					remove(i + k);
				}
			}
		}
		return false;
	}
	
	// Like question 10 on the SinglyLinkedList test:
	// Delete the last three nodes in the list
	// If there are not enough nodes, return false
	public boolean deleteLastThree() {
		int size = size();
		if (size() < 3) {
			return false;
		}
		for (int i = 1; i <= 3; i++) {
			System.out.println("here");
			remove(size - i);
		}
		nodeCount -= 3;
		return true;
	}

	// Like question 11 on the SinglyLinkedList test:
	// Replaces every node containing "A" with three nodes containing "T" "A" "C"
	public void replaceEveryAWithTAC() {
		for (int i = 0; i < size(); i++) {
			if (get(i).equals(Nucleotide.A)) {
				getNode(i).getPrevious().setNext(new ListNode2(Nucleotide.T));
			}
		}
	}
	
	// HELPER METHODS
	public ListNode2 getNode(int i) {
		if (i < 0 || i >= size() && size() != 0) {
			throw new IndexOutOfBoundsException();
		}
		ListNode2 thisNode = SENTINEL;
		for (int j = 0; j <= i; j++) {
			thisNode = thisNode.getNext();
		}
		return thisNode;
	}
}
