
/*
This file: Solution8.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter6 - 8
Description: Egg Drop
Last Modified: 10/8/2015 
 */
// We can solve this by that if egg 1 starts at floor X, then we go up by X - 1 uptil 100
// X = X-1 + X-2 ....+1 = 100
// X= 13.65

public class Solution8 {
	public static int point_break = 17;
	public static int drop_count = 0;

	public static boolean isbreaking(int floor) {

		drop_count++;
		// if floor greater than point of break
		return floor >= point_break;
	}

	public static int findBreakingPoint(int floors) {
		int interval = 14;
		int previousFloor = 0;
		int egg1 = interval;

		// Drop egg1 at decreasing intervals.
		while (!isbreaking(egg1) && egg1 <= floors) {
			interval -= 1;
			previousFloor = egg1;
			egg1 += interval;
		}

		// Drop egg2 at 1 unit increments.
		int egg2 = previousFloor + 1;
		while (egg2 < egg1 && egg2 <= floors && !isbreaking(egg2)) {
			egg2 += 1;
		}

		// if doesnt break
		return egg2 > floors ? -1 : egg2;
	}
}
