
/*
This file: Solution5.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter10 - 2
Description: In a sorted array of string interspersed, find location of given string
Assumption:
Time Complexity: O(logn)
Space Complexity: O(1)
Last Modified: 9/28/2015 
 */
public class Solution5 {
	public static void main(String[] args) {

		String[] a = { "12", "", "13", "", "21", "", "", "34", "56", "88", "98" };
		System.out.print(binarySearch(a, "21"));
	}

	public static int binarySearch(String[] data, String key) {
		int lower = 0;
		int upper = data.length - 1;
		int mid;
		//Binary search takin care of empty string by searching closest valid string
		while (true) {
			if (lower > upper)
				return -1;
			mid = lower + (upper - lower) / 2;
			if (data[mid].isEmpty()) {
				int counter1 = 1;
				int counter2 = 1;
				int counter3 = 1;
				while (data[mid].isEmpty()) {
					if (counter3 % 2 == 0) {
						mid = mid + counter1;
						counter1++;
						lower = lower + 1;
					} else {
						mid = mid - counter2;
						counter2++;
						upper = upper - 1;
					}
					counter3 = counter3 + 1;
				}
			} else {
				if (data[mid].equals(key)) {
					return mid;
				} else {
					if (data[mid].compareTo(key) < 0) {
						lower = mid + 1;
					} else {
						upper = mid - 1;
					}
				}
			}
		}
	}
}
