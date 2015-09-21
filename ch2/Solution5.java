/*
This file: Solution5.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter2 - 5
Description: Function adds two linked list , and return the sum as a linked list
Assumption: 
Time Complexity: O(n)
Space Complexity: O(n)
Last Modified: 9/20/2014 
 */
package _25;

import java.util.ArrayList;

public class Solution5 {
	public static void main(String[] args) {

		Node n0 = new Node(7);
		Node n1 = new Node(1);
		Node n2 = new Node(7);
		Node n3 = new Node(5);
		Node n4 = new Node(9);
		Node n5 = new Node(2);
		Node n6 = new Node(1);
		n0.next = n1;
		n1.next = n2;

		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		// Print Original list
		System.out.println("Input List");
		n0.PrintList();
		n3.PrintList();
		// Print List after summing
		System.out.println("\nAfter Summing");
		SumLists(n0, n3).PrintList();

	}

	public static Node SumLists(Node n1, Node n2) {
		// Kept array list to keep number
		ArrayList<Integer> a = new ArrayList<Integer>();
		Node n3 = new Node();
		Node res = n3;
		int carry = 0;
		int val = 0;
		// iterate and add values
		while (n1 != null && n2 != null) {
			if (n1.data + n2.data + carry >= 10) {

				val = (n1.data + n2.data + carry) % 10;
				carry = 1;
			} else {
				val = n1.data + n2.data + carry;
				carry = 0;

			}

			a.add(val);

			n1 = n1.next;
			n2 = n2.next;
		}
		// In case of unequal lengths
		if (n1 != null) {

			a.add((n1.data + carry) % 10);
			if ((n1.data + carry) >= 10) {
				carry = 1;
			} else {
				carry = 0;
			}
		}
		if (n2 != null) {

			a.add((n2.data + carry) % 10);
			if ((n2.data + carry) >= 10) {
				carry = 1;
			} else {
				carry = 0;
			}
		}
		// add the carry along
		if (carry != 0) {
			a.add(carry);
		}
		for (int c : a) {

			n3.next = new Node(c);
			n3 = n3.next;
		}
		return res.next;
	}
}

// Linked List class
class Node {
	Node next = null;
	int data;

	public Node() {

	}

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
