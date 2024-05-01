package numcollided;

import java.util.Arrays;

/**
 * 
 * A simplified-for-exam-purposes hash set implementation for Strings 
 * using linear probing and no array resizing/rehashing. Cannot insert
 * null into the set. Other requirements are given with each method.
 */
public class StringHashSet {
	private int mSize;
	private String[] mArray;
	private int mCapacity;

	/**
	 * Creates a Hash Set with the given capacity.
	 */
	public StringHashSet(int initialCapacity) {
		mCapacity = initialCapacity;
		mArray = new String[mCapacity];
		mSize = 0;
	} // StringHashSet

	/**
	 * See the paper specification for details.
	 * 
	 * @return The number of items in the hashtable that collided
	 */
	public int numCollidedEntries() {
		int numCollisions = 0;
		for (int i = 0;i < mCapacity; i ++) {
			String curr = mArray[i];
			if (curr != null && getIndex(curr, mCapacity) != i) {
				numCollisions ++;
			}
		}
		return numCollisions;
	} // numCollidedEntries
	
	private int getIndex(String item, int capacity) {
		int hashCode = item.hashCode();
		if (hashCode < 0) {
			hashCode += Integer.MAX_VALUE + 1;
		}
		return hashCode % capacity;
	}

	/**
	 * Adds a new node if it is not there already. Do linear-probing to resolve
	 * collisions. No re-hashing, so if the array fills, this will give an infinite loop
	 * 
	 * @param item
	 * @return true if the item was successfully added (that is, if that hash table
	 *         was modified as a result of this call), false otherwise.
	 */
	public boolean add(String item) {
		// TODO: Note that you may NOT modify this method.
		if (contains(item)) {
			return false;
		}
		int hc = item.hashCode();
		if (hc < 0) {
			hc += Integer.MAX_VALUE + 1;
		}
		int index = hc % mCapacity;
		while (mArray[index % mCapacity] != null) {
			index++;
		}
		mArray[index % mCapacity] = item;
		mSize++;
		return true;
	} // add
	
	/**
	 * Checks if the given item is in the hash table.
	 *
	 * @param item
	 * @return True if and only if the item is in the hash table.
	 */
	public boolean contains(String item) {
		// TODO: Note that you may NOT modify this method.
		int hc = item.hashCode();
		if (hc < 0) {
			hc += Integer.MAX_VALUE + 1;
		}
		int index = hc % mCapacity;
		String current = mArray[index];	
		while (current != null) {
			if (current.equals(item)) {
				return true;
			}
			index++;
			current = mArray[index % mCapacity];
		}
		return false;
	} // contains

	public int size() {
		return mSize;
	} // size

	public boolean isEmpty() {
		return size() == 0;
	} // isEmpty

	@Override
	public String toString() {
		return Arrays.toString(mArray);
	} // toString

}
