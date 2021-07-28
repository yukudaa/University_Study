package project4;

import java.util.ArrayList;
import java.util.Iterator;

public class redBlack<K extends Comparable<K>, V> {
	private class Node {
		private K key;
		private V val;
		private Node left;
		private Node right;
		private boolean color;

		public Node(K k, V v, Boolean color) {
			this.key = k;
			this.val = v;
			this.color = color;
		}

	}

	private Node root;

	private Object treeList;

	private static final boolean RED = true;
	private static final boolean BLACK = false;

	public boolean redBlack(Node x) {
		if (x == null)
			return false;
		return x.color == RED;
	}

	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}

	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}

	private void flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}

	private Node search(Node node, K k) {
		if (node == null)
			return null;
		int cmp = k.compareTo(node.key);
		if (cmp < 0)
			return search(node.left, k);
		else if (cmp > 0)
			return search(node.right, k);
		else
			return node;
	} // 내부에 숨기는거

	public Node search(K k) {
		return search(root, k);
	} // 공개 인터페이스

	public void insert(K k, V v) {
		root = insert(root, k, v);
		root.color = BLACK;
	}

	private Node insert(Node node, K k, V v) {
		if (node == null)
			return new Node(k, v, RED);
		int cmp = k.compareTo(node.key);
		if (cmp < 0)
			node.left = insert(node.left, k, v);
		else if (cmp > 0)
			node.right = insert(node.right, k, v);
		else {
			node.val = v;
		}
		if (redBlack(node.right) && !redBlack(node.left)) {
			node = rotateLeft(node);
		}
		if (redBlack(node.left) && redBlack(node.left.left)) {
			node = rotateRight(node);
		}
		if (redBlack(node.left) && redBlack(node.right)) {
			flipColors(node);
		}
		return node;
	}

	private void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.left);
		System.out.print(node.key + " ");
		inorder(node.right);
	}

	public void inorder() {
		System.out.print("In-order : ");
		inorder(root);
		System.out.println("");
	}

	private int height(Node node) {
		if (node == null)
			return -1;
		return 1 + Math.max(height(node.left), height(node.right));
	}

	public int height() {
		return height(root);
	}

	/*
	 * public int height2(K k) { Node node = search(k); for(int i = 0; i <
	 * height2(k); i++) { if (node == null ) if(k != null) { return -1; } } return 1
	 * + Math.max(height2(node.left), height2(node.right)); }
	 */

	public K getRootKey() {
		return root.key;
	}

	public V getValue(Node node) {
		return node.val;
	}

}
