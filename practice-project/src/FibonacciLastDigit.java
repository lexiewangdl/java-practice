import java.util.Scanner;

/* Algorithmic Toolbox Week 2 Programming Assignment 2 Last Digit of a Large Fibonacci Number
 * Task: Find the last digit of n-th Fibonacci number
 * n is greater than or equal to 0 and is smaller than or equal to 10^7
 */

public class FibonacciLastDigit {

	public int findLastDigit(long n) {
		int first = 0; // The last digit of F[i-2]
		int second = 1; // The last digit of F[i-1]
		int fld = 0; // Current Fibonacci number's last digit

		for (int i = 2; i < (n + 1); i++) {
			int temp = first + second;
			fld = temp % 10; // Find the last digit of current Fibonacci number

			first = second; // Update previous two numbers
			second = fld;
		}

		return fld;
	}

	public static void main(String[] args) {
		FibonacciLastDigit fld = new FibonacciLastDigit();
		Scanner in = new Scanner(System.in);
		long n = in.nextInt();

		System.out.println(fld.findLastDigit(n));

	}

}
