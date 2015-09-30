
/*
This file: Solution8.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter10 - 7
Description:Given an array with all numbers from 1 to N Print all duplicate entries
Assumption: N can be atmost 32,000
Last Modified: 9/30/2015 
 */
import java.util.Arrays;

//Followed the same algorithm as in CTCI
public class Solution8 {
	public static void findDuplicates(int[] array) {
		// use bit array to represent each bit
		Bits bs = new Bits(32000);
		for (int i = 0; i < array.length; i++) {
			int num = array[i];
			int num0 = num - 1;
			// if bit is already present print it.
			if (bs.get(num0)) {
				System.out.println(num);
			} else {
				bs.set(num0);
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 90, 12, 129, 18, 928, 928, 67, 89, 9876, 9875, 98, 977, 9867, 9654 };
		System.out.println(Arrays.toString(array));
		// print duplicate values
		findDuplicates(array);
	}
}

// Class used to store numbers represented by bits
class Bits {
	int[] bits;

	public Bits(int size) {
		// divide by 32
		bits = new int[(size >> 5) + 1];

	}

	boolean get(int pos) {
		// divide by 32
		int wordNumber = (pos >> 5);
		// mod 32
		int bitNumber = (pos & 0x1F);
		return (bits[wordNumber] & (1 << bitNumber)) != 0;
	}

	void set(int pos) {
		// divide by 32
		int wordNumber = (pos >> 5);
		// mod 32
		int bitNumber = (pos & 0x1F);
		bits[wordNumber] |= 1 << bitNumber;
	}
}
