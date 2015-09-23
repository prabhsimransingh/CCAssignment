/*
This file: Solution3.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter4 - 3
Description: Given a binary tree, create a linked list of all nodes at each level
Assumption: 
Time Complexity: O(N)
Space Complexity: O(N)
Last Modified: 9/22/2014 
 */
package _43;

import java.util.ArrayList;
import java.util.LinkedList;

//using BFS approach

public class Solution3 {
	public static ArrayList<LinkedList<Tree>> createLevelLinkedList(Tree root) {
		ArrayList<LinkedList<Tree>> result = new ArrayList<LinkedList<Tree>>();

		// Add the root element
		LinkedList<Tree> current = new LinkedList<Tree>();
		if (root != null) {
			current.add(root);
		}

		while (current.size() > 0) {
			// add lower level
			result.add(current);
			LinkedList<Tree> parents = current;
			// Move to the next level
			current = new LinkedList<Tree>();
			for (Tree parent : parents) {
				// See all the children
				if (parent.left != null) {
					current.add(parent.left);
				}
				if (parent.right != null) {
					current.add(parent.right);
				}
			}
		}

		return result;
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
}
