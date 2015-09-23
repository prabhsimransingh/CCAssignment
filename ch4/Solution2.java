/*
This file: Solution2.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter4 - 2
Description: Creating a binary search tree with minimal height
Assumption: 
Last Modified: 9/22/2014 
 */
package _42;

public class Solution2 {
	public static void main(String[] args) {
		int[] array = { 3, 4, 5, 6, 7, 8, 9 };

		Tree root = createMinimalBST(array);
		System.out.println("Root " + root.val);
		System.out.println("Height " + root.height());
	}

	private static Tree createMinimalBST(int arr[], int start, int end) {
		if (end < start) {
			return null;
		}
		
	//Recursive solution which calls the method with smaller sub tree
		//Middle element becomes root of this sub tree
		int mid = (start + end) / 2;
		Tree n = new Tree(arr[mid]);
		//Insert left subarray into left subtree
		n.setLeftChild(createMinimalBST(arr, start, mid - 1));
		//Insert right subarray into right subtree
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

	//Constructor
	Tree(int d) {
		val = d;
		size = 1;
	}

	//calculate height recursively adding one for each level
	public int height() {
		int leftHeight = left != null ? left.height() : 0;
		int rightHeight = right != null ? right.height() : 0;
		return 1 + Math.max(leftHeight, rightHeight);
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
