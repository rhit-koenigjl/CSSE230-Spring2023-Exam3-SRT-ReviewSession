package numcollided;
import static org.junit.Assert.*;
import org.junit.*;

// Test class
public class StringHashSetTest {

	private static int points = 0;
	

	@Test
	public void testEmptyTable() {
		StringHashSet set = new StringHashSet(5);
		assertEquals(0, set.numCollidedEntries());
		points += 1;
	}
	
	@Test
	public void testSmallTableNoCollisions() {
		StringHashSet set = new StringHashSet(5);
		String[] toAdd = { "a", "b", "c"}; //ASCII: 97, 98, 99
		for (String item : toAdd) {
			set.add(item);
		}
		assertEquals(0, set.numCollidedEntries());
		points += 2; 	
	}
	
	@Test
	public void testSmallTableWithCollisions() {
		StringHashSet set = new StringHashSet(5);
		set.add("a"); //ASCII: 97
		assertEquals(0, set.numCollidedEntries());
		set.add("k"); //ASCII: 107
		assertEquals(1, set.numCollidedEntries());
		points += 1; 
		set.add("b"); //ASCII: 98
		assertEquals(2, set.numCollidedEntries());
		points += 1; 
	}
	
	@Test
	public void testMediumTable() {
		StringHashSet set = new StringHashSet(10);
		String[] toAdd = { "a", "f", "k"}; //ASCII: 97, 102, 107
		for (String item : toAdd) {
			set.add(item);
		}
		assertEquals(1, set.numCollidedEntries());
		points += 2;
		set.add("p"); //ASCII: 112
		assertEquals(2, set.numCollidedEntries());
		points += 2;
	}
	
	@Test
	public void testLargeTableOverlappingHashcodes() {
		StringHashSet set = new StringHashSet(20);
		String[] toAdd = { "a", "b", "c", "d", "e", "f", "g"}; //ASCII: 97-103
		for (String item : toAdd) {
			set.add(item);
		}
		assertEquals(0, set.numCollidedEntries());
		points += 2;
		set.add("u"); //ASCII: 117
		assertEquals(1, set.numCollidedEntries());
		set.add("v"); //ASCII: 118
		assertEquals(2, set.numCollidedEntries());
		set.add("w"); //ASCII: 119
		assertEquals(3, set.numCollidedEntries());
		set.add("x"); //ASCII: 120
		assertEquals(4, set.numCollidedEntries());
		set.add("y"); //ASCII: 121
		assertEquals(5, set.numCollidedEntries());
		set.add("z"); //ASCII: 122
		assertEquals(6, set.numCollidedEntries());
		set.add("{"); //ASCII: 123
		assertEquals(7, set.numCollidedEntries());
		set.add("|"); //ASCII: 124
		assertEquals(8, set.numCollidedEntries());
		points += 3;
	}
	
	@Test
	public void testLargeTableMultiplesOfASCII() {
		StringHashSet set = new StringHashSet(20);
		String[] toAdd = { "#", "(", "-", "2", "7", "<", "A", "F", "K", "P", 
				"U", "Z", "_", "d", "i", "n", "s", "x"}; //ASCII: 35-125 in multiples of 5
		for (String item : toAdd) {
			set.add(item);
		}
		assertEquals(14, set.numCollidedEntries());
		points += 4;
	}
	
	@Test
	public void testLargeStrings() {
		StringHashSet set = new StringHashSet(10);
		String[] toAdd = {"What are a bee's favorite decades?", "20zzzzzzzzzzzzzzzzzz", "30zzzzzzzzzzzzzzzzzzzzzzzzzzzz", 
				"50zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz", 
				"70zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz",  
				"80zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz", 
				"90zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"};
		for (String item : toAdd) {
			set.add(item);
		}
		assertEquals(3, set.numCollidedEntries());
		points += 2;
	}
	
	@AfterClass
	public static void displayPoints() {
		System.out.printf("***   StringHashSet unit test points:        		    %2d / 20\n", points);
		System.out.printf("   Note that points will be deducted for rerunning add or contains.\n");
	}
	

	
}
