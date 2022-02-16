package coursera.ds;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/*
 * Task: Implement a simple phone book manager using direct addressing.
 * Input: Single integer N in first line - the number of queries. It's followed by
 * 		  N lines, each of them contains one query.
 * Time Limit: Java 6 secs.
 * Memory Limit: 512MB.
 */

public class PhoneBook2 {

	private FastScanner in = new FastScanner();

	private Contact[] contacts = new Contact[10000000];

	public static void main(String[] args) {
		new PhoneBook2().processQueries();
	}

	private Query readQuery() {
		String type = in.next();
		int number = in.nextInt();
		if (type.equals("add")) {
			String name = in.next();
			return new Query(type, name, number);
		} else {
			return new Query(type, number);
		}
	}

	private void writeResponse(String response) {
		System.out.println(response);
	}

	private void processQuery(Query query) {
		Contact t = new Contact(query.name, query.number);
		
		if (query.type.equals("add")) {
			if (contacts[query.number] == null) {
				contacts[query.number] = t;
			} else if (contacts[query.number].number == query.number) {
				contacts[query.number].name = query.name;
			}
			
		} else if (query.type.equals("del")) {
			if (contacts[query.number] != null) {
				contacts[query.number] = null;
			}

		} else {
			String response = "not found";
			if (contacts[query.number] != null && query.number == contacts[query.number].number) {
				response = contacts[query.number].name;
			}
			writeResponse(response);
		}
	}

	public void processQueries() {
		int queryCount = in.nextInt();
		for (int i = 0; i < queryCount; ++i)
			processQuery(readQuery());
	}

	static class Contact {
		String name;
		int number;

		public Contact(String name, int number) {
			this.name = name;
			this.number = number;
		}
	}

	static class Query {
		String type;
		String name;
		int number;

		public Query(String type, String name, int number) {
			this.type = type;
			this.name = name;
			this.number = number;
		}

		public Query(String type, int number) {
			this.type = type;
			this.number = number;
		}
	}

	class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
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