/*
This file: Solution9.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter4-9
Description: Given a Binary search tree, print all possible arrays that could have led 
			 to this tree
Assumption:  
Last Modified: 9/24/2014 
 */
package _49;

import java.util.ArrayList;
import java.util.LinkedList;
//Basically followed the algorithm in CTCI , couldnot wrap my head around the recursion.
public class Solution9 {
	// get all the lists together in all possible way
	public static void joinLists(LinkedList<Integer> first, LinkedList<Integer> second,
			ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {

		if (first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}

		// Remove the head first and add it again in first list
		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		joinLists(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);

		// Remove the head first and then add it again
		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		joinLists(first, second, results, prefix);
		prefix.removeLast();
		second.addFirst(headSecond);
	}

	public static ArrayList<LinkedList<Integer>> possibleSequences(TreeNode node) {
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();

		if (node == null) {
			result.add(new LinkedList<Integer>());
			return result;
		}

		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(node.val);

		// Recursion on left and right subtree
		ArrayList<LinkedList<Integer>> leftSeq = possibleSequences(node.left);
		ArrayList<LinkedList<Integer>> rightSeq = possibleSequences(node.right);

		//Join list from left and right side
		for (LinkedList<Integer> left : leftSeq) {
			for (LinkedList<Integer> right : rightSeq) {
				ArrayList<LinkedList<Integer>> joined = new ArrayList<LinkedList<Integer>>();
				joinLists(left, right, joined, prefix);
				result.addAll(joined);
			}
		}
		return result;
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
