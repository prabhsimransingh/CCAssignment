/*
This file: Solution9.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter10 - 9
Description: Given a M*N matrix sorted in ascending order , weite method to find an element.
Assumption:
Time Complexity: O(logn)
Space Complexity: O(1)
Last Modified: 9/30/2015 
 */

public class Solution9 {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 3 }, { 2, 4 } };
		System.out.println(searchMatrix(matrix,3));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		//Go through first row element compare and then proceed accordingly
		int r = 0;
		int c = matrix[0].length - 1;
		while (r < matrix.length && c >= 0) {
			if (matrix[r][c] == target) {
				return true;
			} else if (matrix[r][c] > target) {
				c--;
			} else {
				r++;
			}
		}
		return false;
	}
}
