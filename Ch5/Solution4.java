/*
This file: Solution4.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter5 - 4
Description: Given a positive integer , print the next smallest and next largest number that have
				the same number of 1 bits in there binary representation
Last Modified: 10/8/2015 
 */
// Solution 1 - Using brute force convert the rightnost non trailing zero to 1 to find the next one
//Solution 2 - Arithemtic approach
public class Solution4 {
	public static int getNextArith(int n) {
		int c = n;
		int c_prev = 0;
		int c_next = 0;

		// Set trailing
		while (((c & 1) == 0) && (c != 0)) {
			c_prev++;
			c >>= 1;
		}

		while ((c & 1) == 1) {
			c_next++;
			c >>= 1;
		}

		// If c is 0, the number is a set of 1's followed by 0's
		// This is already the biggest number with c_next ones. Returns -1
		if (c_prev + c_next == 31 || c_prev + c_next == 0) {
			return -1;
		}

		return n + (1 << c_prev) + (1 << (c_next - 1)) - 1;
	}

	public static int getPrevArith(int n) {
		int temp = n;
		int c_prev = 0;
		int c_next = 0;
		while (((temp & 1) == 1) && (temp != 0)) {
			c_next++;
			temp >>= 1;
		}

		// if temp is 0 then this a set of 0's followed by 1 's so it is already
		// smallest number
		if (temp == 0) {
			return -1;
		}

		while ((temp & 1) == 0 && (temp != 0)) {
			c_prev++;
			temp >>= 1;
		}

		return n - (1 << c_next) - (1 << (c_prev - 1)) + 1;
	}
}
