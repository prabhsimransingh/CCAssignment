/*
This file: Solution8.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Homework1 - 8
Description: If an element in a N*M matrix is 0, its entire row and column are set to 0.
Assumptions:
Time Complexity: O(n2)
Space Complexity: O(1) - using first row and first column to check for zero rows & columns
Last Modified: 9/20/2014 
 */

public class Solution8 {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 0, 11, 12 }, { 13, 14, 15, 16 } };
		// original matrix
		System.out.println("Original matrix");
		printmatrix(matrix);
		int[][] op = matrixZero(matrix);
		// matrix after operation
		System.out.println("Zero matrix");
		printmatrix(op);
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

	public static int[][] matrixZero(int[][] matrix) {
		boolean rowzero = false;
		boolean columnzero = false;

		// check if first row, first column has zero
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[0][i] == 0) {
				rowzero = true;
			}
			if (matrix[i][0] == 0) {
				columnzero = true;
			}
		}
		// checking for zero in rest of array
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix.length; j++) {
				if (matrix[i][j] == 0) {

					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		// Null the rows based on first columns
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 0; j < matrix[0].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		// Null the columns based on first row
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[0][i] == 0) {
				for (int j = 0; j < matrix.length; j++) {
					matrix[j][i] = 0;
				}
			}
		}

		// Nullify the first row and column
		if (rowzero) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}
		if (columnzero) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[j][0] = 0;
			}
		}
		return matrix;
	}
}
