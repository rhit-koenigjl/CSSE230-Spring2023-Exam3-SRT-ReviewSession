package mirror;

public class BinarySearchTree {

	Node root;

	public BinarySearchTree() {
		root = Node.NULL_NODE;
	}

	/**
	 * Creates a tree that is a mirror reflection (left to right) of the whole tree rooted at node t.
	 * Note that it won't be a BST after it is flipped
	 * 
	 * @param otherTree.
	 * @return A mirror reflection of the otherTree.
	 */
	public BinarySearchTree(BinarySearchTree otherTree) {
		// TODO: Replace this with your solution
	
	}
	
	// The next methods are used by the unit tests
	String preOrderTraversalString() {
		return root.preOrderTraversalString();
	}
	
	String inOrderTraversalString() {
		return root.inOrderTraversalString();
	}

	String postOrderTraversalString() {
		return root.postOrderTraversalString();
	}

	int height() {
		return root.height();
	}	
	
	public void insert(Integer e) {
		root = root.insert(e);
	}
	

}