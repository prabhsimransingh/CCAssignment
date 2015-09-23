/*
This file: Solution6.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter4 - 6
Description: Find the next node ( in order successor of a given node in a binary search tree)
Assumption: Each node has a link to its parent
Time Complexity: O(n)
Last Modified: 9/23/2014 
 */
package _46;

public class Solution6 {
	public static void main(String[] args) {
		int[] array = { 3, 4, 5, 6, 7, 8, 9 };

		Tree root = createMinimalBST(array);
		Tree succ = successor(root);
		System.out.println(succ.val);
	}

	static Tree successor(Tree n) {
		// if the tree is empty return null
		if (n == null)
			return null;

		// if right children exist
		if (n.right != null) {
			// return leftmost child of right subtree
			return leftestChild(n.right);
		} else {
			// Go up on the tree
			Tree temp = n;
			Tree temp1 = temp.parent;
			while (temp1 != null && temp1.left != temp) {
				temp = temp1;
				temp1 = temp1.parent;
			}
			return temp1;
		}

	}

	// Return left most child
	public static Tree leftestChild(Tree n) {
		// if tree is null
		if (n == null) {
			return null;
		}
		// iterate through the left children
		while (n.left != null) {
			n = n.left;
		}
		return n;
	}

	private static Tree createMinimalBST(int arr[], int start, int end) {
		if (end < start) {
			return null;
		}

		// Recursive solution which calls the method with smaller sub tree
		// Middle element becomes root of this sub tree
		int mid = (start + end) / 2;
		Tree n = new Tree(arr[mid]);
		// Insert left subarray into left subtree
		n.setLeftChild(createMinimalBST(arr, start, mid - 1));
		// Insert right subarray into right subtree
		n.setRightChild(createMinimalBST(arr, mid + 1, end));
		return n;
	}

	public static Tree createMinimalBST(int array[]) {
		return createMinimalBST(array, 0, array.length - 1);
	}
}

// Binary Tree Node
class Tree {
	int val;
	Tree left;
	Tree right;
	Tree parent;
	int size = 0;

	// Constructor
	Tree(int d) {
		val = d;
		size = 1;
	}

	public void setLeftChild(Tree left) {
		this.left = left;
		if (left != null) {
			left.parent = this;
		}
	}

	public void setRightChild(Tree right) {
		this.right = right;
		if (right != null) {
			right.parent = this;
		}
	}

}
