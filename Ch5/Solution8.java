/*
This file: Solution8.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter5 - 8
Description: Implement a function which draws a horizontal line from (x1,y1) to )x2,y2)
Last Modified: 10/8/2015 
 */
// Essentially the same algorithm as implemented in CTCi
public class Solution8 {
	public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
		// as width is divisible by 8
		int strt_pos = x1 % 8;
		int ff_byte = x1 / 8;
		//
		if (strt_pos != 0) {
			ff_byte++;
		}

		int end_offset = x2 % 8;
		int lst_byte = x2 / 8;
		if (end_offset != 7) {
			lst_byte--;
		}

		// Set all the bytes
		for (int b = ff_byte; b <= lst_byte; b++) {
			screen[(width / 8) * y + b] = (byte) 0xFF;
		}

		// Creating mask for start and end of line
		byte start_mask = (byte) (0xFF >> strt_pos);
		byte end_mask = (byte) ~(0xFF >> (end_offset + 1));

		if ((x1 / 8) == (x2 / 8)) {
			//case when x1 and x2 are in the same byte
			byte mask = (byte) (start_mask & end_mask);
			screen[(width / 8) * y + (x1 / 8)] |= mask;
		} else {
			if (strt_pos != 0) {
				int byte_number = (width / 8) * y + ff_byte - 1;
				screen[byte_number] |= start_mask;
			}
			if (end_offset != 7) {
				int byte_number = (width / 8) * y + lst_byte + 1;
				screen[byte_number] |= end_mask;
			}
		}

	}

}
