package weightedheight;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Test;

public class TreeTest {

	private static int points = 0;
		
	@Test
	public void testSimpleDegenerateCases() {
		BinarySearchTree t = new BinarySearchTree();
		assertEquals(0, t.weightedHeight());
		points += 1;
		//    a
		//     \
		//      b
		//       \
		//        c
		t.insert('a');
		assertEquals(0, t.weightedHeight());
		points += 1;
		t.insert('b');
		assertEquals(2, t.weightedHeight());
		points += 1;
		t.insert('c');
		assertEquals(8, t.weightedHeight());
		points += 2;
	} 
	
	
	@Test
	public void testFullTrees() {
		BinarySearchTree t = new BinarySearchTree();
		//      	 d
		//         /   \
		//        /     \
		//       b       f
		//      / \     / \
		//     a   c   e   g
		t.insert('d');		
		t.insert('b');		
		t.insert('f');
		assertEquals(3, t.weightedHeight());
		points += 2;
		t.insert('a');		
		t.insert('c');		
		t.insert('e');		
		t.insert('g');
		assertEquals(20, t.weightedHeight());
		points += 3;
	} 
	
	@Test
	public void testNonFullTreesOfVaryingHeights() {
		BinarySearchTree t = new BinarySearchTree();
		//          e
		//        /   \
		//       /     \
		//      /       \
		//     b         h
		//    / \       / 
		//   a   c     g
		//        \   /  
		//         d f
		t.insert('e');
		t.insert('b');
		t.insert('h');
		t.insert('a');
		assertEquals(10, t.weightedHeight());
		points += 2;
		t.insert('c');
		t.insert('d');
		t.insert('g');
		t.insert('f');
		assertEquals(42, t.weightedHeight());
		points += 3;

		
		//           e
		//         /   \
		//        /     \
		//       /       \
		//     b           i
		//   /   \       /   \
		//  a     c     g     k
		//         \   / \   / \
		//          d f   h j   l
		//     					 \
		//	     				  m
		//		     			   \
		//			     			n
		//				     		 \
		//					     	  o
		t = new BinarySearchTree();
		t.insert('e');
		t.insert('b');
		t.insert('a');
		t.insert('c');
		t.insert('d');
		t.insert('i');
		t.insert('g');
		t.insert('k');    
		t.insert('f');
		t.insert('h');
		t.insert('j');
		t.insert('l');    
		t.insert('m');    
		t.insert('n');
		t.insert('o');		
		assertEquals(197, t.weightedHeight());
		points += 5;
	} 
	


	@AfterClass
	public static void displayPoints() {
		System.out.printf("***  weightedHeight unit test points:                       " +
				"%2d / 20\n", points);
		System.out.printf("   The 15 additional efficiency points will be checked by the grader.\n");
	}
}