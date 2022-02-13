package coursera.algorithmic;

import java.io.*;
import java.util.*;

/*
 * Algorithmic Toolbox Week 4 Divide and Conquer
 * Programming Assignment 4
 */

public class BinarySearch {

	/*
	 * Task 1: Binary Search
	 */

	static int binarySearch(int[] a, int x, int l, int r) {

		if (r >= l) {
			if (x > a[a.length - 1])
				return -1;
			if (x < a[0])
				return -1;
			if (a[0] == x)
				return 0; // If first element is x, return 0

			int mid = (int) Math.floor(l + (r - l) / 2);
			
			if (a[mid] == x) {
				int firstMatch = mid;
				int i = mid - 1;

				while (a[i] == x && i > 0) {
					firstMatch = binarySearch(a, x, l, i);
					i--;
				}
				return firstMatch;
			}

			if (a[mid] > x) {
				r = mid - 1;
				return binarySearch(a, x, l, r);
			} else {
				l = mid + 1;
				return binarySearch(a, x, l, r);
			}
		}
		return -1;
	}

	/*
	 * Task 2: Binary Search with Duplicates Return the index of the first
	 * occurrence of element.
	 */

	static int binarySearchDup(int[] a, int x) {
		int l = 0, r = a.length;

		if (r >= l) {
			if (x > a[a.length - 1])
				return -1; // If x exceeds maximum value, it's not in array
			if (x < a[0])
				return -1; // If x is smaller than minimum, it's not in array
			if (a[0] == x)
				return 0; // If first element is x, return 0

			int mid = (int) Math.floor(l + (r - l) / 2);

			if (a[mid] == x) {
				int firstMatch = mid;
				int i = mid - 1;

				while (a[i] == x && i > 0) {
					firstMatch = binarySearch(a, x, l, i);
					i--;
				}
				return firstMatch;
			}

			if (a[mid] > x) {
				r = mid - 1;
				return binarySearch(a, x, l, r);
			} else {
				l = mid + 1;
				return binarySearch(a, x, l, r);
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		int m = scanner.nextInt();
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = scanner.nextInt();
		}

		// Task 1: Binary Search
//		for (int i = 0; i < m; i++) {
//			System.out.print(binarySearch(a, b[i], 0, a.length) + " ");
//		}

		// Task 2: Binary Search with Duplicates
		for (int i = 0; i < m; i++) {
			System.out.print(binarySearch(a, b[i], 0, a.length)+ " ");
		}
//		int[] xxx = new int[] { 2, 2, 2, 5, 6, 7 };
//		int[] bbb = new int[] { 2, 5, 6 };
//		for (int i = 0; i < bbb.length; i++) {
//			System.out.println(binarySearch(xxx, bbb[i], 0, xxx.length));
//		}
//
//		int[] aaa = new int[] { 1, 1, 1, 1, 1, 1 };
//		int[] ccc = new int[] { 1, 3 };
//		for (int i = 0; i < ccc.length; i++) {
//			System.out.println(binarySearch(aaa, ccc[i], 0, aaa.length));
//		}
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}