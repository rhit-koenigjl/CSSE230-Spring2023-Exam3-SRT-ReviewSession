package mirror;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

/**
 * Tests the BinaryNode mirror() static method. 
 *
 * @author Matt Boutell.
 *         Created May 24, 2011.
 */
public class MirrorTest {

	private static int maxPoints = 0;
	private static int points = 0;
	
	@Test
	public void testMirrorEmpty() {
		BinarySearchTree t = new BinarySearchTree();
		testMirror("EmptyTree", t, 2);
	}
	
	@Test
	public void testMirrorOneElement() {
		BinarySearchTree t = new BinarySearchTree();
		t.insert(5);
		testMirror("OneElement", t, 3);
	}
	
	@Test
	public void testMirrorHeightIs1() {
		BinarySearchTree t = new BinarySearchTree();
		t.insert(5);
		t.insert(4);
		t.insert(6);
		testMirror("HeightIs1", t, 4);
	}

	@Test
	public void testMirrorHeightIs2() {
		BinarySearchTree t = new BinarySearchTree();
		t.insert(5);
		t.insert(3);
		t.insert(7);
		t.insert(2);
		t.insert(4);
		t.insert(6);
		t.insert(8);
		testMirror("HeightIs2", t, 7);
	}

	@Test
	public void testMirrorDifferentDepths() {
		BinarySearchTree t = new BinarySearchTree();
		t.insert(5);
		t.insert(3);
		t.insert(7);
		t.insert(1);
		t.insert(4);
		t.insert(6);
		t.insert(2);
		testMirror("DifferentDepths", t, 8);
	}
	
	/** Displays points */
	@AfterClass
	public static void displayPoints() {
		System.out.println("------------------------------------------------------");
		System.out.printf("#1 MIRROR earned %d/%d points\n", points, maxPoints);
		System.out.println("------------------------------------------------------");
		System.out.println();
	}
		
	/**
	 * Helper method for our tests.
	 * 
	 * @param s
	 * @return The input string s in reverse order ("4751"-->"1574")
	 */
	private String reverse(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			result = s.charAt(i) + result;
		}
		return result;
	}
	
	private void testMirror(String testName, BinarySearchTree original, int possiblePoints){
		maxPoints += possiblePoints;
		BinarySearchTree purportedMirror = new BinarySearchTree(original);
		String  io = original.inOrderTraversalString(),
				ip = purportedMirror.inOrderTraversalString(),
				ro = original.preOrderTraversalString(),
				rp = purportedMirror.preOrderTraversalString(),
				oo = original.postOrderTraversalString(),
				op = purportedMirror.postOrderTraversalString();
		int		ho = original.height(),
				hp = purportedMirror.height();
		int pointsThisTest = possiblePoints;
		System.out.print("Test " + testName + ":   ");
		if (!ip.equals(reverse(io))) {
			System.out.print("\n  error in inorder test: " + io + " " + ip + "\n  ");
			pointsThisTest = 0;
		}
		if (!op.equals(reverse(ro))) {
			System.out.print("\n  error in pre/post test: " + ro + " " + op + "\n  ");
			pointsThisTest = 0;
		}
		if (!rp.equals(reverse(oo))) {
			System.out.print("\n  error in post/pre test: " + oo + " " + rp + "\n  ");
			pointsThisTest = 0;
		}
		if (ho != hp) {
			System.out.print("\n  error in height test: " + ho + " " + hp + "\n  ");
			pointsThisTest = 0;
		}
		System.out.println("Points from this test: " + pointsThisTest + "/" + possiblePoints);
		if (pointsThisTest == 0) {
			assertTrue(false);
		}
		points += pointsThisTest;

	}
}
