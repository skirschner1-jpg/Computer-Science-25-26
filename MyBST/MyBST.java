// Implements a BST with BinaryNode nodes

public class MyBST<E extends Comparable<E>> {
	
	private BinaryNode<E> root;  // holds the root of this BST

	// Constructor: creates an empty BST.
	public MyBST() {
		root = null;
	}

	public BinaryNode<E> getRoot() {
		return root;
	}
	
	public int getHeight() {
		return root.getHeight();
	}

	// Returns true if this BST contains value; otherwise returns false.
	public boolean contains(E value) {
		return false;
	}

	// Adds value to this BST, unless this tree already holds value.
	// Returns true if value has been added; otherwise returns false.
	public boolean add(E value) {
		Comparable val = value;
		BinaryNode toAdd = new BinaryNode(value);
		if (root == null) {
			root = toAdd;
			return true;
		}
		BinaryNode thisNode = root;
		while (thisNode.hasLeft() && thisNode.hasRight()) {
			if (val.compareTo(thisNode.getValue()) == 0) {
				return false;
			}
			if (val.compareTo(thisNode.getValue()) < 0) {
				thisNode = thisNode.getLeft();
			} else if (val.compareTo(thisNode.getValue()) > 0) {
				thisNode = thisNode.getRight();
			} else {
				// System.out.println("here");
				// System.out.println();
				return false;
			}
		}
		if (val.compareTo(thisNode.getValue()) < 0) {
			thisNode.setLeft(toAdd);
			return true;
		}
		if (val.compareTo(thisNode.getValue()) > 0) {
			thisNode.setRight(toAdd);
			return true;
		} else {
			return false;
		}
		// PROBLEM: checking if it has left AND right so then once it doesn't, it moves on to adding the new node, but it might already have the place that the new node would take filled (like just left or just right)
	}

	// Removes value from this BST.  Returns true if value has been
	// found and removed; otherwise returns false.
	// If removing a node with two children: replace it with the
	//  largest node in the right subtree
	public boolean remove(E value) {
		return false;
	}
	
	// Returns the minimum in the tree
	public E min() {
		return null;
	}
	
	// Returns the maximum in the tree.
	public E max() {
		return null;
	}

	// Returns a bracket-surrounded, comma separated list of the contents of the nodes, in order
	// e.g. [Apple, Cranberry, Durian, Mango]
	public String toString() {
		return "[" + toStringHelper(root) + "]";
	}

	public String toStringHelper(BinaryNode thisNode){
		if (thisNode.hasLeft()) {
			thisNode.getLeft().toString();
		}
		// System.out.println(thisNode);
		if (thisNode.hasRight()) {
			System.out.println(thisNode.getRight());
		}
		return "";
	}


}
