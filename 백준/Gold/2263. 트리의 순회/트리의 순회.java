public class Main {
	static int n;
	static int[] inorder;
	static int[] postorder;
	static StringBuilder sb = new StringBuilder();
	static int lastPost;

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		n = reader.nextInt();
		inorder = new int[n];
		postorder = new int[n];
		lastPost = n - 2;

		for (int i = 0; i < n; i++) {
			inorder[i] = reader.nextInt();
		}
		for (int i = 0; i < n; i++) {
			postorder[i] = reader.nextInt();
		}

		Node rootNode = new Node(postorder[n - 1]);
		int inorderRoot = n - 1;

		if (n > 1) {
			for (int i = 0; i < n; i++) {
				if (inorder[i] == rootNode.value)
					inorderRoot = i;
			}
			buildBinaryTree(inorderRoot, rootNode, 0, n - 1);
		}

		output(rootNode);

		System.out.println(sb);
	}

	public static void buildBinaryTree(int inorderRoot, Node rootNode, int start, int end) {
		if (lastPost < 0)
			return;

		int rootValue = rootNode.value;

		int nextRootIdx = isRight(inorderRoot, end, lastPost);
		if (nextRootIdx != -1) {
			lastPost--;
			rootNode.right = new Node(inorder[nextRootIdx]);
			buildBinaryTree(nextRootIdx, rootNode.right, inorderRoot + 1, end);
		}

		if (lastPost < 0)
			return;

		nextRootIdx = isLeft(start, inorderRoot, lastPost);
		if (nextRootIdx != -1) {
			lastPost--;
			rootNode.left = new Node(inorder[nextRootIdx]);
			buildBinaryTree(nextRootIdx, rootNode.left, start, inorderRoot - 1);
		}
	}

	public static int isRight(int start, int end, int rootIdx) {
		int rootValue = postorder[rootIdx];

		for (int i = start; i <= end; i++) {
			if (inorder[i] == rootValue)
				return i;
		}

		return -1;
	}

	public static int isLeft(int start, int end, int rootIdx) {
		int rootValue = postorder[rootIdx];

		for (int i = end; i >= start; i--) {
			if (inorder[i] == rootValue)
				return i;
		}

		return -1;
	}

	static class Node {
		int value;

		Node left;
		Node right;

		Node(int value) {
			this.value = value;
		}
	}

	public static void output(Node rootNode) {
		sb.append(rootNode.value).append(' ');

		if (rootNode.left != null)
			output(rootNode.left);
		if (rootNode.right != null)
			output(rootNode.right);
	}

	static class Reader {
		final int SIZE = 1 << 15;
		byte[] buffer = new byte[SIZE];
		int index, size;

		int nextInt() throws Exception {
			int n = 0;
			byte c;
			while ((c = read()) <= 32)
				;
			boolean neg = c == '-' ? true : false;
			if (neg)
				c = read();
			do
				n = (n << 3) + (n << 1) + (c & 15);
			while (isNumber(c = read()));
			return neg ? -n : n;
		}

		boolean isNumber(byte c) {
			return 47 < c && c < 58;
		}

		byte read() throws Exception {
			if (index == size) {
				size = System.in.read(buffer, index = 0, SIZE);
				if (size < 0)
					buffer[0] = -1;
			}
			return buffer[index++];
		}
	}
}
