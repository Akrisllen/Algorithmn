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
	private Value get(Node node,Key key) {
		if(node==null) return null;
		int cmp = key.compareTo(node.key);
		if(cmp>0) 
			return get(node.right,key);
		else if(cmp<0) 
			return get(node.left,key);
		else 
			return node.val;
	}
	// Change key’s value to val if key in subtree rooted at x.
	// Otherwise, add new node to subtree associating key with val.
	public void put(Key key, Value val) {
		root = put(root,key,val);
	}
	private Node put(Node node,Key key,Value val) {
		if(node==null) return new Node(key,val,1);
		int cmp = key.compareTo(node.key);
		if(cmp>0) 
			put(node.right,key,val);
		else if(cmp<0) 
			put(node.left,key,val);
		else 
			node.val = val;
		node.N = size(node.left) + size(node.right) + 1;
		return node;
	}
	public Key min() {
		return min(root).key;
	}
	private Node min(Node node) {
		if(node.left==null) return node;
		return min(node.left);
	}
	//get the largest integer less than value
	public Key floor(Key key) {
		return floor(root,key).key;
	}
	private Node floor(Node node,Key key) {
		if(node==null) return null;
		int cmp = key.compareTo(node.key);
		if(cmp==0) return node;
		else if(cmp<0) return floor(node.left,key);
		Node res = floor(node.right,key);
		if(res == null) return node;
		else return res;
	}
}
