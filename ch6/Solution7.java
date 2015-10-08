
/*
This file: Solution7.java
Programmer: Prabh Simran Singh (prabhsis@andrew.cmu.edu)
Course/Section: 11-601
Assignment: Chapter6 - 7
Description: Gender Ratio
Last Modified: 10/8/2015 
 */
import java.util.Random;

// By intution the gender ratio will remain 50 - 50. We can solve it using
// a probability . The possible combinations are G, BG, BBG, BBBG, BBBBG
// we can calculate the probability of each such event and then add them all together.
// We can also write a program to simulate this.
public class Solution7 {
	public static int[] family() {
		Random random = new Random();
		int boys = 0;
		int girls = 0;
		// we move forward until we have a girl
		while (girls == 0) {
			if (random.nextBoolean()) {
				girls += 1;
			} else {
				// boy
				boys += 1;
			}
		}
		int[] genders = { girls, boys };
		return genders;
	}

	public static double runsimulation(int n) {
		int boys = 0;
		int girls = 0;
		for (int i = 0; i < n; i++) {
			// Create a family
			int[] genders = family();
			// Add the boys and girls count
			girls += genders[0];
			boys += genders[1];
		}
		// find the probability
		return girls / (double) (boys + girls);
	}

	public static void main(String[] args) {
		// Find probability
		double prob = runsimulation(10000);
		System.out.println(prob);

	}
}
