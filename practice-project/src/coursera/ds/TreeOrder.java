package coursera.ds;

import java.util.*;
import java.io.*;

public class TreeOrder {
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

	public class TreeOrders {

		public ArrayList<Integer> resultIn = new ArrayList<Integer>();
		public ArrayList<Integer> resultPre = new ArrayList<Integer>();
		public ArrayList<Integer> resultPost = new ArrayList<Integer>();

		public ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
		public TreeNode root;

		public class TreeNode {
			int key;
			TreeNode parent;
			TreeNode left, right; // Left child and right child

			TreeNode(int value) {
				this.key = value;
				left = right = null;
			}

			boolean isLeaf() {
				return left == null ? right == null : false;
			}

		}

		int n;
		int[] key, left, right;

		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			ArrayList<Integer> key = new ArrayList<Integer>(n);
			ArrayList<Integer> left = new ArrayList<Integer>(n);
			ArrayList<Integer> right = new ArrayList<Integer>(n);
			for (int i = 0; i < n; i++) {
				key.add(i, in.nextInt());
				left.add(i, in.nextInt());
				right.add(i, in.nextInt());
			}

			for (int i = 0; i < n; i++) {
				if (i == 0) {
					root = new TreeNode(key.get(i));
					nodes.add(root);
				} else {
					TreeNode node = new TreeNode(key.get(i));
					nodes.add(node);
				}
			}

			for (int i = 0; i < n; i++) {

				if (left.get(i) == -1) {
					nodes.get(i).left = null;
				} else {
					nodes.get(i).left = nodes.get(left.get(i));
				}

				if (right.get(i) == -1) {
					nodes.get(i).right = null;
				} else {
					nodes.get(i).right = nodes.get(right.get(i));
				}
			}

		}

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

		ArrayList<Integer> preOrder(TreeNode root) {
			preOrderTraversal(root);
			return resultPre;
		}

		public void preOrderTraversal(TreeNode tree) {
			if (tree == null)
				return;
			resultPre.add(tree.key);
			preOrderTraversal(tree.left);
			preOrderTraversal(tree.right);
		}

		ArrayList<Integer> postOrder(TreeNode root) {
			postOrderTraversal(root);
			return resultPost;
		}
		
		public void postOrderTraversal(TreeNode tree) {
			if (tree == null)
				return;
			postOrderTraversal(tree.left);
			postOrderTraversal(tree.right);
			resultPost.add(tree.key);
		}
	}

	static public void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new TreeOrder().run();
				} catch (IOException e) {
				}
			}
		}, "1", 1 << 26).start();
	}

	public void print(ArrayList<Integer> rsl) {
		for (Integer a : rsl) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public void run() throws IOException {
		TreeOrders to = new TreeOrders();
		to.read();
		print(to.inOrder(to.root));
		print(to.preOrder(to.root));
		print(to.postOrder(to.root));
	}
}


