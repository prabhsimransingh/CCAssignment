/*
This file: Solution3.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter5 - 3
Description: Longest sequence of 1's
Last Modified: 10/7/2015 
 */
public class Solution3 {
	// Solution 1 - Brute force approach
	// flip each bit and see when longest sequence is formed

	// Solution 2 - Find the best pair of adjacent sequence we can join

	// Solution 3 - We can reduce space usage by storing the length of the
	// immediately surrounding sequences
	// Solution 4 - found algorithm online improved solution
	public static int flipBit(int num) {
		// If all 1s, this is already the longest sequence.
		if (~num == 0)
			return Integer.SIZE;

		int curLen = 0;
		int prevLen = 0;
		// If all 0's max length of sequence can be 1
		int maxLen = 1;
		while (num != 0) {
			if ((num & 1) == 1) {
				// Increment current length while bit is 1
				curLen++;
			} else if ((num & 1) == 0) {

				// set previous length to 0 if bit is 0
				// or set it to current length if next bit is 1
				if ((num & 2) == 0) {
					prevLen = 0;
				} else {
					prevLen = curLen;
				}
				curLen = 0;
			}
			maxLen = Math.max(prevLen + curLen + 1, maxLen);
			num >>>= 1;
		}
		return maxLen;
	}

	public static void main(String[] args) {
		// Test case input is 1775
		//output is 8
		System.out.println(flipBit(1775));
	}

}
