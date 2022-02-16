package coursera.ds;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class PhoneBook {

	private FastScanner in = new FastScanner();
	// Keep list of all existing (i.e. not deleted yet) contacts.

	private HashMap<String, Integer> contacts = new HashMap<String, Integer>();

	public static void main(String[] args) {
		new PhoneBook().processQueries();
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
		Iterator<Entry<String, Integer>> iterator = contacts.entrySet().iterator();

		if (query.type.equals("add")) {
			// if we already have contact with such number,
			// we should rewrite contact's name
			boolean wasFound = false;

			if (contacts.containsValue(query.number)) {
				while (iterator.hasNext()) {
					Entry<String, Integer> entry = iterator.next();
					Integer val = entry.getValue();

					if (val.equals(query.number)) {
						iterator.remove();
						contacts.put(query.name, query.number);
						break;
					}
				}
				wasFound = true;
			}
			if (!wasFound)
				contacts.put(query.name, query.number);

		} else if (query.type.equals("del")) {
			while (iterator.hasNext()) {
				Entry<String, Integer> entry = iterator.next();

				if (entry.getValue().equals(query.number)) {
					iterator.remove();
					break;
				}
			}
		} else {
			String response = "not found";
			for (Entry<String, Integer> entry : contacts.entrySet()) {
				if (entry.getValue() == query.number) {
					response = entry.getKey();
					break;
				}
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