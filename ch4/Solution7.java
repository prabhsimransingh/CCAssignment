/*
This file: Solution7.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter4-7
Description: Given a list of projects and there dependencies find there build order
Assumption: 
Time Complexity: 
Last Modified: 9/24/2014 
 */
package _47;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

//Followed the algorithm in CTCI as the problem was conceptually very hard to solve.
public class Solution7 {
	public static void main(String[] args) {
		//Adding projects and there dependencies
		String[] projects = { "a", "b", "c", "d", "e", "f"};
		String[][] dependencies = { { "a", "b" }, { "b", "c" }, { "a", "c" }, 
				{ "d", "e" }, { "b", "d" }, { "e", "f" },
				{ "a", "f" }};
		//Get build order
		String[] buildOrder = buildOrderWrapper(projects, dependencies);
		if (buildOrder == null) {
			System.out.println("Circular Dependency.");
		} else {
			for (String s : buildOrder) {
				System.out.println(s);
			}
		}
	}

	public static Graph generateGraph(String[] projects, String[][] dependencies) {
		Graph graph = new Graph();
		//add the graph and there dependencies which dictates the build order.
		for (String project : projects) {
			graph.getOrCreateNode(project);
		}

		for (String[] dependency : dependencies) {
			String first = dependency[0];
			String second = dependency[1];
			graph.addEdge(first, second);
		}

		return graph;
	}
	//iterate through project tree using DFS
	public static boolean doDFS(Project project, Stack<Project> stack) {
		if (project.getState() == Project.State.P) {
			return false; // Cycle
		}

		if (project.getState() == Project.State.B) {
			project.setState(Project.State.P);
			ArrayList<Project> children = project.getChildren();
			for (Project child : children) {
				if (!doDFS(child, stack)) {
					return false;
				}
			}
			project.setState(Project.State.C);
			stack.push(project);
		}
		return true;
	}
	
	//Returns list of project in correct build order
	public static Stack<Project> projectOrder(ArrayList<Project> projects) {
		Stack<Project> stack = new Stack<Project>();
		for (Project project : projects) {
			if (project.getState() == Project.State.B) {
				if (!doDFS(project, stack)) {
					return null;
				}
			}
		}
		return stack;
	}

	public static String[] convertToStringList(Stack<Project> projects) {
		String[] buildOrder = new String[projects.size()];
		for (int i = 0; i < buildOrder.length; i++) {
			buildOrder[i] = projects.pop().getName();
		}
		return buildOrder;
	}

	//Find valid order 
	public static Stack<Project> getOrder(String[] projects, String[][] dependencies) {
		Graph graph = generateGraph(projects, dependencies);
		return projectOrder(graph.getNodes());
	}

	public static String[] buildOrderWrapper(String[] projects, String[][] dependencies) {
		Stack<Project> buildOrder = getOrder(projects, dependencies);
		if (buildOrder == null)
			return null;
		String[] buildOrderString = convertToStringList(buildOrder);
		return buildOrderString;
	}
}

class Graph {
	private ArrayList<Project> nodes = new ArrayList<Project>();
	private HashMap<String, Project> map = new HashMap<String, Project>();

	public Project getOrCreateNode(String name) {
		if (!map.containsKey(name)) {
			Project node = new Project(name);
			nodes.add(node);
			map.put(name, node);
		}

		return map.get(name);
	}

	public void addEdge(String startName, String endName) {
		Project start = getOrCreateNode(startName);
		Project end = getOrCreateNode(endName);
		start.addNeighbor(end);
	}

	public ArrayList<Project> getNodes() {
		return nodes;
	}
}

// Project Class
class Project {
	public enum State {
		C, P, B
	};

	private ArrayList<Project> children = new ArrayList<Project>();
	private HashMap<String, Project> map = new HashMap<String, Project>();
	private String name;
	private State state = State.B;

	public Project(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}

	public void addNeighbor(Project node) {
		if (!map.containsKey(node.getName())) {
			children.add(node);
		}
	}

	public State getState() {
		return state;
	}

	public void setState(State st) {
		state = st;
	}

	public ArrayList<Project> getChildren() {
		return children;
	}
}
