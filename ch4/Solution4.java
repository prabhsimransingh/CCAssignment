/*
This file: Solution4.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter4 - 4
Description: Check if binary tree is balanced or not
Assumption: 
Time Complexity: O(N)
Space Complexity: O(H) height of the tree
Last Modified: 9/22/2014 
 */
package _44;


public class Solution4 {
	public static void main(String[] args) {
		// Positive test case
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		a.left = b;
		a.right = c;
		System.out.println(isBalanced(a));
		// Negative test case
		TreeNode a1 = new TreeNode(1);
		TreeNode b1 = new TreeNode(2);
		TreeNode c1 = new TreeNode(3);
		TreeNode d1 = new TreeNode(3);
		TreeNode e1 = new TreeNode(3);
		b1.left = a1;
		b1.right = c1;
		c1.left=d1;
		d1.left=e1;
		System.out.println(isBalanced(b1));

	}

	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return height(root) != -1;

	}

	public static int height(TreeNode node) {
		//height is zero
		if (node == null) {
			return 0;
		}
		int leftheight = height(node.left);
		if (leftheight == -1) {
			//Not balanced
			return -1;
		}
		int rightheight = height(node.right);
		if (rightheight == -1) {
			//Not balanced
			return -1;
		}
		if (leftheight - rightheight < -1 || leftheight - rightheight > 1) {
			return -1;
		}
		//Add recrusively
		return Math.max(leftheight, rightheight) + 1;
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
