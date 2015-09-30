
/*
This file: Solution11.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter10 - 11
Description: Given an array of integers sort the array into alternating sequences of peaks and valley
Assumption:
Time Complexity: O(n)
Last Modified: 9/30/2015 
 */

import java.util.Arrays;

//Implemented the CTCI algorithm
public class Solution11 {
	// Used to swap in an array
	public static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static void valleypeak(int[] arr) {
		// Check for valley and peak otherwise swap
		for (int i = 1; i < arr.length; i = i + 2) {
			//if previous element is lesser swap
			if (arr[i - 1] < arr[i]) {
				swap(arr, i - 1, i);
			}
			if (i + 1 < arr.length && arr[i + 1] < arr[i]) {
				swap(arr, i + 1, i);
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 12, 98, 28, 90, 87, 67, 56 };
		System.out.println(Arrays.toString(array));
		valleypeak(array);
		System.out.println(Arrays.toString(array));

	}
}
