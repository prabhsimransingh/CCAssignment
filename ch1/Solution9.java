/*
This file: Solution9.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Homework1 - 9
Description: Check if string is a rotation of another string with one call to isSubstring method.
Assumptions: 
Time Complexity: O(n)
Space Complexity: O(1) 
Last Modified: 9/20/2014 
 */

public class Solution9 {
	public static void main(String[] args) {
		System.out.println(checkRot("waterbottle", "bottlewater"));
	}

	public static boolean checkRot(String s1, String s2) {
		// if we concatenate both the strings then it must contain the second
		// string for
		// it to be a rotation of the first.
		String conc = "";
		if (s1.length() == s2.length() && s1.length() > 0) {
			conc = s1 + s1;
		}
		return conc.contains(s2);
	}
}
