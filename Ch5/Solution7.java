/*
This file: Solution7.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter5 - 7
Description: Number of bits you would need to flip to convert integer A to integer B
Last Modified: 10/8/2015 
 */
public class Solution7 {
	// we first mask all the odd bits first and then right shift by 1
	// we do a similar process with the even bits and then merge both the
	// results
	public static int swapOddEvenBits(int x) {
		return (((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1));
	}

	public static void main(String[] args) {
		System.out.println(swapOddEvenBits(2));
	}
}
