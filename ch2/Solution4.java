/*
This file: Solution4.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter2 - 4
Description: Partition a linked list around a value x
Assumption: 1. Maintaining order of the list is not important
Time Complexity: O(n)
Space Complexity: O(1)
Last Modified: 9/20/2014 
 */
package _24;

public class Solution4 {
	public static void main(String[] args) {

		Node n0 = new Node(3);
		Node n1 = new Node(5);
		Node n2 = new Node(8);
		Node n3 = new Node(5);
		Node n4 = new Node(10);
		Node n5 = new Node(2);
		Node n6 = new Node(1);

		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		// print original linked list
		System.out.println("original Linked list");
		n0.PrintList();
		System.out.println("after partitioning");
		Node op = partition(n0, 5);
		op.PrintList();

	}

	public static Node partition(Node nl, int x) {
		// Two dummy heads of queues
		Node head = new Node(0);
		Node tail = new Node(0);
		// Set to head and tail
		Node curr1 = head;
		Node curr2 = tail;

		while (nl != null) {
			// Keep on adding to the lists
			if (nl.data < x) {
				curr1.next = nl;
				curr1 = nl;
			} else {
				curr2.next = nl;
				curr2 = nl;

			}
			nl = nl.next;
		}
		// Closing down the tail
		curr2.next = null;
		curr1.next = tail.next;
		return head.next;
	}

}

// Linked List Class
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
		System.out.println(n.data);

	}
}
