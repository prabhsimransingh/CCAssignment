/*
This file: Solution3.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Homework1 - 3
Description: Replace all spaces in a string with '%20'
Assumptions: 1. True length of string is given
			2. String has sufficient space at the end
Time Complexity: O(n)
Space Complexity: O(n)
Last Modified: 9/20/2014 
 */

public class Solution3 {
	public static void main(String[] args) {
		System.out.println(urlify("Mr John Smith    ",13));
	}
	public static String urlify(String inp,int len)
	{
		//Use string builder to concatenate char one by one
		StringBuilder op =new StringBuilder();
		for(int i=0;i<=len-1;i++)
		{
			//Wherever you find space replace it by %20 
			if(inp.charAt(i)!=' ')
			op.append(inp.charAt(i));
			else
				op.append("%20");
		}
		return op.toString();
	}
}
