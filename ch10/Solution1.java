/*
This file: Solution1.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter10 - 1
Description: Given two sorted arrays . Write a method to merge B into A in sorted order.
Assumption: 1. A has a large enough buffer at the end to hold B.
Time Complexity: O(n)
Space Complexity: O(1)
Last Modified: 9/28/2015 
 */

import java.util.Arrays;

public class Solution1 {
	public static void main(String[] args) {
		int[] a = { 12, 23, 45, 54, 65, 0, 0, 0, 0, 0 };
		int[] b = { 1, 4, 89, 98, 110 };
		System.out.println(Arrays.toString(merge(a, 4, b, 4)));
	}

	public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
		//Calculate total size of merged array
		int total = m + n + 1;
		//Iterate through both arrays from the back comparing both numbers and put the larger
		// in the merged array
		while (n >= 0) {
			if (m >= 0 && nums1[m] > nums2[n]) {
				nums1[total] = nums1[m];
				m--;

			} else {
				nums1[total] = nums2[n];
				n--;

			}
			//reduce total counter
			total--;
		}
		return nums1;
	}
}
