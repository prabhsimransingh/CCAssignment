/*
This file: Solution3.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter3 - 3
Description: Implement a set of stacks ( like a stack of plates)
Assumption: 
Last Modified: 9/22/2014 
 */
package _33;

import java.util.ArrayList;
import java.util.EmptyStackException;


public class Solution3 {

}

class StackCollection {
	// use Array list
	ArrayList<Stack> set = new ArrayList<Stack>();
	//set capacity of stack
	int counter = 0, capacity = 3;
	
	Stack<Integer> stack;

	void push(int i) {
		//Add a new stack if stack is at capacity
		if (counter == capacity || counter == 0) {
			counter = 0;
			stack = new Stack<>();
			set.add(stack);
		}
		stack.push(i);
		counter++;
	}

	int pop() {
		//Pop an element from corresponding stack
		if (counter == 1) {
			counter = capacity;
		} else
			counter--;
		return (Integer) set.get(set.size() - 1).pop();
	}
}

// Normal stack class
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
