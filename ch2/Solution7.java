/*
This file: Solution7.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter2 - 7
Description: Given two linked lists , determine is the two lists intersect 
			 and return the intersected list.
Assumption: 
Time Complexity: O(A+B) - > A & B are length of the lists
Space Complexity: O(1)
Last Modified: 9/20/2014 
 */
package _27;

public class Solution7 {
	public static void main(String[] args) {

		Node n0 = new Node(1);
		Node n1 = new Node(2);
		Node n2 = new Node(3);
		Node n3 = new Node(1);
		Node n4 = new Node(3);
		Node n5 = new Node(4);

		n0.next = n1;
		n1.next = n2;

		n3.next = n4;
		n4.next = n5;
		n5.next = n1;
		// Print Original list
		System.out.println("Input List 1");
		n0.PrintList();
		System.out.println("Input List 2");
		n3.PrintList();
		FindIntersection(n0, n3);
	}

	public static void FindIntersection(Node n1, Node n2) {

		// Check length and if end node is same
		int length1 = 0;
		int length2 = 0;
		Node nl1 = n1;
		Node nl2 = n2;
		while (nl1.next != null) {
			length1++;
			nl1 = nl1.next;
		}
		while (nl2.next != null) {
			length2++;
			nl2 = nl2.next;
		}
		// if end node is not same by reference there is no intersection
		if (nl1 != nl2) {
			System.out.println("There is no Intersection");
			System.exit(0);
		}
		// Start two pointers, for longer linked list at difference of length
		int diffLength = Math.abs(length1 - length2);
		Node longer = null;
		Node shorter = null;
		// make both linked list of same size by chopping off the longer one
		if (length1 > length2) {
			longer = n1;
			shorter = n2;
			for (int i = 0; i < diffLength; i++) {
				longer = longer.next;
			}

		} else {

			longer = n2;
			shorter = n1;
			for (int i = 0; i < diffLength; i++) {
				longer = longer.next;
			}
		}
		// iterate till common node is found
		while (longer != shorter) {

			shorter = shorter.next;
			longer = longer.next;
		}
		System.out.println("Intersected List");
		shorter.PrintList();

	}
}
//Linked List Class
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

