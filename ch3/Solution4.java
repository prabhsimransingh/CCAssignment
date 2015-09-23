/*
This file: Solution4.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter3 - 4
Description: Implementation of queue using two stacks
Assumption: 
Last Modified: 9/22/2014 
 */
package _34;

import java.util.EmptyStackException;

public class Solution4 {

}

class MyQueue {
	//stack 1 keeps newest and stack 2 oldest elements
	Stack<Integer> s1 = new Stack();
	Stack<Integer> s2 = new Stack();
	

	public void push(int x) {
		s1.push(x);
	}

	public void pop() {
		peek();
		s2.pop();
	}

	public int peek() {
		if (s2.isEmpty())
			while (!s1.isEmpty())
				s2.push(s1.pop());
		return s2.peek();
	}

	public boolean empty() {
		return s1.isEmpty() && s2.isEmpty();
	}
}

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
