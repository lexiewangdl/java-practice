package coursera.ds;

import java.util.*;

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
	
	// Binary tree node
	public class TreeNode {
		int key;
		TreeNode left, right; // Left child and right child
		int level;

		TreeNode(int val) {
			this.key = val;
			left = right = null;
			level = 0;
		}

		boolean isLeaf() {
			return left == null ? right == null : false;
		}
	}

	public class IsBST {

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
				if (i == 0) {
					root = tree[i];
					tree[i].level = 1;
				}
				left[i] = in.nextInt();
				right[i] = in.nextInt();
			}
			for (int i = 0; i < nodes; i++) {
				if (left[i] == -1) {
					tree[i].left = null;
				} else {
					tree[i].left = tree[left[i]];
					tree[i].left.level = tree[i].level + 1;
				}
				
				if (right[i] == -1) {
					tree[i].right = null;
				} else {
					tree[i].right = tree[right[i]];
					tree[i].right.level = tree[i].level + 1;
				}
			}
		}

		public ArrayList<TreeNode> resultIn = new ArrayList<TreeNode>();

		ArrayList<TreeNode> inOrder(TreeNode root) {
			inOrderTraversal(root);
			return resultIn;
		}

		public void inOrderTraversal(TreeNode node) {
			if (node == null)
				return;
			inOrderTraversal(node.left);
			resultIn.add(node);
			inOrderTraversal(node.right);
		}

		boolean isBinarySearchTree(TreeNode[] tree, int nodes) {
			inOrderTraversal(tree[0]);

			for (int i = 0; i < nodes - 1; i++) {
				TreeNode l = this.resultIn.get(i);
				TreeNode r = this.resultIn.get(i + 1);
				if (l.key > r.key)
					return false;
				else if (l.key == r.key && l.level > r.level)
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