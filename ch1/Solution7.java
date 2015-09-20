/*
This file: Solution7.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Homework1 - 7
Description: Rotate N*N matrix by 90 degrees , in place.
Assumptions:
Time Complexity: O(n2)
Space Complexity: O(n)
Last Modified: 9/20/2014 
 */
/*
 * clockwise rotate
 * first reverse up to down, then swap the symmetry 
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
*/
public class Solution7 {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		// original matrix
		System.out.println("Original matrix");
		printmatrix(matrix);
		int[][] rotatematrix = rotate(matrix);
		// matrix after rotation
		System.out.println("Rotated matrix");
		printmatrix(rotatematrix);
	}

	// helper function to print matrix
	public static void printmatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	public static int[][] rotate(int[][] matrix) {
		// First we reverse the matrix
		int[][] reversematrix = reverse(matrix);

		// Now perform symmetry swap
		for (int i = 0; i < reversematrix.length; i++) {
			for (int j = 0; j < i; j++) {

				int temp = reversematrix[i][j];
				reversematrix[i][j] = reversematrix[j][i];
				reversematrix[j][i] = temp;
			}
		}

		return reversematrix;
	}

	// Function to reverse
	// (0,0) => (3,0)
	public static int[][] reverse(int[][] matrix) {
		// Replace first and last row with each other
		for (int i = 0; i < matrix.length; i++) {
			int temp = matrix[0][i];
			matrix[0][i] = matrix[matrix.length - 1][i];
			matrix[matrix.length - 1][i] = temp;
		}
		return matrix;

	}
}
