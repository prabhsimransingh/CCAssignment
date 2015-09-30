
/*
This file: Solution7.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter10 - 7
Description: Given non negative integers , generate an that is not contained in the file
Assumption:
Last Modified: 9/30/2015 
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//implemented same algorithm from CTCI
public class Solution7 {
	public static long totalINTS = ((long) Integer.MAX_VALUE) + 1;
	public static byte[] bitfield = new byte[(int) (totalINTS / 8)];

	public static void findNo() throws FileNotFoundException {
		// Read from input file
		Scanner in = new Scanner(new FileReader("C:\\Users\\Prabhsimran\\newworkspace\\10_Sorting_Searching\\a.txt"));
		while (in.hasNextInt()) {
			int n = in.nextInt();
			///Find corresponding number in bit array by using the OR operator in the bit array
			bitfield[n / 8] |= 1 << (n % 8);
		}

		for (int i = 0; i < bitfield.length; i++) {
			for (int j = 0; j < 8; j++) {
				//get individual bits of each BYte. when 0 is found it prints out the value
				if ((bitfield[i] & (1 << j)) == 0) {
					System.out.println(i * 8 + j);
					return;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		findNo();
	}
}
