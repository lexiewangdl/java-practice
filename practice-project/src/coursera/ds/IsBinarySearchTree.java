package coursera.ds;

import java.util.*;
import java.io.*;

public class IsBinarySearchTree {
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

	public class IsBST {
		public class TreeNode {
			int key;
			TreeNode parent;
			TreeNode left, right; // Left child and right child

			TreeNode(int val) {
				this.key = val;
				left = right = null;
			}

			boolean isLeaf() {
				return left == null ? right == null : false;
			}

		}

		int nodes;
		TreeNode[] tree;

		void read() throws IOException {
			FastScanner in = new FastScanner();
			nodes = in.nextInt();
			tree = new TreeNode[nodes];
			int[] left = new int[nodes];
			int[] right = new int[nodes];
			
			for (int i = 0; i < nodes; i++) {
				tree[i] = new TreeNode(in.nextInt());
				left[i] = in.nextInt();
				right[i] = in.nextInt();
			}
			for (int i = 0; i < nodes; i++) {
				tree[i].left = left[i] == -1 ? null : tree[left[i]];
				tree[i].right = right[i] == -1 ? null : tree[right[i]];
			}
		}

		// In-order Traversal

		public ArrayList<Integer> resultIn = new ArrayList<Integer>();

		ArrayList<Integer> inOrder(TreeNode root) {
			inOrderTraversal(root);
			return resultIn;
		}

		public void inOrderTraversal(TreeNode tree) {
			if (tree == null)
				return;
			inOrderTraversal(tree.left);
			resultIn.add(tree.key);
			inOrderTraversal(tree.right);
		}

		boolean isBinarySearchTree(TreeNode[] tree, int nodes) {
			inOrderTraversal(tree[0]);
			for (int i = 0; i < nodes - 1; i++) {
				if (this.resultIn.get(i) > this.resultIn.get(i+1))
					return false;
			}
			return true;
		}
	}

	static public void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new IsBinarySearchTree().run();
				} catch (IOException e) {
				}
			}
		}, "1", 1 << 26).start();
	}

	public void run() throws IOException {
		IsBST tree = new IsBST();
		tree.read();
		if (tree.isBinarySearchTree(tree.tree, tree.nodes)) {
			System.out.println("CORRECT");
		} else {
			System.out.println("INCORRECT");
		}
	}
}
