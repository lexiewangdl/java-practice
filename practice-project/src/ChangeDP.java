import java.util.Scanner;

public class ChangeDP {
	private static int getNumWays(int m) {
		int[] coins = new int[] { 1, 3, 4 };
		int[] ways = new int[m + 1];

		ways[0] = 1;

		for (int i = 0; i < coins.length; i++) {
			for (int j = 0; j < ways.length; j++) {
				ways[j] += ways[(int) (j - coins[i])];
			}
		}
		return ways[m];
	}
	
	private static int getChange(int m) {
		if (m == 0) return 0; // If amount of money is 0, we need 0 coins.
		
		int[] coins = new int[] { 1, 3, 4 };
		
		int[] T = new int[m + 1];
		T[0] = 0;
		int[] R = new int[m + 1];
		
		for(int i=1; i <= m; i++){
            T[i] = Integer.MAX_VALUE-1;
            R[i] = -1;
        }
		
		for (int i = 0; i < coins.length; i++) { // For each denomination
			for (int j = 1; j <= m; j++) { // For each integer amount of money less than or equal to m
				if (j >= coins[i]) {
					if (T[j - coins[i]] + 1 < T[j]) {
						T[j] = 1 + T[j - coins[i]];
						R[j] = i;
					}
				}
			}
		}
		
		return T[m];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		System.out.println(getChange(m));

	}
}