package coursera.algorithmic;

import java.util.Scanner;

public class PlacingParentheses {

	// Check if a character is an operator
	boolean isOperator(char op) {
		return (op == '+' || op == '-' || op == '*');
	}

	/**
	 * 
	 * @param exp: a string of length 2n + 1 for some n, each symbol at an even
	 *             position is a digit, while each symbol at an odd position is one
	 *             of three operations from {+, -, *}
	 * @return
	 */
	private static long getMaximValue(String exp) {
		int n = (exp.length() - 1) / 2 + 1; // n is number of digits in string
		
		long[][] min = new long[n][n], max = new long[n][n];

		for (int i = 0; i < exp.length(); i++) {
			if (i % 2 != 0) { // If char is operator

			}

		}

		return 0;
	}
	

	private static long eval(long a, long b, char op) {
		if (op == '+') {
			return a + b;
		} else if (op == '-') {
			return a - b;
		} else if (op == '*') {
			return a * b;
		} else {
			assert false;
			return 0;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String exp = scanner.next();
		System.out.println(getMaximValue(exp));
	}
}
