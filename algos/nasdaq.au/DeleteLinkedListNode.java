package com.nasdaq.au;

public class DeleteLinkedListNode {

	public static Node deleteNode(Node node, int val) {
		Node prev = null;
		Node pointer = node;
		
		while(pointer != null) {
			if (pointer.value == val) {
				if (prev == null) {
					node = pointer.next;
				} else {
					prev.next = pointer.next;
				}
				break;
			}
			prev = pointer;
			pointer = pointer.next;
		}
		if (pointer == null) {
			throw new RuntimeException("Node not found");
		}
		return node;
	}
	
	private static class Node {
		Integer value;
		Node next;

		public Node(int value, Node next) {
			super();
			this.value = value;
			this.next = next;
		}
	}
	
	public static void main(String[] args) {
		Node node = new Node(5, null);
		int i = 4;
		while (i > 3) {
			node = new Node(i, node);
			i--;
		}
		node = deleteNode(node, 4);
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
	}
}
