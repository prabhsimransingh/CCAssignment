/*
This file: Solution2.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter5 - 2
Description: Binary representation of doubl
Last Modified: 10/7/2015 
 */
public class Solution2 {
	public static void main(String[] args) {
		System.out.println(printBin(.125));
	//Solution 2 
		// we can compare the number to 1 and can compare to .5 to .25 and so on
	}

	//Solution 1
	public static String printBin(double n) {
		if (n >= 1 || n <= 0) {
			return "error";
		}

		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while (n > 0) {
			// If length greater than 32 give error
			if (binary.length() > 32) {
				return "error";
			}
			double r = n * 2;
			// cehck every digit
			//if r is greater than 1 we know that n had a 1 right after decimal
			if (r >= 1) {
				binary.append(1);
				n = r - 1;
			} else {
				binary.append(0);
				n = r;
			}
		}
		return binary.toString();
	}

}
