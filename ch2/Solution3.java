/*
This file: Solution3.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter2 - 3
Description: Delete a node in the middle of a singly linked list
Assumption: 1. Node to be deleted is not the last node in the linked list
Time Complexity: O(1)
Space Complexity: O(1)
Last Modified: 9/20/2014 
 */

package _23;

public class Solution3 {
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
		DeleteMiddleNode(n2);
		// Print List after delete
		System.out.println("\nAfter deleting");
		n0.PrintList();

	}

	public static void DeleteMiddleNode(Node n) {
		while (n == null || n.next == null) {
			System.out.println("Last element or is null");
		}
		// When we have access to only this node
		// we change the value of this node and make it skip one node
		n.data = n.next.data;
		n.next = n.next.next;
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
