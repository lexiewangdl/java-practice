import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class GreedyAlgorithm {

	/*
	 * Problem 4: Maximum Advertisement Revenue Inputs: Sequence a1, a2, ..., an,
	 * each item is the profit per click of ad Sequence b1, b2, ..., b3, each item
	 * is average number of clicks per day of this slot Goal: Maximize sum of their
	 * products
	 * 
	 */
	private static long maxDotProduct(int[] a, int[] b) {
		Integer[] aSorted = Arrays.stream(a).boxed().toArray(Integer[]::new);
		Arrays.sort(aSorted, Collections.reverseOrder());

		Integer[] bSorted = Arrays.stream(b).boxed().toArray(Integer[]::new);
		Arrays.sort(bSorted, Collections.reverseOrder());
		
		long result = 0;
		for (int i = 0; i < aSorted.length; i++) {
			result += (long) aSorted[i] * (long) bSorted[i];
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
		System.out.println(maxDotProduct(a, b));
	}
}
