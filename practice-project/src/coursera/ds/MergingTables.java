package coursera.ds;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

public class MergingTables {
	private final InputReader reader;
	private final OutputWriter writer;

	public MergingTables(InputReader reader, OutputWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		OutputWriter writer = new OutputWriter(System.out);
		new MergingTables(reader, writer).run();
		writer.writer.flush();
	}

	public class Table {
		Table parent;
		int rank;
		int numberOfRows;

		public Table(int numberOfRows) {
			this.numberOfRows = numberOfRows;
			rank = 0;
			parent = this;
		}

		public Table getParent() {
			// find super parent and compress path
			ArrayList<Table> parents = new ArrayList<Table>();
			Table root = this.parent;
			while (root != root.parent) {
				parents.add(root.parent);
				root = root.parent;
			}
			for (Table par : parents) {
				par.parent = root;
			}
			return root;
		}
	}

	int maximumNumberOfRows = -1;

	void merge(Table destination, Table source) {
		Table rd = destination.getParent();
		Table rs = source.getParent();
		if (rd == rs) {
			return;
		}
		// Otherwise, merge two components, using rank heuristic
		if (rs.rank >= rd.rank)
			rs.parent = rd;
		else {
			rd.parent = rs;
			if (rs.rank == rd.rank)
				rs.rank += 1;
		}
		rd.numberOfRows += rs.numberOfRows; // Copy all the rows from source to destination
		rs.numberOfRows = 0; // Clear the table source
		
		// Update Maximum
		if (this.maximumNumberOfRows < rd.numberOfRows)
			this.maximumNumberOfRows = rd.numberOfRows;
	}

	public void run() {
		int n = reader.nextInt();
		int m = reader.nextInt();
		Table[] tables = new Table[n];
		for (int i = 0; i < n; i++) {
			int numberOfRows = reader.nextInt();
			tables[i] = new Table(numberOfRows);
			maximumNumberOfRows = Math.max(maximumNumberOfRows, numberOfRows);
		}
		for (int i = 0; i < m; i++) {
			int destination = reader.nextInt() - 1;
			int source = reader.nextInt() - 1;
			merge(tables[destination], tables[source]);
			writer.printf("%d\n", maximumNumberOfRows);
		}
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}

	static class OutputWriter {
		public PrintWriter writer;

		OutputWriter(OutputStream stream) {
			writer = new PrintWriter(stream);
		}

		public void printf(String format, Object... args) {
			writer.print(String.format(Locale.ENGLISH, format, args));
		}
	}
}
