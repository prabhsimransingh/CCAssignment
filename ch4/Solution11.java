/*
This file: Solution11.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter4 - 11
Description: Binary Tree class which has getRandomNode() which returns a random node.
Assumption: 
Time Complexity: O(log N)
Last Modified: 9/22/2014 
 */
package _411;

import java.util.Random;

public class Solution11 {

}

class TreeNode {
	private int data;
	public TreeNode left;
	public TreeNode right;
	private int size = 0;

	public TreeNode(int d) {
		data = d;
		size = 1;
	}

	public int size() {
		return size;
	}

	public int data() {
		return data;
	}

	//Insertion in order in the tree to make it a BST
	public void insert(int d) {
		//If value is less than value in current node put it in left subtree 
		//otherwise right subtree recurisve call
		if (d < data) {
			if (left == null) {
				left = new TreeNode(d);
			} else {
				left.insert(d);
			}
		} else {
			if (right == null) {
				right = new TreeNode(d);
			} else {
				right.insert(d);
			}
		}
		size++;
	}

	public TreeNode find(int d) {
		//Find operation also iterates the tree the same way based on value
		if (d == data) {
			return this;
		} else if (d <= data) {
			return left != null ? left.find(d) : null;
		} else if (d > data) {
			return right != null ? right.find(d) : null;
		}
		return null;
	}

	public TreeNode getRandomNode() {
		//Get random node generates a random number till number of nodes in tree
		//and return a random node with each node having equal probability
		Random ran = new Random();
		int no = ran.nextInt(size);
		int leftsz = 0;
		if (left == null) {
			leftsz = 0;
		} else {
			leftsz = left.size();
		}
		if (no < leftsz) {
			return left.getRandomNode();
		} else if (no == leftsz) {
			return this;
		} else {
			return right.getRandomNode();
		}

	}
}
