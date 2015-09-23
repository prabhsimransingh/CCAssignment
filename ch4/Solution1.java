/*
This file: Solution1.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter4 - 1
Description: Route between nodes in a directed graph
Assumption: 
Last Modified: 9/23/2014 
 */
import java.util.LinkedList;

public class Solution1 {
	public static void main(String[] args) {
		Node a = new Node(4);
		Node b = new Node(5);
		Node c = new Node(3);
		Node d = new Node(1);
		Node[] child = new Node[2];
		child[0] = a;
		child[1] = b;
		Node[] child1 = new Node[1];
		child1[0] = d;
		c.children = child;
		b.children = child1;
		Node[] grp = new Node[4];
		grp[0] = a;
		grp[1] = b;
		grp[2] = c;
		grp[3] = d;
		Graph g = new Graph(grp);
		// Positive test case
		System.out.println(search(g, c, d));
		// Negative test case
		System.out.println(search(g, a, d));
	}

	static boolean search(Graph g, Node start, Node end) {
		Node temp;
		// if start and end node is same
		if (start == end) {
			return true;
		}
		LinkedList<Node> que = new LinkedList<Node>();
		for (Node n : g.getNodes()) {
			// univisited
			n.state = "u";
		}
		// visited
		start.state = "v";
		// add to queue
		que.add(start);
		while (!que.isEmpty()) {
			// remove first element from queue and iterate
			temp = que.removeFirst();
			if (temp != null && temp.getChildren() != null) {
				for (Node m : temp.getChildren()) {
					// visit all children
					if (m.state == "u") {
						if (m == end) {
							// if it is within the children return true
							return true;
						} else {
							m.state = "v";
							que.add(m);
						}
					}
				}
			}
			temp.state = "v";
		}
		return false;
	}
}

class Graph {
	public Node[] nodes;

	public Node[] getNodes() {
		return nodes;
	}

	public Graph(Node[] n) {
		nodes = n;
	}
}

class Node {
	public int data;
	public Node[] children;
	public String state;

	public Node(int n) {
		this.data = n;

	}

	public Node[] getChildren() {
		return children;
	}
}
