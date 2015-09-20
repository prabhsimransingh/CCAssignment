/*
This file: Solution2.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Homework1 - 2
Description: Given two strings, write a method to decide if one is a permutation of the other
Assumptions: 1. Character set is ASCII ( 128 character set)
			2. permutation is case sensitive
			3. whitespace is significant
Time Complexity: O(n)
Space Complexity: O(1)
Last Modified: 9/20/2014 
 */

public class Solution2 {
	public static void main(String[] args) {
		// Input String 1
		String first = "abcdef";
		// Input String 2
		String second = "defabc";
		// Concatenated String
		String third = first.concat(second);
		// if the length is not equal it is not a permutation
		if (first.length() != second.length()) {
			System.out.println("Not a permutation");
			System.exit(0);
		}
		// ASCII character set
		int[] arr = new int[128];
		for (int i = 0; i <= third.length() - 1; i++) {
			// increase count for each character which occurs
			arr[(int) third.charAt(i)] = arr[(int) third.charAt(i)] + 1;
		}
		for (int i = 0; i <= arr.length - 1; i++) {
			// if character either occurs twice or 0 times it is a permutation
			// otherwise not
			if (arr[i] != 0 && arr[i] != 2) {
				System.out.println("Not a permutation");
				System.exit(0);
			}

		}
		System.out.println("is a permutation");

	}
}
