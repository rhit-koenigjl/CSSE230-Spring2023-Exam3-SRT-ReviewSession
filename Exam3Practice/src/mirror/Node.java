package mirror;

// /////////////// BinaryNode
public class Node {
	
	static final Node NULL_NODE = new Node();

	public Integer data;
	public Node left;
	public Node right;
	
	// The rest of the methods are used by the unit tests
	public Node() {
		this.data = null;
		this.left = null;
		this.right = null;
	}
	
	public Node(Integer data) {
		this.data = data;
		this.left = NULL_NODE;
		this.right = NULL_NODE;
	}

	public String preOrderTraversalString() {
		if (this == NULL_NODE) return "";
		return Integer.toString(data) + left.preOrderTraversalString() + right.preOrderTraversalString();
	}

	public String inOrderTraversalString() {
		if (this == NULL_NODE) return "";
		return left.inOrderTraversalString() + Integer.toString(data) + right.inOrderTraversalString();
	}
	
	public String postOrderTraversalString() {
		if (this == NULL_NODE) return "";
		return left.postOrderTraversalString() + right.postOrderTraversalString() + Integer.toString(data);
	}
	
	int height() {
		if (this == NULL_NODE) return -1;
		return 1 + Math.max(left.height(),  right.height());
	}
	
	public Node insert(Integer e) {
		if (this == NULL_NODE) {
			return new Node(e);
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
