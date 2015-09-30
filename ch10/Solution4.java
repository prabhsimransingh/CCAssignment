
/*
This file: Solution4.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter10 - 4
Description: Given a sorted array Listy ,find element at which x occurs
Assumption: 
Time Complexity: O(logn)
Space Complexity: O(1)
Last Modified: 9/30/2015 
 */
public class Solution4 {
	// Modified
	public static int binarySearch(newArray list, int key) {
		int lower = 0;
		int index = 0;
		//Modify length function
		while (list.elementAt(index) !=-1) {
			index = index + 1;
		}
		int upper = index;
		int mid;
		//Nomral binary search
		while (true) {
			if (lower > upper)
				return -1;
			mid = lower + (upper - lower) / 2;
			if (list.elementAt(mid) == key) {
				return mid;
			} else {
				if (list.elementAt(mid) < key) {
					lower = mid + 1;
				} else {
					upper = mid - 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 8, 9, 78, 90, 96 };
		newArray list = new newArray(array);
		System.out.println(binarySearch(list, 90));
		System.out.println(binarySearch(list, 15));
	}
}

// Listy data structure
class newArray {
	int[] array;
	//Returns -1 if element not present
	public int elementAt(int index) {
		if (index >= array.length) {
			return -1;
		}
		return array[index];
	}

	public newArray(int[] arr) {
		array = arr.clone();
	}

}
