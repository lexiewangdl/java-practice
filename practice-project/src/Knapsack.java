import java.util.*;

/*
 * You are given a set of bars of gold and your goal is to take as much gold as possible
 * into your bag. There is just one copy of each bar and for each bar you can either take 
 * it or not (hence you cannot take a fraction of a bar).
 */

public class Knapsack {
	static int max(int a, int b) {
		return (a >= b) ? a : b;
	}

	static int optimalWeight(int W, int[] w) { // W is capacity
		int result = 0;

		int[][] knap = new int[w.length + 1][W + 1];

		for (int i = 0; i < w.length + 1; i++) {
			knap[i][0] = 0;
			for (int j = 0; j < W + 1; j++) { // for w from 1 to W
				knap[0][j] = 0;
			}
		}
		
		for (int i = 1; i < w.length + 1; i++) {
			for (int j = 1; j < W + 1; j++) { // for w from 1 to W
				
				knap[i][j] = knap[i - 1][j];
				if (w[i - 1] <= j) {
					int val = w[i-1] + knap[i-1][j - w[i-1]];
					if (knap[i][j] < val)
					knap[i][j] = val;
				} 
			}
		}
		//System.out.println(Arrays.deepToString(knap));

		return knap[w.length][W];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int W, n;
		W = scanner.nextInt();
		n = scanner.nextInt();
		int[] w = new int[n];
		for (int i = 0; i < n; i++) {
			w[i] = scanner.nextInt();
		}
		System.out.println(optimalWeight(W, w));
	}
}
