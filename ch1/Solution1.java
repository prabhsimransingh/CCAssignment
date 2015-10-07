/*
This file: Solution1.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Homework1 - 1
Description: Algorithm to determine if a string has all unique characters
Assumption: Character set is ASCII ( 128 character set)
Time Complexity: O(n)
Space Complexity: O(1)
Last Modified: 9/20/2014 
 */

public class Solution1 {

	public static void main(String[] args) {
		// Input String
		String test = "abcdee";
		System.out.println(checkUnique(test));
		// If character length is greater than 128 than it cannot be unique
		if (test.length() > 128) {
			System.out.println("Repeating characters");
			System.exit(0);
		}
		// Character array for 128 char set
		char[] array = new char[128];
		// Iterate through the string char by char
		for (int i = 0; i <= test.length() - 1; i++) {
			// Use the char array with a flag to check repetition
			if (array[(int) test.charAt(i)] == 1) {
				System.out.println("Repeating characters");
				System.exit(0);
				;
			} else {
				array[(int) test.charAt(i)] = 1;
			}
		}
		System.out.println("No Repeating Characters");

	}

	// Solution 2 - to save space we make the use of a bit vector
	public static boolean checkUnique(String str) {

		int checker = 0;
		//int bit vector where each bit represents a character
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val);
		}
		return true;

	}

}
