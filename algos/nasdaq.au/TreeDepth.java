package com.nasdaq.au;

public class TreeDepth {

	public static int findDepth(Node root) {
		int depth = 0;
		
		if (root != null) {
			int leftDepth = findDepth(root.left);
			depth++;
			int rightDepth = findDepth(root.right);
			if (leftDepth > rightDepth) {
				depth += leftDepth;
			} else {
				depth += rightDepth;
			}
		}
		return depth;
	}
	
	public static Node addroot(Node root, int val) {
		if (root == null) {
			root = new Node(val, null, null);
		} else {
			if (val < root.val) {
				root.left = addroot(root.left, val);
			} else {
				root.right = addroot(root.right, val);
			}
		}
		return root;
	}

	public static void inOrderTraversal(Node node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.print(node.val + " ");
			inOrderTraversal(node.right);
		}
	}

	public static void swapNodes(Node node, int currDepth, int targetDepth) {
		if (node != null) {
			if (currDepth == targetDepth) {
				Node temp = node.left;
				node.left = node.right;
				node.right = temp;
			} else {
				swapNodes(node.left, currDepth+1, targetDepth);
				swapNodes(node.right, currDepth+1, targetDepth);
			}
		}
	}
	
	private static class Node {
		int val;
		Node left;
		Node right;
		
		public Node(int val, Node left, Node right) {
			super();
			this.val = val;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "Node [val=" + val + "]";
		}
	}
	
	public static void main(String[] args) {
		Node root = addroot(null, 7);
		addroot(root, 3);
		addroot(root, 1);
		addroot(root, 2);
		addroot(root, 4);
		addroot(root, 5);
		addroot(root, 6);
		addroot(root, 10);
//		inOrderTraversal(root);
		//System.out.println(findDepth(root));
		
		swapNodes(root, 1, 3);
		
		inOrderTraversal(root);
	}
}
