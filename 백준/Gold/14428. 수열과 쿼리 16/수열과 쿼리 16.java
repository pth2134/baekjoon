public class Main {

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int n = reader.nextInt();

		int[] arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = reader.nextInt();
		}

		int m = reader.nextInt();

		SegmentTree seg = new SegmentTree(arr);

		for (int i = 0; i < m; i++) {
			int command = reader.nextInt();

			if (command == 1) {
				seg.update(reader.nextInt(), reader.nextInt());
			} else {
				int query = seg.query(reader.nextInt(), reader.nextInt());
				sb.append(query).append('\n');
			}
		}

		System.out.println(sb);

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

		long nextLong() throws Exception {
			long n = 0;
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

class SegmentTree {
	private int[] tree;
	private int n;
	private int[] data;

	public SegmentTree(int[] data) {
		n = data.length;
		tree = new int[4 * n];
		this.data = data;
		buildTree(1, 0, n - 1);
	}

	private void buildTree(int node, int start, int end) {
		if (start == end) {
			tree[node] = start;
		} else {
			int mid = (start + end) / 2;
			int leftChild = 2 * node; // 루트로 부터 left, right 두개 씩 생기기 때문에 두배를 곱해서 자식 노드를 찾을 수 있다.
			int rightChild = 2 * node + 1;

			buildTree(leftChild, start, mid);
			buildTree(rightChild, mid + 1, end);

			tree[node] = data[tree[leftChild]] <= data[tree[rightChild]] ? tree[leftChild] : tree[rightChild];
		}
	}

	public int query(int L, int R) {
		return query(1, 0, n - 1, L, R);
	}

	public int query(int node, int start, int end, int L, int R) {
		if (R < start || end < L) {
			return L;
		}

		if (L <= start && end <= R) {
			return tree[node];
		}

		int mid = (start + end) / 2;
		int leftChild = 2 * node;
		int rightChild = 2 * node + 1;

		int left = query(leftChild, start, mid, L, R);
		int right = query(rightChild, mid + 1, end, L, R);

		return data[left] <= data[right] ? left : right;
	}

	public void update(int idx, int value) {
		data[idx] = value;
		update(1, 0, n - 1, idx, value);
	}

	public void update(int node, int start, int end, int idx, long value) {
		if (start == end) {
			return;
		}

		int mid = (start + end) / 2;
		int leftChild = 2 * node;
		int rightChild = 2 * node + 1;

		if (idx <= mid) {
			update(leftChild, start, mid, idx, value);
		} else {
			update(rightChild, mid + 1, end, idx, value);
		}

		tree[node] = data[tree[leftChild]] <= data[tree[rightChild]] ? tree[leftChild] : tree[rightChild];
	}

}
