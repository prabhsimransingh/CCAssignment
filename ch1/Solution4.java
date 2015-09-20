/*
This file: Solution4.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Homework1 - 4
Description: Check if string is permutation of a palindrome
Assumptions: 1. Character set is ASCII ( 128 character set)
Time Complexity: O(n)
Space Complexity: O(1)
Last Modified: 9/20/2014 
 */

public class Solution4 {
	public static void main(String[] args) {
		String input = "Tacdcat";
		// Remove all spaces
		input = input.toLowerCase().replaceAll(" ", "");
		// Make an array of 128 ASCII character set
		int[] chrs = new int[128];
		// Convert to char array
		char[] arr = input.toCharArray();

		for (char a : arr) {
			int b = a;
			chrs[b] = chrs[b] + 1;
		}

		for (int i = 0; i <= chrs.length - 1; i++) {
			// Check if even number of characters then all characters should
			// repeat
			if (input.length() % 2 == 0) {
				// check if character appears more than 2 times or not at all
				if (chrs[i] != 0 && chrs[i] != 2) {

					System.out.println("Not a palindrome perm");
					System.exit(0);
				}
			}
			// For Odd
			else {
				int counter = 0;
				if (chrs[i] == 1) {
					counter++;
					if (counter > 1) {
						System.out.println("Not a palindrome perm");
						System.exit(0);
					}
				}
				// check if chr appears 0 or twice or once otherwise it is not a
				// palindrome
				// permutation
				if (chrs[i] != 0 && chrs[i] != 2 && chrs[i] != 1) {

					System.out.println("Not a palindrome perm");
					System.exit(0);
				}
			}
		}
		System.out.println("Is a palindrome perm");

	}
}
