import java.util.*;

public class FibModuloM {

	public int findLastDigit(long n) {
		int first = 0; // The last digit of F[i-2]
		int second = 1; // The last digit of F[i-1]
		int fld = first + second; // Current Fibonacci number's last digit

		for (int i = 2; i < (n + 1); i++) {
			int temp = first + second;
			fld = temp % 10; // Find the last digit of current Fibonacci number

			first = second; // Update previous two numbers
			second = fld;
		}

		return fld;
	}

	/*
	 * For any integer n, Fi mod n is periodic. The pisano period is the length of
	 * the period of this sequence. The period always begin with 0 and 1.
	 */

	public long findPeriod(long m) {
		long prep = 0, p = 1;
		long c = prep + p;
		long period = 1;

		for (long i = 0; i < m * m; i++) {
			c = (prep + p) % m;
			prep = p;
			p = c;
			if (prep == 0 && p == 1) {
				period = (i + 1);
				break;
			}
		}
		return period;
	}

	public long findRemainder(long n, long m) {
		long remainder = n % findPeriod(m);

		long prep = 0;
		long p = 1;
		long re = remainder;
		for (long i = 1; i < remainder; i++) {
			re = (prep + p) % m;
			prep = p;
			p = re;
		}
		return re % m;
	}

	/*
	 * Task: Given an integer, find the last digit of the sum F0 + F1 + ... + Fn
	 * Input: single integer n, 0 <= n <= 10^14
	 */

	public long findSumLastDigit(long n) {
		long remainder = (n + 2) % findPeriod(10);
		// findPeirod(10) is the Pisano period for the last digit of Fibonacci numbers
		// The last digit of Fibonacci number F(n+2) is equal to F(remainder)

		long fld = findLastDigit(remainder); // Last digit of F(n + 2)
		long sld = 0; // Last digit of the sum of first n numbers
		if (fld == 0)
			sld = 9;
		else
			sld = (fld - 1);

		return sld;
	}

	public long findSumTwoNums(long m, long n) {
		long nsld = findSumLastDigit(n); // The last digit of sum of first n numbers
		long msld = findSumLastDigit(m); // The last digit of sum of first m numbers
		long fmld = findRemainder(m, 10); // The last digit of Fibonacci number Fm

		long res = 0;
		if ((nsld - msld) < 0) { 
		// If the last digit of sum(F1+...+Fm) is greater than that of sum(F1+...+Fn)
			res = 10 + (nsld - msld);
		} else
			res = nsld - msld;

		return (res + fmld) % 10;
	}

	public static void main(String[] args) {
		FibModuloM fmm = new FibModuloM();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Pisano Period:");
		for (int i = 1; i <= 10; i++) {
			System.out.println("m: " + i + " Period length: " + fmm.findPeriod(i));
		}

		/*
		 * Task: Given two integers n and m, output Fn mod m (which is the remainder of
		 * Fn when divided by m)
		 * Input: integer n, 1 <= n <= 10^14; integer m, 2 <= m <=10^3
		 */
		
		// Test
		System.out.println(fmm.findRemainder(239, 1000));
		System.out.println(fmm.findRemainder(2816213588l, 239));
		System.out.println(fmm.findRemainder(10, 2));
		System.out.println(fmm.findRemainder(9999999999999l, 2));
		 
		 // Run
		long a = in.nextLong();
		long b = in.nextLong();
		System.out.println(fmm.findRemainder(a, b));

		/*
		 * 6 Last Digit of the Sum of Fibonacci Numbers
		 * Task: Given an integer n, find the last digit of the sum F0 + F1 + ... + Fn
		 * Input: integer n, 0 <= n <= 10^14
		 */
		
		long x = in.nextLong();
		System.out.println(fmm.findSumLastDigit(x));

		/*
		 * 7 Last Digit of the Sum of Fibonacci Numbers Again
		 * Task: Given two non-negative integers m and n, where m <= n, 
		 * find the last digit of the sum Fm + Fm+1 +... + Fn
		 * Input: integer m and n, 0 <= m <= n <= 10^14
		 */

		long m = in.nextLong();
		long n = in.nextLong();
		System.out.println(fmm.findSumTwoNums(m, n));
	}

}
