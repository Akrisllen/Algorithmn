package Searching;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
	private Node root; // root of BST

	private class Node {
		private Key key; // key
		private Value val; // associated value
		private Node left, right; // links to subtrees
		private int N; // # nodes in subtree rooted here, root.N is the size of tree

		public Node(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}

	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if (x == null)
			return 0;
		else
			return x.N;
	}

	// recursive search binary tree
	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node node, Key key) {
		if (node == null)
			return null;
		int cmp = key.compareTo(node.key);
		if (cmp > 0)
			return get(node.right, key);
		else if (cmp < 0)
			return get(node.left, key);
		else
			return node.val;
	}

	// Change key’s value to val if key in subtree rooted at x.
	// Otherwise, add new node to subtree associating key with val.
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}

	private Node put(Node node, Key key, Value val) {
		if (node == null)
			return new Node(key, val, 1);
		int cmp = key.compareTo(node.key);
		if (cmp > 0)
			put(node.right, key, val);
		else if (cmp < 0)
			put(node.left, key, val);
		else
			node.val = val;
		node.N = size(node.left) + size(node.right) + 1;
		return node;
	}

	// get the minimum value in the tree
	public Key min() {
		return min(root).key;
	}

	private Node min(Node node) {
		if (node.left == null)
			return node;
		return min(node.left);
	}

	// get the maximum value in the tree
	public Key max() {
		return max(root).key;
	}

	private Node max(Node node) {
		if (node.right == null)
			return node;
		return max(node.right);
	}

	// get the smallest integer bigger than value
	public Key ceiling(Key key) {
		return ceiling(root, key).key;
	}

	private Node ceiling(Node node, Key key) {
		int cmp = key.compareTo(node.key);
		if (cmp < 0)
			return ceiling(node.right, key);
		if (cmp == 0)
			return node;
		Node res = floor(node.left, key);
		return res == null ? node : res;
	}

	// get the largest integer or less than or equal to value
	public Key floor(Key key) {
		return floor(root, key).key;
	}

	private Node floor(Node node, Key key) {
		if (node == null)
			return null;
		int cmp = key.compareTo(node.key);
		if (cmp == 0)
			return node;
		else if (cmp < 0)
			return floor(node.left, key);
		Node res = floor(node.right, key);
		return res == null ? node : res;
	}

	// return the rank of the key similarly
	public int rank(Key key) {
		return rank(root, key);
	}

	private int rank(Node node, Key key) {
		if (node == null)
			return 0;
		int cmp = key.compareTo(node.key);
		if (cmp == 0)
			return size(node.left);
		else if (cmp > 0)
			return rank(node.right, key) + size(node.left);
		return rank(node.left, key);
	}

	public void deleteMin() {
		root = deleteMin(root);
	}

	private Node deleteMin(Node node) {
		if (node == null)
			return null;
		if (node.left == null)
			return node.right;
		node.left = deleteMin(node.left);
		node.N = size(node.left) + size(node.right);
		return node;
	}

	/**
	 * delete a node if node has no children return null if node only has left/right
	 * child return left/right child if node has two children (1) find the min node
	 * of node's right subtree as node's successor (2) set the right value of the
	 * successor to deleteMin(node.right) (3) set the left value of the successor to
	 * node's left
	 * 
	 * @param key
	 */
	public void delete(Key key) {
		root = delete(root, key);
	}

	private Node delete(Node node, Key key) {
		if (node == null)
			return null;
		int cmp = key.compareTo(node.key);
		if (cmp > 0)
			return delete(node.right, key);
		else if (cmp < 0)
			return delete(node.left, key);
		else {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			} else {
				Node successor = node;
				node = min(node.right);
				node.right = deleteMin(successor.right);
				node.left = successor.left;
			}
			node.N = size(node.left) + size(node.right) + 1;
			return node;
		}
	}
}
