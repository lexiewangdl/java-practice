package coursera.ds;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/*
 * Task: Implement the Rabin-Karp's algorithm for searching the given pattern in the given text.
 * Output: Print all the positions of the occurrences of pattern P in test T in the ascending order.
 * 		   Use zero-based indexing of positions in the text T.
 */

public class HashSubstring {

    private static FastScanner in;
    private static PrintWriter out;
    public static ArrayList<Long> sums = new ArrayList<Long>();

    public static void main(String[] args) throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        printOccurrences(find(readInput()));
        out.close();
    }

    private static Data readInput() throws IOException {
        String pattern = in.next();
        String text = in.next();
        return new Data(pattern, text);
    }

    private static void printOccurrences(ArrayList<Integer> ans) throws IOException {
        for (Integer cur : ans) {
            out.print(cur);
            out.print(" ");
        }
    }
    
    private static long hashSum(String s) {
		long sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += s.charAt(i);
		}
		return sum;
	}
    
    private static void precomputeHashes(Data input) {
    	int len = input.pattern.length();
    	int end = input.text.length() - len + 1;
    	String ss = input.text.substring(0, len);
    	sums.add(hashSum(ss));
    	
    	for (int i = 1; i < end; i++) {
    		long hash = sums.get(i - 1);
    		long left = input.text.charAt(i - 1);
    		long right = input.text.charAt(i + len - 1);
    		long current = hash - left + right;
    		sums.add(current);
    	}
    }
    
    private static ArrayList<Integer> find(Data input) {
    	int len = input.pattern.length();
    	int end = input.text.length() - len + 1;
    	long p = hashSum(input.pattern);
    	precomputeHashes(input);
    	
    	ArrayList<Integer> results = new ArrayList<Integer>();
    	for (int i = 0; i < end; i++) {
    		if (p == sums.get(i)) {
    			if (input.pattern.equals(input.text.substring(i, i + len))) {
    				results.add(i);
    			}
    		}
    	}
    	
		return results;
    	
    }
  
    static class Data {
        String pattern;
        String text;
        public Data(String pattern, String text) {
            this.pattern = pattern;
            this.text = text;
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
