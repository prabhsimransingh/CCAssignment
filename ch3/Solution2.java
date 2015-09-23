/*
This file: Solution2.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter3 - 2
Description: Stack with a function min which returns the minimum element
Assumption: 
Last Modified: 9/22/2014 
 */

package _32;

import java.util.EmptyStackException;
//using additional stack to take care of the mins
public class Solution2 extends Stack<Integer> {
	Stack<Integer> mins;

	public Solution2()
	{
		mins=new Stack<Integer>();
	}

	public void push(int val) {
		if (val <= min()) {
			mins.push(val);
		}
		super.push(val);
	}

	public Integer pop() {
		int val = super.pop();
		if (val == min()) {
			mins.pop();
		}
		return val;
	}
	//min function is called on each pop and push and stores min values
	public int min() {
		if (mins.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return mins.peek();
		}
	}

	public static void main(String[] args) {
		Solution2 stack = new Solution2();
		stack.push(2);
		stack.push(2);
		stack.push(3);
		stack.push(-1);
		stack.push(0);
		System.out.println(stack.min());

	}

}
//Normal stack class
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
