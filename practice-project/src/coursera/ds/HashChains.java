package coursera.ds;

import java.io.*;
import java.util.*;

public class HashChains {
	private FastScanner in;
	private PrintWriter out;
	private int bucketCount;
	private ArrayList<ArrayList<String>> buckets = new ArrayList<ArrayList<String>>(bucketCount);
	private int prime = 1000000007;
	private int multiplier = 263;

	public static void main(String[] args) throws IOException {
		new HashChains().processQueries();
	}

	private int hashFunc(String s) {
		long hash = 0;
		for (int i = s.length() - 1; i >= 0; --i)
			hash = (hash * multiplier + s.charAt(i)) % prime;
		return (int) hash % bucketCount;
	}

	private Query readQuery() throws IOException {
		String type = in.next();
		if (!type.equals("check")) {
			String s = in.next();
			return new Query(type, s);
		} else {
			int ind = in.nextInt();
			return new Query(type, ind);
		}
	}

	private void writeSearchResult(boolean wasFound) {
		out.println(wasFound ? "yes" : "no");
		// Uncomment the following if you want to play with the program interactively.
		// out.flush();
	}

	private void add(Query query) {
		int ha = this.hashFunc(query.s);
		ArrayList<String> bucket = buckets.get(ha);

		if (!bucket.contains(query.s)) {
			buckets.get(ha).add(query.s);
		}
	}

	private void del(Query query) {
		int ha = this.hashFunc(query.s);
		ArrayList<String> bucket = buckets.get(ha);
		for (int i = 0; i < bucket.size(); i++) {
			if (bucket.get(i).equals(query.s)) {
				bucket.get(i);
				break;
			}
		}
	}

	private void find(Query query) {
		int ha = this.hashFunc(query.s);
		boolean wasFound = false;
		if (buckets.get(ha).contains(query.s))
			wasFound = true;
		writeSearchResult(wasFound);
	}

	private ArrayList<String> check(Query query) {
		ArrayList<String> bucket = buckets.get(query.ind);
		return bucket;
	}

	private void processQuery(Query query) {
		
		for (int i = 0; i < bucketCount; i++) {
			buckets.add(i, new ArrayList<String>());
		}
		
		switch (query.type) {
		case "add":
			this.add(query);
		case "del":
			this.del(query);
		case "find":
			this.find(query);
			break;
		case "check":
//			ArrayList<String> bkt = this.check(query);
//			for (String s : bkt) {
//				if (this.hashFunc(s) == query.ind)
//					out.print(s + " ");
//			}
			//out.println();
			// Uncomment the following if you want to play with the program interactively.
			// out.flush();
			break;
		default:
			throw new RuntimeException("Unknown query: " + query.type);
		}
	}

	public void processQueries() throws IOException {
		buckets = new ArrayList<ArrayList<String>>(bucketCount);
		in = new FastScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		bucketCount = in.nextInt();
		int queryCount = in.nextInt();
		for (int i = 0; i < queryCount; ++i) {
			processQuery(readQuery());
		}
		out.close();
	}

	static class Query {
		String type;
		String s;
		int ind;

		public Query(String type, String s) {
			this.type = type;
			this.s = s;
		}

		public Query(String type, int ind) {
			this.type = type;
			this.ind = ind;
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