package coursera.ds;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {
	
	/*
	 * Task: The first step of the HeapSort algorithm is to create a heap from the array you want to sort.
	 * The task is to implement this first step and convert a given array of integers into a heap. You 
	 * will do that by applying a certain number of swaps to the array. Swap is an operation which exchanges
	 * the i-th and j-th element of the array a for some i and j. 
	 * Note: use min-heap instead of a max-heap.
	 */
	
	// A min-heap is a binary tree such that the data contained in each node is less than or equal to the data
	// in that node's children, and the binary tree is complete.
	
    private int[] data;
    private List<Swap> swaps;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n];
        for (int i = 0; i < n; ++i) {
          data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) {
          out.println(swap.index1 + " " + swap.index2);
        }
    }
    
    /*
     * maxSize: maximum number of elements in the heap
     * size: size of the heap
     * heap: array of length maxSize where the heap occupies the first size elements
     */
    
    private int findLeftChild(int i) {
    	int lc = (2 * i) + 1; // index of left child, if it exists
    	return lc; // This index is zero-based
    }
    
    private int findRightChild(int i) {
    	int rc = (2 * i) + 2; // index of right child, if it exists
    	return rc; // This index is zero-based
    }
    
    private void siftDown(int i) {
    	int minIndex = i;
    	int l = findLeftChild(i);
    	if (l < data.length && data[l] < data[minIndex]) { // Check if index is in our data, and check is value is greater 
    		minIndex = l;
    	}
    	int r = findRightChild(i);
    	if (r < data.length && data[r] < data[minIndex]) { // Check if index is in our data
    		minIndex = r;
    	}
    	if (i != minIndex) {
    		swaps.add(new Swap(i, minIndex));
    		int tmp = data[i];
    		data[i] = data[minIndex];
    		data[minIndex] = tmp;
    		siftDown(minIndex);
    	}
    }
    

    private void generateSwaps() {
      swaps = new ArrayList<Swap>();
      for (int i = data.length/2; i >= 0; i--) {
    	  this.siftDown(i);
      }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        generateSwaps();
        writeResponse();
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}