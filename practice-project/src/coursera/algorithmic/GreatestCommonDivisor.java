package coursera.algorithmic;

import java.util.Scanner;

/*
 * Task: Given two integers a and b, find their greatest common divisor.
 * Input: Two integers a and b, greater than or equal to 1, and
 * smaller than or equal to 2 * 10^9
 */

public class GreatestCommonDivisor {

	public int findGCD(int f, int s) {
		int a, b;
		if (f > s) {
			a = f;
			b = s;
		} else {
			a = s;
			b = f;
		}

		if (b == 0) return a;
		return findGCD(b, a % b);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		GreatestCommonDivisor gcd = new GreatestCommonDivisor();
		int a = in.nextInt();
		int b = in.nextInt();
		System.out.println(gcd.findGCD(a,  b));
	}

}
