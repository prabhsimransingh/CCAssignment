/*
This file: Solution8.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter2 - 8
Description: Given a circular linked list, implement an algorithm that returns the node
			 at the beginning of the circular list.
Assumption: 
Time Complexity: 
Space Complexity: 
Last Modified: 9/20/2014 
 */

package _28;

public class Solution8 {
	public static void main(String[] args) {

		Node n0 = new Node(1);
		Node n1 = new Node(2);
		Node n2 = new Node(3);
		Node n3 = new Node(4);
		Node n4 = new Node(5);

		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n2;

		// List 1->2->3->4->3->4
		findloop(n0);
	}

	public static void findloop(Node n) {
		Node fp = n;
		Node sp = n;
		// finding point of collision
		while (fp != null && fp.next != null) {

			fp = fp.next.next;
			sp = sp.next;
			if (fp == sp)
				break;
		}
		if (fp == null || fp.next == null) {
			System.out.println("No meeting point");
		}
		// Both the slow and start will meet at the start of the loop
		sp = n;
		while (fp != sp) {
			fp = fp.next;
			sp = sp.next;
		}
		// print start of loop
		System.out.println("The start of the circular linked list");
		System.out.println(fp.data);
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
