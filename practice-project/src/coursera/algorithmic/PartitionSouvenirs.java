package coursera.algorithmic;

import java.util.*;
import java.io.*;

public class PartitionSouvenirs {
	
	public static boolean subsetSum(int[] S, int n, int a, int b, int c)
    {
        if (a == 0 && b == 0 && c == 0) {
            return true;
        }

        if (n < 0) {
            return false;
        }

        boolean A = false;
        if (a - S[n] >= 0) {
            A = subsetSum(S, n - 1, a - S[n], b, c);
        }

        boolean B = false;
        if (!A && (b - S[n] >= 0)) {
            B = subsetSum(S, n - 1, a, b - S[n], c);
        }
 
        boolean C = false;
        if ((!A && !B) && (c - S[n] >= 0)) {
            C = subsetSum(S, n - 1, a, b, c - S[n]);
        }
        return A || B || C;
    }
 

    public static int partition(int[] S)
    {
        if (S.length < 3) {
            return 0;
        }

        int sum = Arrays.stream(S).sum();
 
        if ((sum % 3) == 0 && subsetSum(S, S.length - 1, sum/3, sum/3, sum/3))
        	return 1;
        else return 0;
    }
    
    
    private static int partition3(int[] values) {
        if (values.length < 3) // If there are less than 3 items, can't partition
        	return 0;
    	int sum = 0;
    	for (int i = 0; i < values.length; i++)
    		sum += values[i];
    	if (sum % 3 != 0) // The items can't be partitioned into 3 parts
    		return 0;
    	
    	int[][] table = new int[4][values.length + 1];
    	// Initialize values
    	for (int i = 0; i < 4; i++) {
    		table[i][0] = 0;
    		for (int j = 0; j < values.length + 1; j++) {
    			table[0][j] = 0;
    		}
    	}
    	
    	for (int i = 1; i < 4; i++) {
    		for (int j = 1; j < values.length + 1; j++) {
    			int a = i - values[j - 1];
    			if (values[j - 1] == i || (a > 0 && a > table[a][j-1]))
    				table[i][j] = (table[i][j-1] == 0) ? 1 : 2;
    			else
    				table[i][j] = table[i][j - 1];
    		}
    	}

        return (table[3][values.length] == sum % 3) ? 1 : 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition(A));
    }
}
//https://www.techiedelight.com/3-partition-problem/
