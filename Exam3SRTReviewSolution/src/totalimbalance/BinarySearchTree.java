package totalimbalance;

/**
 * @author You!
 * @param <T>
 */
public class BinarySearchTree {

	BinaryNode root;

	private final BinaryNode NULL_NODE = new BinaryNode(null);

	public BinarySearchTree() {
		root = NULL_NODE;
	}

	/**
	 * Finds the total imbalance of a tree.
	 * That is, take a tree and find the sum of the positive difference of each of their subtree heights.
	 * See printout for examples.
	 * 
	 * @return Finds the sum of every height imbalance within the tree;
	 */
	public int totalImbalance() {
		// TODO: Write me
		return root.totalImbalance().total;
	}
	
	public class ImbalanceHelper {
		public int total;
		public int height;
		
		public ImbalanceHelper(int total, int height) {
			this.total = total;
			this.height = height;
		}
	}
	
	/**
	 * Feel free to call from tests to use to verify the shapes of your trees
	 * while debugging. Just remove the calls you are done so the output isn't
	 * cluttered.
	 * 
	 * @return A string showing a traversal of the nodes where children are
	 *         indented so that the structure of the tree can be determined.
	 * 
	 */
	public String toIndentString() {
		return root.toIndentString("");
	}

	// The next methods are used by the unit tests
	public void insert(Integer e) {
		root = root.insert(e);
	}

	@Override
	public String toString() {
		return root.toString();
	}

	// /////////////// BinaryNode
	public class BinaryNode {

		public Integer data;
		public BinaryNode left;
		public BinaryNode right;

		public BinaryNode(Integer data) {
			this.data = data;
			this.left = NULL_NODE;
			this.right = NULL_NODE;
		}

		public ImbalanceHelper totalImbalance() {
			if (this == NULL_NODE)
				return new ImbalanceHelper(0, -1);
			
			ImbalanceHelper lHelper = left.totalImbalance();
			ImbalanceHelper rHelper = right.totalImbalance();
			
			return new ImbalanceHelper (
					lHelper.total + rHelper.total + Math.abs(lHelper.height - rHelper.height), 
					Math.max(lHelper.height, rHelper.height) + 1);
		}

		public BinaryNode insert(Integer e) {
			if (this == NULL_NODE) {
				return new BinaryNode(e);
			} else if (e < data) {
				left = left.insert(e);
			} else if (e > data) {
				right = right.insert(e);
			} else {
				// do nothing
			}
			return this;
		}
		
		@Override
		public String toString() {
			if (this == NULL_NODE) {
				return "";
			}
			return left.toString() + this.data.toString() + right.toString();
		}

		public String toIndentString(String indent) {
			if (this == NULL_NODE) {
				return indent + "NULL\n";
			}

			String myInfo = indent + String.format("%c\n", this.data);

			return myInfo + this.left.toIndentString(indent + "  ") + this.right.toIndentString(indent + "  ");
		}
	}
}