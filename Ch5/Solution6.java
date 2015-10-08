/*
This file: Solution6.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter5 - 6
Description: Number of bits you would need to flip to convert integer A to integer B
Last Modified: 10/7/2015 
 */
public class Solution6 {
	// Solution 1 - we can simply XOR both numbers and check which bits are 1
	// those will be the bits required to change

	// Solution 2 - Continuously flip the least significant bit and count how
	// long it takes c to reach 0
	public static void main(String[] args) {
		// input 29 (11101) and 15 (01111)
		// output is 2
		System.out.println(noswaps(29, 15));
	}

	public static int noswaps(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c & (c - 1)) {
			count++;
		}
		return count;
	}

}
