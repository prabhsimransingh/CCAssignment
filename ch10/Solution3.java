
/*
This file: Solution3.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter10 - 3
Description: Given a sorted array that has been rotated, find an element in the array
Assumption: Array was originally sorted in ascending order
Time Complexity: O(logn)
Space Complexity: O(1)
Last Modified: 9/30/2015 
 */
public class Solution3 {
	public static void main(String[] args) {
		int key = 21;
		int[] a = { 3, 1 };

		System.out.print(search(a, 1));
	}

	public static int search(int[] nums, int target) {
		// find minimum element
		int low = 0;
		int high = nums.length - 1;
		int min = nums[low];
		int minpos = 0;
		while (low <= high) {
			if (nums[low] < min) {
				min = nums[low];
				minpos = low;

			} else {
				low++;
			}

		}

		// Binary search with rotation
		low = 0;
		high = nums.length - 1;
		int mid;
		int realmid;
		while (low <= high) {
			mid = (low + high) / 2;
			realmid = (mid + minpos) % (nums.length);
			if (nums[realmid] == target) {
				return realmid;

			} else if (nums[realmid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;

	}
}
