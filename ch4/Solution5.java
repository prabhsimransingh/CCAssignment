/*
This file: Solution5.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter3 - 5
Description: Check if binary tree is a BST or not
Assumption: 
Time Complexity: O(n)
Space Complexity: O(logn) recursive calls on the stack
Last Modified: 9/22/2014 
 */

package _45;

public class Solution5 {
	public static void main(String[] args) {
		// Negative test case
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		a.left = b;
		a.right = c;
		System.out.println(isValidBST(a));
		// Positive test case
		TreeNode a1 = new TreeNode(1);
		TreeNode b1 = new TreeNode(2);
		TreeNode c1 = new TreeNode(3);
		b1.left = a1;
		b1.right = c1;
		System.out.println(isValidBST(b1));

	}

	public static boolean isValidBST(TreeNode root) {
		// Recursive call to method
		return validBST(root, null, null);
	}

	static boolean validBST(TreeNode n, Integer min, Integer max) {
		// If there is no node
		if (n == null) {
			return true;
		}
		// Check if BST condition is violated
		if ((min != null && n.val <= min) || (max != null && n.val >= max)) {
			return false;
		}
		// Recursively call the method with values
		if (!validBST(n.left, min, n.val) || !validBST(n.right, n.val, max)) {
			return false;
		}
		return true;
	}
}

// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
