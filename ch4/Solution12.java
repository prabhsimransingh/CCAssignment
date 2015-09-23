/*
This file: Solution12.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter4-12
Description: Number of paths in a tree which lead to  target sum
Assumption: 
Time Complexity: O(NLOGN)
Last Modified: 9/23/2014 
 */
package _412;


public class Solution12 {
	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(3);
		TreeNode f = new TreeNode(3);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		d.left = f;
		//5 paths
		System.out.println(findPathSums(a, 3));
	}

	public static int findPathSums(TreeNode root, int targetSum) {
		if (root == null)
			return 0;

		// find path with sum starting from root
		int rootPaths = countPathsums(root, targetSum, 0);

		// Do the same for left and right subtree
		int leftPaths = findPathSums(root.left, targetSum);
		int rightPaths = findPathSums(root.right, targetSum);

		return rootPaths + leftPaths + rightPaths;
	}

	// Returns the number of paths with this sum
	public static int countPathsums(TreeNode node, int targetSum, int currentSum) {
		if (node == null)
			return 0;

		currentSum += node.val;

		int totalPaths = 0;
		if (currentSum == targetSum) {
			// One path found
			totalPaths++;
		}

		totalPaths += countPathsums(node.left, targetSum, currentSum);

		totalPaths += countPathsums(node.right, targetSum, currentSum);

		return totalPaths;
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
