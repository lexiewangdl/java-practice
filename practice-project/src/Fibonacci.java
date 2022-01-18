import java.util.Scanner;

public class Fibonacci {
	
	/* Algorithmic Toolbox Week 2 Programming Assignment 1 Fibonacci Number
	 * Task: Given an integer n, find the nth Fibonacci number Fn
	 * n is greater than or equal to 0 and is smaller than or equal to 45
	 */
	public int findFibonacci(int n) {
		int[] fibonacciNumbers = new int[46]; // Maximum size is 45
		fibonacciNumbers[0] = 0;
		fibonacciNumbers[1] = 1;
		
		for (int i = 2; i < fibonacciNumbers.length; i++) {
			fibonacciNumbers[i] = fibonacciNumbers[i-1] + fibonacciNumbers[i-2];
		}
		
		return fibonacciNumbers[n];
	}

	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		System.out.println(f.findFibonacci(n));

	}

}
