
/*
This file: Solution2.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter10 - 2
Description: Sort an array of Strings so that all the anagrams are next to each other.
Assumption: All strings are lowercase
Last Modified: 9/28/2015 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution2 {
	public static void main(String[] args) {
		String[] input = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(groupAnagrams(input));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {

		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		// Iterate through all string in the array
		for (String str : strs) {
			// If key already exsists add anagrams for it
			if (map.containsKey(sortChars(str))) {
				ArrayList<String> ss = map.get(sortChars(str));
				ss.add(str);
				// Sort list of strings
				Collections.sort(ss);
			} else {
				// otherwise create new Arraylist and add to hash map
				ArrayList<String> ss = new ArrayList<String>();
				ss.add(str);

				map.put(sortChars(str), ss);
			}
		}
		ArrayList<List<String>> ls = new ArrayList<List<String>>();
		ls.addAll(map.values());

		return ls;
	}

	// Method to sort characters in a string to use as key
	public static String sortChars(String s) {
		char[] chrs = s.toCharArray();
		Arrays.sort(chrs);
		return new String(chrs);
	}

}
