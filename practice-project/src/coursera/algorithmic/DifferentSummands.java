package coursera.algorithmic;

import java.util.*;

public class DifferentSummands {
	private static HashSet<Integer> optimalSummands(int n) {
		HashSet<Integer> summands = new HashSet<Integer>();

		// double ktemp = (Math.sqrt(8 * n + 1) - 1) / 2;
		double ktemp2 = (Math.sqrt(2 * n + 0.25) - 0.5);
		int k = (int) Math.floor(ktemp2);

		for (int i = 1; i <= k; i++) {
			summands.add(i);
		}
		int sum = (k * (k + 1)) / 2; // Sum of first k numbers

		if (sum < n && summands.contains(n - sum)) {
			summands.remove(k);
			summands.add((n - sum) + k);
		}

		return summands;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		HashSet<Integer> summands = optimalSummands(n);
		System.out.println(summands.size());
		for (Integer summand : summands) {
			System.out.print(summand + " ");
		}
	}
}