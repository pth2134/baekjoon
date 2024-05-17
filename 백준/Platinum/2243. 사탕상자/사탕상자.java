public class Main {

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();

		int n = reader.nextInt();

		SegmentTree seg = new SegmentTree();

		for (int i = 0; i < n; i++) {
			int cmd = reader.nextInt();
			if (cmd == 1) {
				int order = reader.nextInt();
				int idx = seg.query(order);
				seg.update(idx, -1);
				sb.append(idx).append('\n');
			} else {
				int idx = reader.nextInt();
				int value = reader.nextInt();
				seg.update(idx, value);
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

	public SegmentTree() {
		n = 1_000_000;
		tree = new int[4 * n + 1];
	}

	public int query(int order) {
		return query(1, 1, n, order, 0);
	}

	public int query(int node, int start, int end, int order, int cntSum) {
		if (start == end)
			return start;

		int mid = (start + end) / 2;
		int leftChild = 2 * node;
		int rightChild = 2 * node + 1;
		int rightCntSum = cntSum + tree[leftChild];

		if (order <= rightCntSum) {
			return query(leftChild, start, mid, order, cntSum);
		} else {
			return query(rightChild, mid + 1, end, order, rightCntSum);
		}
	}

	public void update(int idx, int value) {
		update(1, 1, n, idx, value);
	}

	public void update(int node, int start, int end, int idx, int value) {
		//idx = 맛, data[idx] = 해당 맛의 갯수
		if (start == end) {
			tree[node] += value;
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

		tree[node] = tree[leftChild] + tree[rightChild];
	}

}