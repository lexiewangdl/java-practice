import java.util.*;

public class LCS2 {

	// Failed case #18/37: time limit exceeded (Time used: 3.02/1.50, memory used: 29028352/2147483648.)
	private static int lcs2(int[] a, int[] b, int m, int n) {

		// If either array is empty, length of common subsequence is zero
		if (m == 0 || n == 0)
			return 0;

		// If last element of both arrays are equal, we ignore this element,
		// and we add one to length of common subsequence
		if (a[m - 1] == b[n - 1])
			return lcs2(a, b, m - 1, n - 1) + 1;

		// Last element of two arrays are different, we either remove last
		// element of first array, or remove last element from second array.
		// Compare the results and see which one is higher.
		else
			return Math.max(lcs2(a, b, m, n - 1), lcs2(a, b, m - 1, n));
	}
 

	public static int min(int a, int b, int c) {
		if (a <= b && a <= c)
			return a;
		if (b <= a && b <= c)
			return b;
		else
			return c;
	}

	public static int findEditDistance(int[] s, int[] t) {
		if (s.equals(t))
			return 0;

		int sLen = s.length; // Length of first string
		int tLen = t.length; // Length of second string

		int dist = 0;

		int[][] table = new int[sLen + 1][tLen + 1];
		// Initialize values
		for (int i = 0; i < sLen + 1; i++) {
			table[i][0] = i;
			for (int j = 1; j < tLen + 1; j++) {
				table[0][j] = j;
			}
		}

		for (int i = 1; i < sLen + 1; i++) {
			for (int j = 1; j < tLen + 1; j++) {

				int insertion = table[i][j - 1] + 1;
				int deletion = table[i - 1][j] + 1;
				int match = table[i - 1][j - 1];
				int mismatch = table[i - 1][j - 1] + 2; // +1 if substitution counts as 1
				// +2 if substitution counts as 2

				if (s[i - 1] == t[j - 1])
					table[i][j] = min(insertion, deletion, match);
				else
					table[i][j] = min(insertion, deletion, mismatch);
			}
		}

		dist = table[sLen][tLen];
		// System.out.println(Arrays.deepToString(table));

		return dist;
	}
	
	public static int lcs(int[] a, int[] b) {
		if (a.length == 0 || b.length == 0) return 0;
		int t = a.length + b.length;
		int ed = findEditDistance(a, b);
		return (t - ed)/2;
	}
	
	public static int lcs3(int[] a, int[] b, int[] c) {
		if (a.length == 0 || b.length == 0 || c.length == 0) return 0;
		return min(lcs(a, b), lcs(b, c), lcs(a, c));
	}

	public static void main(String[] args) {
		// Largest Common Subsequence of 2 Sequences
//		Scanner scanner = new Scanner(System.in);
//		int n = scanner.nextInt();
//		int[] a = new int[n];
//		for (int i = 0; i < n; i++) {
//			a[i] = scanner.nextInt();
//		}
//
//		int m = scanner.nextInt();
//		int[] b = new int[m];
//		for (int i = 0; i < m; i++) {
//			b[i] = scanner.nextInt();
//		}

		//System.out.println(lcs2(a, b, c, d)); // Failed case #18/37: time limit exceeded (Time used: 3.02/1.50, memory used: 29028352/2147483648.)
		//System.out.println(lcs(a, b));
		
		// Largest Common Subsequence of 3 Sequences
		Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
	}
}