package totalimbalance;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;


public class Testing {

	private static int countTotalImbalancePoints = 0;
	
	@Test
	public void testTotalImbalance_useLargeTree_return11 () {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(1);
		bst.insert(0);
		bst.insert(8);
		bst.insert(6);
		bst.insert(9);
		bst.insert(5);
		bst.insert(7);
		bst.insert(3);
		bst.insert(2);
		bst.insert(4);
		assertEquals(bst.totalImbalance(), 11);
		countTotalImbalancePoints += 5;
	}
	
	@Test
	public void testTotalImbalance_useSlantTree_return15 () {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(0);
		bst.insert(1);
		bst.insert(2);
		bst.insert(3);
		bst.insert(4);
		bst.insert(5);
		assertEquals(bst.totalImbalance(), 15);
		countTotalImbalancePoints += 5;
	}
	
	@Test
	public void testTotalImbalance_useFullTree_return0 () {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(0);
		bst.insert(-2);
		bst.insert(2);
		bst.insert(-3);
		bst.insert(-1);
		bst.insert(1);
		bst.insert(3);
		assertEquals(bst.totalImbalance(), 0);
		countTotalImbalancePoints += 4;
	}
	
	@Test
	public void testTotalImbalance_useEmptyTree_return0 () {
		BinarySearchTree bst = new BinarySearchTree();
		assertEquals(bst.totalImbalance(), 0);
		countTotalImbalancePoints += 1;
	}


	@AfterClass
	public static void displayPoints() {
		System.out.printf("countHeightImbalancedNodes unit tests:  %2d/15\n", countTotalImbalancePoints);
		System.out.printf("countHeightImbalancedNodes efficiency will be checked by a grader\n");
	}
}