/*
This file: Solution6.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter2 - 
Description: Check if a linked list is a Palindrome
Assumption: 
Last Modified: 9/20/2014 
 */

package _26;

public class Solution6 {
	public static void main(String[] args) {

		Node n0 = new Node(7);
		Node n1 = new Node(1);
		Node n2 = new Node(6);
		Node n3 = new Node(6);
		Node n4 = new Node(1);
		Node n5 = new Node(7);
		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		// Print Original list
		System.out.println("Input List");
		n0.PrintList();
		// Print List after delete
		System.out.println("\nChecking for palindrome");
		System.out.println(checkPalindrome(n0));

	}

	public static boolean checkPalindrome(Node nl) {
		// to check palindrome we are reversing the list
		if (nl == null)
			return true;

		Node n = nl;
		Node pre = new Node(n.data);

		// list reversal
		while (n.next != null) {
			Node temp = new Node(n.next.data);
			temp.next = pre;
			pre = temp;
			n = n.next;
		}

		Node p1 = nl;
		Node p2 = pre;

		// Then comparing the two
		while (p1 != null) {
			if (p1.data != p2.data)
				return false;

			p1 = p1.next;
			p2 = p2.next;
		}

		return true;
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
		System.out.print(n.data);
	}
}
