import java.util.*;
import java.io.*;

public class GreedyAlgorithms {

	/*
	 * Problem 1: Money Change Task: Find the minimum number of coins needed to
	 * change the input value (an integer) into coins with denominations 1, 5 and
	 * 10.
	 */
	public int getChange(int m) {
		int quotient10 = 0, quotient5 = 0, quotient1 = 0;

		quotient10 = m / 10;
		int remainder10 = m % 10;

		quotient5 = remainder10 / 5;
		int remainder5 = remainder10 % 5;

		quotient1 = remainder5;

		return (quotient10 + quotient5 + quotient1);
	}

	/*
	 * Problem 2: Maximum Value of the Loot Task: The goal of this code problem is
	 * to implement an algorithm for the fractional knapsack problem. Output: Output
	 * the maximal value of fractions of items that fit into the knapsack.
	 */
	private static double getOptimalValue(int capacity, int[] values, int[] weights) {
		double value = 0;

		double[][] unitValue = new double[values.length][2];

		// Calculate the unit value of all items
		for (int i = 0; i < values.length; i++) {
			unitValue[i][0] = (double) values[i] / (double) weights[i];
			unitValue[i][1] = (double) i;
		}

		// Sort items based on unit value, descending order
		Arrays.sort(unitValue, (a, b) -> Double.compare(b[0], a[0]));

		for (int i = 0; i < values.length; i++) {
			// If the bag is full, return value
			if (capacity == 0)
				return value;

			// If bag is still empty, find the item with highest
			// unit value to put into the bag
			int a = Math.min(capacity, weights[(int) unitValue[i][1]]);
			value += a * (unitValue[i][0]);
			weights[(int) unitValue[i][1]] -= a;
			capacity -= a;
		}

		return value;
	}
	
	/*
	 * Problem 3: Car Fueling
	 * Find the minimum number of refills needed to travel from A to B. Given
	 * the distance from A to B, the car's fuel capacity, and gas stations'
	 * distances from A along the way.
	 */

	private static int computeMinRefills(int dist, int tank, int[] stops) {
		int numRefills = 0;
		int fuel = tank; // Current level of fuel
		int full = tank; // Refill the tank

		if (tank > dist)
			return 0; // Enough fuel, no refill

		int[] destinations = new int[stops.length + 2];
		destinations[0] = 0;
		for (int i = 0; i < stops.length; i++)
			destinations[i + 1] = stops[i];
		destinations[stops.length + 1] = dist;
		
		for (int i = 0; i < destinations.length - 1; i++) {
			int distToNext = destinations[i+1] - destinations[i];
			
			if (distToNext > tank) return -1;
			if (distToNext <= fuel) {
				fuel -= distToNext; // Subtract used amount
				if (i + 2 < destinations.length && fuel < destinations[i+2] - destinations[i+1]) {
					fuel = full;
					numRefills += 1;
				}
			}
		}
		return numRefills;
	}

	public static void main(String[] args) {
		GreedyAlgorithms ga = new GreedyAlgorithms();
		Scanner scanner = new Scanner(System.in);

		// Problem 1: Money Change
//        int m = scanner.nextInt();
//        System.out.println(ga.getChange(m));

		// Problem 2: Maximum Value of the Loot
//		int n = scanner.nextInt();
//		int capacity = scanner.nextInt();
//		int[] values = new int[n];
//		int[] weights = new int[n];
//		for (int i = 0; i < n; i++) {
//			values[i] = scanner.nextInt();
//			weights[i] = scanner.nextInt();
//		}
//		System.out.println(getOptimalValue(capacity, values, weights));

		// Problem 3: Car Fueling
//		int dist = scanner.nextInt();
//		int tank = scanner.nextInt();
//		int n = scanner.nextInt();
//		int stops[] = new int[n];
//		for (int i = 0; i < n; i++) {
//			stops[i] = scanner.nextInt();
//		}
//		int dist = 950, tank = 400;
//		int[] stops = new int[] {200, 375, 550, 750};
//		
//		int dist = 10, tank = 3;
//		int[] stops = new int[] {1, 2, 5, 9};
//		
//		int dist = 500, tank = 200;
//		int[] stops = new int[] {100, 200, 300, 400};
		
		int dist = 1000, tank = 300;
		int[] stops = new int[] {250, 500, 750};
		System.out.println(computeMinRefills(dist, tank, stops));
	}
}
