package coursera.algorithmic;

import java.io.*;
import java.util.*;

public class Sorting {
	/*
	 * Programming Assignment 4 
	 * Task 4: Randomized Three-Way Quick Sort
	 */
    private static Random random = new Random();
    
    public static void swap(int[] arr, int a, int b) { // a and b are array indices
    	int temp = arr[a];
    	arr[a] = arr[b];
    	arr[b] = temp;
    }

    /*
     * 1) All elements smaller than pivot come first
     * 2) All elements equal to pivot come next
     * 3) All elements greater than pivot are in the end
     */
    private static int[] threeWayPartition(int[] arr, int low, int hi) {
    	int pivotVal = arr[low]; // Value of pivot, not index
    	int lt = low, gt = hi;
    	
    	int i = low;
    	while(i <= gt) {
    		// If current element is smaller than pivot
    		if (arr[i] < pivotVal) {
    			swap(arr, lt, i);
    			i++;
    			lt++; // Update index of smaller elements
    		// If current element is larger than pivot
    		} else if (arr[i] > pivotVal) {
    			swap(arr, gt, i);
    			gt--; // Update index of larger elements
    		} else if (arr[i] == pivotVal) {
    			i++;
    		}
    	}

    	int[] m = {lt, gt};
    	return m;
    }

    private static void randomizedQuickSort(int[] arr, int low, int hi) {
    	// If index of item from left is greater than that of item from right: we stop
        if (low >= hi) { 
            return; 
        }
        
        // Randomly generate pivot within range
        int pivot = random.nextInt(hi - low + 1) + low;
        
        // Swap the location of low and pivot
        swap(arr, pivot, low);
        
        int[] m = threeWayPartition(arr, low, hi);
        int m_low = m[0];
        int m_hi = m[1];
        
        // Recursively sort elements before and after partition
        randomizedQuickSort(arr, low, m_low - 1);
        randomizedQuickSort(arr, m_hi + 1, hi);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
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

