/*
This file: Solution1.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter2 - 1
Description: Remove duplicates from an unsorted linked list
Assumption: Space complexity is given priority by interviewer.
Time Complexity: O(n2)
Space Complexity: O(1)
Last Modified: 9/20/2014 
 */

public class Solution1 {
	public static void main(String[] args) {
		// Declare linked list with duplicates
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
		// After removing duplicates
		Node res = RemoveDupl(n0);
		System.out.println("\nAfter removing duplicates");
		res.PrintList();
	}

	public static Node RemoveDupl(Node n) {
		// used two pointer approach first pointer runs through list
		// second pointer check for duplicates and removes them
		Node p1 = n;
		while (p1 != null) {
			Node p2 = p1;
			while (p2.next != null) {
				if (p2.next.data == p1.data) {
					p2.next = p2.next.next;
				} else {
					p2 = p2.next;
				}
			}
			p1 = p1.next;
		}
		return n;
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
