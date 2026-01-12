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
		BinaryNode toAdd = new BinaryNode(value);
		if (root == null) {
			root = toAdd;
			toAdd.setHeight(0);
			return true;
		}
		return addHelper(root, toAdd, 1);
		// PROBLEM: checking if it has left AND right so then once it doesn't, it moves on to adding the new node, but it might already have the place that the new node would take filled (like just left or just right)
	}
	
	public boolean addHelper(BinaryNode thisNode, BinaryNode toAdd, int height) {
		Comparable val = toAdd.getValue();
		if (val.compareTo(thisNode.getValue()) < 0) {
			if (thisNode.hasLeft()) { // skipping this but thisNode does have left??????? wait no it doesn't then why is it replacing :(
				height++;
				addHelper(thisNode.getLeft(), toAdd, height);
			} else { //NEED ELSE, was doing both :(
				thisNode.setLeft(toAdd);
				toAdd.setParent(thisNode);
				toAdd.setHeight(height); // HAVE TO ACTUALLY ADD TO HEIGHT! >:(, DONE i think
				return true; 
			}
		}
		else if (val.compareTo(thisNode.getValue()) > 0) {
			if (thisNode.hasRight()) {
				height++;
				addHelper(thisNode.getRight(), toAdd, height);
			} else {
				thisNode.setRight(toAdd);
				toAdd.setParent(thisNode);
				toAdd.setHeight(height);
				return true;
			}
		} else {
			return false;
		}
		return false;
	}

	// Removes value from this BST.  Returns true if value has been
	// found and removed; otherwise returns false.
	// If removing a node with two children: replace it with the
	//  largest node in the right subtree
	public boolean remove(E value) {
		if (root == null) {
			return false;
		}
		BinaryNode toRemove = find(root, value);
		if (toRemove == null) {
			return false;
		}
		if (toRemove.getValue().equals(root.getValue()) && !toRemove.hasLeft() && !toRemove.hasRight()) {
			root = null;
			return true;
		}

		// removed node doesn't have children (easy, just cut it off)
		if (!toRemove.hasLeft() && !toRemove.hasRight()) {
			if (toRemove.getParent().getValue().compareTo(toRemove.getValue()) > 0) {
				toRemove.getParent().setLeft(null);
				return true;
			} else {
				toRemove.getParent().setRight(null);
				return true;
			}
		}

		// removed node has one child
		// only left
		if (toRemove.hasLeft() && !toRemove.hasRight()) {
			if (toRemove.getValue().equals(root.getValue())) {
				root = root.getLeft();
				return true;
			}
			if (toRemove.getParent().getValue().compareTo(toRemove.getValue()) > 0) {
				toRemove.getParent().setLeft(toRemove.getLeft());
				return true;
			} else {
				toRemove.getParent().setRight(toRemove.getLeft());
				return true;
			}
		}
		// only right
		if (toRemove.hasRight() && !toRemove.hasLeft()) {
			if (toRemove.getParent().getValue().compareTo(toRemove.getValue()) > 0) {
				toRemove.getParent().setLeft(toRemove.getRight());
				return true;
			} else {
				toRemove.getParent().setRight(toRemove.getRight());
				return true;
			}
		}

		// finding replacement node
		BinaryNode replacement = toRemove.getLeft();
		while (replacement.hasRight()) {
			replacement = replacement.getRight();
		}

		// 

		// rehoming
		BinaryNode replacementParent = replacement.getParent();
		if (replacement.hasLeft()) {
			decreaseHeight(replacement.getLeft());
			replacementParent.setRight(replacement.getLeft());
		} else {
			replacementParent.setRight(null); // problematic if replacement is just one down from toRemove
		}

		// replacing val of remove
		toRemove.setValue(replacement.getValue());

		// cuts off toRemove
		// if (toRemove.getParent().getValue().compareTo(toRemove.getValue()) > 0) {
		// 	toRemove.getParent().setLeft(replacement);
		// } else {
		// 	toRemove.getParent().setRight(replacement);
		// }
		// if (toRemove.hasRight()) {
		// 	replacement.setRight(toRemove.getRight());
		// }

		// if (!thisNode.hasLeft()) {
		// 	if (thisNode.getParent().getValue().compareTo(thisNode.getValue()) > 0) {
		// 		thisNode.getParent().setRight(null);
		// 	} else {
		// 		thisNode.getParent().setLeft(null);
		// 	}
		// }
		// EDGE CASE: node getting promoted may have a node to the right!!! have to not just account here but also adjust heights // done:)
		return true;
	}
	
	public static void decreaseHeight(BinaryNode node) {
		node.setHeight(node.getHeight() - 1);
		if (node.hasLeft()) {
			decreaseHeight(node.getLeft());
		}
		if (node.hasRight()) {
			decreaseHeight(node.getRight());
		}
	}
	
	public BinaryNode find(BinaryNode thisNode, E value) {
		if (thisNode.getValue().equals(value)) {
			return thisNode;
		}
		if (thisNode.hasLeft()) {
			if (find(thisNode.getLeft(), value) != null) {
				return find(thisNode.getLeft(), value);
			}
		}
		if (thisNode.hasRight()) {
			if (find(thisNode.getRight(), value) != null) {
				return find(thisNode.getRight(), value);
			}
		}
		return null;
	}
	
	// Returns the minimum in the tree
	public E min() {
		BinaryNode thisNode = root;
		while (thisNode.hasLeft()) {
			thisNode = thisNode.getLeft();
		}
		return (E) thisNode.getValue();
	}
	
	// Returns the maximum in the tree.
	public E max() {
		BinaryNode thisNode = root;
		while (thisNode.hasRight()) {
			thisNode = thisNode.getRight();
		}
		return (E) thisNode.getValue();
	}

	public static boolean balance(BinaryNode node) {
		// if left of node is heavier by more than 1 do rebalanceLeft & return true
		// if right of node is heavier by more than 1 do rebalanceRight & return true
		// else return false
		return false;
	}

	public static void rebalanceLeft(BinaryNode node) {
		BinaryNode curr = node;
		BinaryNode leftOfNode = node.getLeft();
		BinaryNode leftOfLeft = node.getLeft().getLeft();
		node.setValue(leftOfNode.getValue());
		node.setLeft(leftOfLeft);
		node.setRight(curr);
		// is assumption that since this is constantly being done, it will never be heavier by more than 2???
	}
	
	public static void rebalanceRight(BinaryNode node) {
		BinaryNode curr = node;
		BinaryNode rightOfNode = node.getLeft();
		BinaryNode rightOfRight = node.getLeft().getLeft();
		node.setValue(rightOfNode.getValue());
		node.setRight(rightOfRight);
		node.setLeft(curr);
	}


	// Returns a bracket-surrounded, comma separated list of the contents of the nodes, in order
	// e.g. [Apple, Cranberry, Durian, Mango]
	public String toString() {
		if (root == null) {
			return "[]";
		}
		String toReturn = toStringHelper(root, "");
		toReturn = toReturn.substring(0, toReturn.length() - 2);
		return "[" + toReturn + "]";
	}

	public String toStringHelper(BinaryNode thisNode, String curr){
		if (thisNode.hasLeft()) {
			curr = toStringHelper(thisNode.getLeft(), curr);
		}
		curr += thisNode + ", ";
		if (thisNode.hasRight()) {
			curr = toStringHelper(thisNode.getRight(), curr);
		}
		return curr;
	}


}
