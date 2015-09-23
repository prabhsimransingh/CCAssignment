/*
This file: Solution8.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter4 - 8
Description: Find first common ancestor of two nodes in a binary tree
Assumption: 
Last Modified: 9/22/2014 
 */
package _48;

//Recurse through entire tree
public class Solution8 {
	TreeNode firstCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root == p || root == q) {
			return root;
		}
		TreeNode a = firstCommonAncestor(root.left, p, q);
		TreeNode b = firstCommonAncestor(root.right, p, q);

		if (a != null && b != null) {
			return root;
		}
		//Returns p if roots subtree includes p and not q
		if (a != null) {
			return a;
		}
		if (b != null) {
			return b;
		}
		//Return null if neither p and q are in roots subtree
		return a == null ? b : a;
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
