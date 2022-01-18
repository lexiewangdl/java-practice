import java.util.Scanner;

/*
 * Task: Given two integers a and b, find their least common multiple.
 * a and b are greater than or equal to 1 and smaller than or equal to 10^7.
 */

public class LeastCommonMultiple {

	public long findGCD(long f, long s) {
		long a, b;
		if (f > s) {
			a = f;
			b = s;
		} else {
			a = s;
			b = f;
		}

		if (b == 0)
			return a;
		return findGCD(b, a % b);
	}

	/*
	 * The lowest common multiple of two numbers a and b is equal 
	 * to |a * b|/gcd(a, b)
	 */

	public long findLCM(long a, long b) {
		long product = Math.abs(a * b);
		long denom = findGCD(a, b);
		return product/denom;
	}

	public static void main(String[] args) {
		LeastCommonMultiple lcm = new LeastCommonMultiple();
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		System.out.println(lcm.findLCM(a, b));
		// System.out.println(lcm.findLCM(6, 8));
		// System.out.println(lcm.findGCD(761457, 614573));
		// System.out.println(lcm.findLCM(761457, 614573));

	}

}
