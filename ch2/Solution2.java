/*
This file: Solution2.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter2 - 2
Description: Find Kth to last element of a singly linked list
Assumption: 1. k=1 -> would return last element, k =2 -> would return to the second to last 
			   element
Time Complexity: O(n)
Space Complexity: O(1)
Last Modified: 9/20/2014 
 */

package _22;

public class Solution2 {
	public static void main(String[] args) {

		Node n0 = new Node(1);
		Node n1 = new Node(2);
		Node n2 = new Node(3);
		Node n3 = new Node(1);
		Node n4 = new Node(2);
		Node n5 = new Node(4);
		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		// Print Original list
		System.out.println("Input List");
		n0.PrintList();
		System.out.println("\nKth to last element");
		System.out.println(KToLast(n0, 4));
	}
	// Used two pointer approach 
	public static int KToLast(Node n, int k) {
		Node cur = n;
		Node fwd = n;

		// Move fwd to kth position
		for (int i = 0; i < k; i++) {
			if (fwd == null) {
				return 0;
			}
			fwd = fwd.next;
		}
		// Move the pointers together
		// when fwd reaches end cur will be a length - k
		while (fwd != null) {
			fwd = fwd.next;
			cur = cur.next;
		}
		return cur.data;
	}
}

// Linked List class
class Node {
	Node next = null;
	int data;

	public Node(int d) {
		data = d;
	}

	// Function to print linked List
	public void PrintList() {
		Node n = this;
		while (n.next != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.print(n.data);
	}
}
