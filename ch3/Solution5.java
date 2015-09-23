/*
This file: Solution5.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter3 - 5
Description: Sort a stack so that smallest items are on top
Assumption: Cannot use additional data structure except a temporary stack.
Time Complexity: O(N2)
Space Complexity: O(N)
Last Modified: 9/23/2014 
 */

package _35;

import java.util.EmptyStackException;

public class Solution5 {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(5);
		s.push(10);
		s.push(7);
		s.push(9);

		Stack<Integer> r = sort(s);
		//Print sorted stack
		while (!r.isEmpty()) {
			System.out.println(r.pop());
		}
	}

	static Stack<Integer> sort(Stack<Integer> ip) {
		Stack<Integer> tempStack = new Stack<Integer>();
		while (!ip.isEmpty()) {
			// Pop the top most element in original stack
			int temp = ip.pop();
			while (!tempStack.isEmpty() && tempStack.peek() > temp) {
				// Push to original stack only when right position is reached
				ip.push(tempStack.pop());
			}
			// Push onto temp stack
			tempStack.push(temp);
		}
		return tempStack;

	}
}

// Stack class
class Stack<T> {
	private static class StackNode<T> {
		private T data;
		private StackNode<T> next;

		public StackNode(T data) {
			this.data = data;
		}
	}

	private StackNode<T> top;

	public T pop() {
		if (top == null)
			throw new EmptyStackException();

		T item = top.data;
		top = top.next;
		return item;

	}

	public void push(T item) {
		StackNode<T> t = new StackNode<T>(item);
		t.next = top;
		top = t;
	}

	public T peek() {
		if (top == null)
			throw new EmptyStackException();
		return top.data;
	}

	public boolean isEmpty() {
		return top == null;
	}
}
