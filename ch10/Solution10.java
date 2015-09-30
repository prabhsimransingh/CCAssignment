import java.util.Arrays;

/*
This file: Solution10.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter10 - 10
Description: Reading a stream of integers, tell rank of number x , elementss less than that number
Assumption:
Last Modified: 9/30/2015 
 */
public class Solution10 {
	private static Tree root = null;

	public static void track(int number) {
		if (root == null) {
			root = new Tree(number);
		} else {
			root.insert(number);
		}
	}

	public static int getRankOfNumber(int number) {
		return root.getRank(number);
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 98, 986, 67, 4, 7, 8, 9 };

		for (int i = 0; i < arr.length; i++) {
			track(arr[i]);
		}

		System.out.println("Array: " + Arrays.toString(arr));
		System.out.println("Array: " + (getRankOfNumber(8)));

	}

}

// Binary Tree Node
class Tree {
	int val;
	Tree left;
	Tree right;
	int size = 0;

	// Constructor
	Tree(int d) {
		val = d;
		size = 1;
	}

	public void insert(int d) {
		if (d <= val) {
			if (left != null) {
				left.insert(d);
			} else {
				left = new Tree(d);
			}
			size++;
		} else {
			if (right != null) {
				right.insert(d);
			} else {
				right = new Tree(d);
			}
		}
	}

	public int getRank(int d) {
		if (d == val) {
			return size;
		} else if (d < val) {
			if (left == null) {
				return -1;
			} else {
				return left.getRank(d);
			}
		} else {
			int right_rank = right == null ? -1 : right.getRank(d);
			if (right_rank == -1) {
				return -1;
			} else {
				return size + 1 + right_rank;
			}
		}
	}

}
