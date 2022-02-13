import java.util.*;
import java.io.*;

public class ComputeTreeHeight {
	class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeHeight {
		int n;
		int parent[];
		
		public class Node {
			private int number;
			private Node parent;
			private int parentIndex;
			private List<Integer> childrenIndices;
			private List<Node> children;
			
			public Node(int num) {
				number = num;
			}
			
			public void setNumber(int n) {
				number = n;
			}
			
			public void setParent(Node p) {
				parent = p;
			}
			
			public void setParentIdx(int p) {
				parentIndex = p;
			}
			
			public void setChild(Node node) {
				if (this.children == null)
					return;
				children.add(node);
			}
		}

		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			int rtidx = 0;
			
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
				if (parent[i] == -1)
					rtidx = i;
			}
			
			List<Node> nodes = new ArrayList<Node>();
			Node root = new Node(rtidx);
			
			
			for (int i = 0; i < n; i++) {
				if (i != rtidx) {
					Node no = new Node(i);
					no.setParentIdx(parent[i]);
					nodes.add(no);
				} else {
					nodes.add(root);
				}
			}
			
			for (int i = 0; i < n; i++) {
				if (parent[i] == -1) {
					Node ma = nodes.get(rtidx);
					ma.setChild(nodes.get(i));
				} else {
					Node ma = nodes.get(parent[i]);
					ma.setChild(nodes.get(i));
				}
			}
			
		
		}

		int computeHeight(Node root) {
			int height = 0;
			if (root == null)
				return height;
			if (root.children ==  null)
				return 1;
			for (Node child : root.children) {
				height = Math.max(height, computeHeight(child));
			}
			return height + 1;
		}

	}

	static public void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new ComputeTreeHeight().run();
				} catch (IOException e) {
				}
			}
		}, "1", 1 << 26).start();
	}

	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		//System.out.println(tree.computeHeight());
	}
}
