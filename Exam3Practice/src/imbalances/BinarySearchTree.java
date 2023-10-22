package imbalances;

public class BinarySearchTree {

	BinaryNode root;

	final BinaryNode NULL_NODE = new BinaryNode(); 

	public BinarySearchTree() {
		root = NULL_NODE;
	}

	/**
	 * Calculates the number of nodes whose subtree heights differ by at least 2.
	 */
	public int countHeightImbalancedNodes() {
		// TODO Write this method!
		return -1;
	}
	
	
	
	// The next methods are used by the unit tests
	public void insert(Character e) {
		root = root.insert(e);
	}
	
	public void makeIntoFullDepthTree(Character ch, int depth) {
		this.root = makeFullDepthTree(ch, 0, depth);
	}

	private BinaryNode makeFullDepthTree(Character ch, int currentDepth, int maxDepth) {
		if (currentDepth > maxDepth) {
			return NULL_NODE;
		}
		BinaryNode node = new BinaryNode(ch);
		node.left = makeFullDepthTree(ch, currentDepth + 1, maxDepth);
		node.right = makeFullDepthTree(ch, currentDepth + 1, maxDepth);
		return node;
	}

	// /////////////// BinaryNode
	public class BinaryNode {
		
		public Character data;
		public BinaryNode left;
		public BinaryNode right;


		
		
		
		
		// The rest of the methods are used by the unit tests
		public BinaryNode() {
			this.data = null;
			this.left = null;
			this.right = null;
		}
		
		public BinaryNode(Character element) {
			this.data = element;
			this.left = NULL_NODE;
			this.right = NULL_NODE;
		}

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
		}
	}

}