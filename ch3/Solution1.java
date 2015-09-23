
/*
This file: Solution1.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter3 - 1
Description: Use single array to implement 3 stacks
Assumption: 
Last Modified: 9/23/2014 
 */
import java.util.EmptyStackException;

class Solution1 {
	private int stackCapacity;
	private int[] values;
	private int[] sizes;

	public Solution1(int stackSize) {
		stackCapacity = stackSize;
		values = new int[stackSize * 3];
		sizes = new int[3];
	}

	// Check if stack is full
	public boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}

	// check if stack is empty.
	public boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}

	// Returns index of the top of the stack.
	private int indexOfTop(int stackNum) {
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size - 1;
	}

	// Push a value on the stack
	public void push(int stackNum, int value) throws Exception {
		// check if we have space
		if (isFull(stackNum)) {
			throw new Exception();
		}

		// update the value at the top of the stack
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
	}

	// Pop item from top of stack.
	public int pop(int stackNum) {
		if (isEmpty(stackNum)) {
			throw new EmptyStackException();
		}

		int topIndex = indexOfTop(stackNum);

		int value = values[topIndex];

		values[topIndex] = 0;
		// Decrease size
		sizes[stackNum]--;
		return value;
	}

	// Return element at top of stack
	public int peek(int stackNum) {
		if (isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		return values[indexOfTop(stackNum)];
	}

	public int[] getValues() {
		return values;
	}
}
