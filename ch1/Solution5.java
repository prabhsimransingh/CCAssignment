/*
This file: Solution5.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Homework1 - 5
Description: Given two strings, check if they are one edit  (or zero edits) away
Assumptions: 1. Character set is ASCII ( 128 character set)
Time Complexity: O(n)
Space Complexity: O(1)
Last Modified: 9/20/2014 
 */

public class Solution5 {
	public static void main(String[] args) {
		String first = "pale";
		String second = "bake";
		// Create to char array
		char[] arr1 = first.toCharArray();
		char[] arr2 = second.toCharArray();
		// Assuming ASCII character set
		int[] arr3 = new int[128];
		int[] arr4 = new int[128];

		// Convert to int array represetation of ascii values
		for (char c : arr1) {
			int a = c;
			arr3[a] = arr3[a] + 1;
		}
		for (char c : arr2) {
			int b = c;
			arr4[b] = arr4[b] + 1;
		}
		// Compare both strings for differences
		int counter = 0;
		for (int i = 0; i <= arr3.length - 1; i++) {

			if (arr3[i] != arr4[i]) {
				counter++;
			}
		}
		// Check with length difference of more than 1
		if (Math.abs(first.length() - second.length()) > 1) {
			System.out.println("Not one edit away");
			System.exit(0);
		}
		// Check with length difference of 1
		if (Math.abs(first.length() - second.length()) == 1 && counter > 1) {
			System.out.println("Not one edit away");
			System.exit(0);
		}
		// Check with same length
		if (first.length() == second.length() && counter > 2) {
			System.out.println("Not one edit away");
			System.exit(0);
		}
		System.out.println("One Edit away");

	}
}
