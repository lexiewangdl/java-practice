package coursera.ds;

import java.util.*;

import coursera.ds.IsBinarySearchTree.FastScanner;
import coursera.ds.IsBinarySearchTree.IsBST.TreeNode;

import java.io.*;

public class IsBSTHard {
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
		TreeNode root;

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
			if (nodes != 0)
				root = tree[0];
		}

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
		
		public static int getLevel(TreeNode root, int key, int level) {
			if (root == null)
				return 0;
			if (root.key == key)
				return level;
			int result = getLevel(root.left, key, level + 1);
			if (result != 0) {
				return result;
			}
			result = getLevel(root.right, key, level + 1);
			return result;
		}
		
		public static boolean checkLevel(TreeNode root, int key1, int key2, int level) {
			int lev1 = getLevel(root, key1, level);
			int lev2 = getLevel(root, key2, level);
			return lev1 > lev2 ? true : false;
		}

		boolean isBinarySearchTree(TreeNode[] tree, int nodes) {
			inOrderTraversal(tree[0]);

			for (int i = 0; i < nodes - 1; i++) {
				if (this.resultIn.get(i) > this.resultIn.get(i + 1))
					return false;
				else if (this.resultIn.get(i) == this.resultIn.get(i + 1) && !checkLevel(this.root, i, i+1, 0))
					return false;
			}
			return true;
		}
	}

	static public void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new IsBSTHard().run();
				} catch (IOException e) {
				}
			}
		}, "1", 1 << 26).start();
	}

	public void run() throws IOException {
		IsBST tree = new IsBST();
		tree.read();
		if (tree.nodes == 0 || tree.isBinarySearchTree(tree.tree, tree.nodes)) {
			System.out.println("CORRECT");
		} else {
			System.out.println("INCORRECT");
		}
	}
}