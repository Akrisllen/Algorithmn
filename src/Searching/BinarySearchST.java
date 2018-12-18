package Searching;

import java.util.Queue;

/**
 * Search in an ordered array
 * 
 * @author akrisllen
 *
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] vals;
	private int N;

	public BinarySearchST(int capacity) { // See Algorithm 1.1 for standard array-resizing code.
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}

	public int size() {
		return N;
	}
	public boolean isEmpty() {
		return this.N == 0 ;
	}
	public Value get(Key key) {
		if (isEmpty())
			return null;
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0)
			return vals[i];
		else
			return null;
	}

	public int rank(Key key) {
		// binary search in an ordered array
		// lgN + 1 compares for a search
		int low = 0;
		int high = this.N;
		int mid ;
		while (low < high) {
			mid = (low + high) / 2;
			int cmp = key.compareTo(this.keys[mid]);
			if (cmp > 0) {
				low = mid + 1;
			} else if (cmp < 0) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return low;
	}

	public void put(Key key, Value val) { // Search for key. Update value if found; grow table if new.
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			vals[i] = val;
			return;
		}
		for (int j = N; j > i; j--) {
			keys[j] = keys[j - 1];
			vals[j] = vals[j - 1];
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}

	public void delete(Key key) {
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) != 0) return;
		System.arraycopy(this.keys, i+1, this.keys, i, 1);
		System.arraycopy(this.vals, i+1, this.keys, i, 1);
		this.keys[--N] = null; 
		this.vals[--N] = null; 
	}

	
	public Key floor(Key key) {
		// get the biggest number < key 
		int i = rank(key);
		if(i==0) return null;
		return keys[i+1];
	}
	
	public Key min() {
		return keys[0];
	}

	public Key max() {
		return keys[N - 1];
	}

	public Key select(int k) {
		return keys[k];
	}

	public Key ceiling(Key key) {
		int i = rank(key);
		return keys[i];
	}

//	public Iterable<Key> keys(Key lo, Key hi) {
//		Queue<Key> q = new Queue<Key>();
//		for (int i = rank(lo); i < rank(hi); i++)
//			q.enqueue(keys[i]);
//		if (contains(hi))
//			q.enqueue(keys[rank(hi)]);
//		return q;
//	}
}
