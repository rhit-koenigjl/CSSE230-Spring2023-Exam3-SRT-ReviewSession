package weightedheight;

/**
 * An implementation of a binary search tree, containing Character data. 
 */


public class BinarySearchTree {	
	private BinaryNode root;
	private final BinaryNode NULL_NODE = new BinaryNode(null);

	public BinarySearchTree() {
		root = NULL_NODE;
	} // BinarySearchTree

	// The next methods are used by the unit tests
	public void insert(Character e) {
		root = root.insert(e);
	} // insert

	@Override
	public String toString() {
		return root.toString();
	} // toString

	/**
	 * See the paper specification for details and an example.
	 * 
	 * @return the weighted height for the given tree
	 */
	public int weightedHeight() {
		// TODO: Implement this according to the written specification
		return -1;		
	} // weightedHeight
	
	// ----------------------------
	// /////////////// BinaryNode
	// ----------------------------
	public class BinaryNode {
		public Character data;
		public BinaryNode left;
		public BinaryNode right;

		public BinaryNode(Character element) {
			this.data = element;
			this.left = NULL_NODE;
			this.right = NULL_NODE;
		} // BinaryNode

		// The next method is used by the unit tests
		public BinaryNode insert(Character e) {
			if (this == NULL_NODE) {
				return new BinaryNode(e);
			} else if (e.compareTo(this.data) < 0) {
				left = left.insert(e);
			} else if (e.compareTo(this.data) > 0) {
				right = right.insert(e);
			} else {
				// do nothing
			}
			return this;
		} // insert
		
		@Override
		// You can use this to see in-order traversal 
		public String toString() {
			if (this == NULL_NODE) {
				return "";
			}
			return left.toString() + this.data.toString() + right.toString();
		} // toString
		
	} // end BinaryNode Class
	
} // end BinarySearchTree Class