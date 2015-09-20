/*
This file: Solution6.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Homework1 - 6
Description: Given a string, implement basic string compression
Assumptions: 1. Character set is ASCII ( 128 character set)
			 2. String has only upper and lowercase letters (a-z)
Time Complexity: O(n)
Space Complexity: O(n)
Last Modified: 9/20/2014 
 */

public class Solution6 {
	public static void main(String[] args) {
		// Input String
		String input = "abbbbcccddd";
		int counter = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length() - 1; i++) {
			// If character matches previous character
			if (input.charAt(i) == input.charAt(i + 1)) {
				counter = counter + 1;
			} else {
				// If character does not match next one print character and
				// count

				sb.append(input.charAt(i));
				sb.append(counter);

				counter = 1;
			}
		}
		// For last character
		sb.append(input.charAt(input.length() - 1));
		sb.append(counter);
		String compstr = sb.toString();
		// If length of compressed string is less than input string
		if (compstr.length() >= input.length()) {
			System.out.println(input);

		} else {
			System.out.println(compstr);
		}
	}
}
