/*
This file: Solution10.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter4 - 10
Description: Check if T2 is a subtree of T1
Assumption: 
Time Complexity: O(nm)
Space Complexity: O(log(n)+m)
Last Modified: 9/22/2014 
 */

package _410;


public class Solution10 {
	public static void main(String[] args) {
		
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		a.left = b;
		a.right = c;
		
		// Positive test case
		TreeNode a1 = new TreeNode(1);
		TreeNode b1 = new TreeNode(2);
		TreeNode c1 = new TreeNode(3);
		TreeNode d1 = new TreeNode(2);
		TreeNode e1 = new TreeNode(3);
		b1.left = a1;
		b1.right = c1;
		a1.left=d1;
		a1.right=e1;
		//Prints true 
		System.out.println(hasTree(b1,a));
	}

	static boolean hasTree(TreeNode t1, TreeNode t2) {
		if (t2 == null) {
			return true;
		}
		return subTree(t1, t2);
	}

	// Check if tree tr2 is subtree of tr1.
	public static boolean subTree(TreeNode tr1, TreeNode tr2) {
		// if big tree is empty then return null
		if (tr1 == null) {
			return false;
		} else if (tr1.val == tr2.val && matchTree(tr1, tr2)) {
			return true;
		}
		return subTree(tr1.left, tr2) || subTree(tr1.right, tr2);
	}

	public static boolean matchTree(TreeNode r1, TreeNode r2) {
		if (r1 == null && r2 == null) {
			return true; // both trees are empty
		} else if (r1 == null || r2 == null) {
			return false; // One tree is empty so not a subtree
		} else if (r1.val != r2.val) {
			return false; // values dont match
		} else {
			// recursively call
			return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
		}
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
