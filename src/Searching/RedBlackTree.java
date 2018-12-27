package Searching;

import org.w3c.dom.Node;

public class RedBlackTree<Key extends Comparable<Key>,Value> {
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private Node root;
	
	private class Node {
		Key key; // key
		Value val; // associated data
		Node left, right; // subtrees
		int N; // # nodes in this subtree
		boolean color; // color of link from
		// parent to this node

		Node(Key key, Value val, int N, boolean color) {
			this.key = key;
			this.val = val;
			this.N = N;
			this.color = color;
		}
	}

	private boolean isRed(Node x) {
		if (x == null)
			return false;
		return x.color == RED;
	}
	
	public int size() {
		return root.N; 
	}
	private int size(Node node) {
		return node.N;
	}
	/*************** rotation ******************/
	// node!=null
	private Node rotateLeft(Node node) {
		Node x = node.right;
		node.right = x.left;
		x.left = node;
		
		x.color = node.color;
		node.color = RED;
		x.N = node.N;
		node.N = size(node.left) + size(node.right) +1;
		return x;
	}
	// node!=null
	private Node rotateRight(Node node) {
		Node x = node.left;
		node.left = x.right;
		x.right = node;
		
		x.color = node.color;
		node.color = RED;
		x.N = node.N;
		node.N = size(x.right)+ size(node.right)+1;
		return x;
	}
	
	/** flip color **/
	private void flipColor(Node h) {
		h.color = RED;
		h.right.color = BLACK;
		h.left.color = BLACK;
	}
	
	/** insert node **/
	public void put(Key key, Value val) {
		root = put(root,key,val);
		root.color = BLACK;
	}
	// TODO
	private Node put(Node node,Key key,Value val) {
	
		if(node==null) return new Node(key,val,1,RED);
		int cmp = key.compareTo(node.key);
		if(cmp>0) node.right = put(node.right,key,val);
		else if(cmp<0) node.left = put(node.left,key,val);
		else node.val = val;
		
		if(isRed(node.left) && isRed(node.right)) flipColor(node);
//		if (isRed(node.))
		return node;
	}

	
}
