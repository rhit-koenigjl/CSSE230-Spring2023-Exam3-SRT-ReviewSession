package preOrderInOrderBuild;

// This is the class you should modify for problem 2B.

public class PreorderInorderBuild {

	public static BinaryNode buildFromPreOrderInorder(String pre, String in) {
		if (pre.length() == in.length())
			return preIn(pre, in);
		throw new IllegalArgumentException();
	}
	
	private static BinaryNode preIn(String pre, String in) {
		if (pre.equals(""))
			return null;
		char rootChar = pre.charAt(0);
		int rootPos = in.indexOf(rootChar);
		return new BinaryNode(rootChar,
				preIn(pre.substring(1, rootPos + 1), in.substring(0, rootPos)),
				preIn(pre.substring(rootPos + 1), in.substring(rootPos + 1)));
	}
}
