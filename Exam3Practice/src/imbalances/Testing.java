package imbalances;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;


public class Testing {

	private static int countHeightImbalancedNodesPoints = 0;
	
	
	@Test
	public void testCountHeightImbalancedNodesGivenExample() {
		BinarySearchTree t = new BinarySearchTree();
		assertEquals(0,t.countHeightImbalancedNodes());
		t.insert('E');
		t.insert('A');
		t.insert('G');
		t.insert('D');
		t.insert('C');
		t.insert('B');
		t.insert('F');
		t.insert('H');
		t.insert('I');
		assertEquals(2,t.countHeightImbalancedNodes());
		countHeightImbalancedNodesPoints += 4;
	}
	
	
	@Test
	public void testCountHeightImbalancedNodesDegenerateTree() {
		BinarySearchTree t = new BinarySearchTree();
		assertEquals(0,t.countHeightImbalancedNodes());
		for (int i = 0; i < 10; i++) {
			t.insert((char) ('A' + i));
		}
		assertEquals(8,t.countHeightImbalancedNodes());
		for (int i = 25; i >= 16; i--) {
			t.insert((char) ('A' + i));
		}
		assertEquals(18,t.countHeightImbalancedNodes());
		for (int i = 10; i < 16; i++) {
			t.insert((char) ('A' + i));
		}
		assertEquals(24,t.countHeightImbalancedNodes());
		countHeightImbalancedNodesPoints += 3;
	}
	

	
	@Test
	public void testCountHeightImbalancedNodesBigger() {
		BinarySearchTree t = new BinarySearchTree();
		assertEquals(0,t.countHeightImbalancedNodes());
		t.insert('M');
		t.insert('H');
		t.insert('B');
		t.insert('A');
		t.insert('L');
		t.insert('K');
		t.insert('J');
		t.insert('P');
		t.insert('N');
		t.insert('T');
		assertEquals(2,t.countHeightImbalancedNodes());
		t.insert('S');
		assertEquals(1,t.countHeightImbalancedNodes());
		t.insert('Q');
		t.insert('R');
		t.insert('U');
		t.insert('X');
		t.insert('W');
		t.insert('V');
		t.insert('Y');
		assertEquals(5,t.countHeightImbalancedNodes());
		countHeightImbalancedNodesPoints += 4;
	}
	

	
	@Test
	public void testCountHeightImbalancedNodesFullTreeWithExtraBranches() {
		BinarySearchTree t = new BinarySearchTree();
		t.makeIntoFullDepthTree('M', 5); // make full tree of height 6. All nodes balanced.
		assertEquals(0,t.countHeightImbalancedNodes());
		t.insert('Z');
		t.insert('Y'); // All ancestors of Z now imbalanced
		assertEquals(6,t.countHeightImbalancedNodes());
		t.insert('B');
		t.insert('A'); // Root now balanced, while all other ancestors of B now imbalanced. 
		assertEquals(10,t.countHeightImbalancedNodes());
		countHeightImbalancedNodesPoints += 4;
	}
	


	@AfterClass
	public static void displayPoints() {
		System.out.printf("countHeightImbalancedNodes unit tests:  %2d/15\n", countHeightImbalancedNodesPoints);
		System.out.printf("countHeightImbalancedNodes efficiency:   ?/15  (checked by grader)\n");
	}
}