package coursera.algorithmic;

import java.util.*;

class EditDistance {
	
	// Find the smallest of three values
	public static int min(int a, int b, int c) {
		if (a <= b && a <= c) return a;
		if (b <= a && b <= c) return b;
		else return c;
	}
	
	public static int findEditDistance(String s, String t) {
		if (s.equals(t)) return 0;
		
		int sLen = s.length(); // Length of first string
		int tLen = t.length(); // Length of second string
		
		int dist = 0;
		
		int[][] table= new int[sLen + 1][tLen + 1];
		// Initialize values
		for (int i = 0; i < sLen + 1; i++) {
			table[i][0] = i;
			for (int j = 1; j < tLen + 1; j++) {
				table[0][j] = j;
			}
		}
		
		for (int i = 1; i < sLen + 1; i++) {
			for (int j = 1; j < tLen + 1; j++) {
				

				int insertion = table[i][j-1] + 1;
				int deletion = table[i-1][j] + 1;
				int match = table[i-1][j-1];
				int mismatch = table[i-1][j-1] + 1; // +1 if substitution counts as 1
				// +2 if substitution counts as 2
				
				if (s.charAt(i-1) == t.charAt(j-1))
					table[i][j] = min(insertion, deletion, match);
				else
					table[i][j] = min(insertion, deletion, mismatch);
				}
			}

		dist = table[sLen][tLen];
		//System.out.println(Arrays.deepToString(table));
		
		
		return dist;
	}
	

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);

		String s = scan.next();
		String t = scan.next();

		System.out.println(findEditDistance(s, t));
	}

}