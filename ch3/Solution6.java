/*
This file: Solution6.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter3 - 6
Description: Implement a dog and cat fifo queue
Assumption: 
Last Modified: 9/23/2014 
 */

package _36;

import java.util.LinkedList;

public class Solution6 {
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	public static int order = 0;

	public void Enqueue(Animal a) {
		if (a instanceof Dog) {
			dogs.add((Dog) a);
		}
		if (a instanceof Cat) {
			cats.add((Cat) a);
		}
		// Set order to keep track of insertion order
		a.setOrder(order);
		// increase order by 1
		order++;
	}

	public Animal dequeueAny() {
		if (dogs.isEmpty()) {
			return dequeueCat();
		} else if (cats.isEmpty()) {
			return dequeueDog();
		}
		// Get first dog
		Dog dog = dogs.peek();
		// Get first cat
		Cat cat = cats.peek();

		// return the animal which is older
		if (dog.isOlder(cat)) {
			return dequeueDog();
		} else {
			return dequeueCat();
		}
	}

	public Dog dequeueDog() {
		return dogs.poll();
	}

	public Cat dequeueCat() {
		return cats.poll();
	}
}

class Animal {
	// name of animal
	String name;
	// to maintain insertion order and FIFO capabilities
	int insertorder;

	public Animal(String name) {
		this.name = name;
	}

	public void setOrder(int insertorder) {
		this.insertorder = insertorder;
	}

	public int getOrder() {
		return insertorder;
	}

	public boolean isOlder(Animal a) {
		return this.insertorder < a.getOrder();
	}
}

class Dog extends Animal {
	public Dog(String n) {
		super(n);
	}
}

class Cat extends Animal {
	public Cat(String n) {
		super(n);
	}
}
