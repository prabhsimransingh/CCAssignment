/*
This file: Solution1.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter5 - 1
Description: Insert M into n at specific position
Last Modified: 10/7/2015 
 */
public class Solution1 {
	public static void main(String[] args) {
		//n = 10000000000 - 1024
		//m = 19 - 10011
		//i=2
		//j=6
		//Output N = 10001001100
		System.out.println(Insertion(1024, 19, 6, 2));
	}

	static int Insertion(int m, int n, int j, int i) {
		if (j < i)
			return 0;

		// Clear bits from i to j in N
		int left = 1 << (j + 1);

		int right = ((1 << i) - 1);

		int mask = left | right;

		int clear_n = n & mask;

		// Shift m to correct position
		int shift_m = m << i;

		// merge M and N
		return clear_n | shift_m;

	}
}
