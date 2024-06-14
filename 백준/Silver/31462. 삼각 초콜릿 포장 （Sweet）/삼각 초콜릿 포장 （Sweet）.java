import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int size = n * (n + 1) / 2;
		int[] tree = new int[size + 1];
		boolean[] visited = new boolean[size + 1];

		int idx = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				tree[idx++] = br.read();
			}
			br.read();
		}

		int i = 1;
		for (int j = 1; j <= n; j++) { // 세로
			for (int k = 1; k <= j; k++) { //가로
				if (!visited[i]) {
					visited[i] = true;
					if (tree[i] == 'R') {
						int l = i + j;
						int r = i + j + 1;
						if (l > size || r > size
							|| visited[l] || visited[r]
							|| tree[l] != 'R' || tree[r] != 'R') {
							System.out.println(0);
							return;
						}
						visited[l] = true;
						visited[r] = true;
					} else {
						int r = i + 1;
						int d = i + j + 1;

						if (r > size || d > size
							|| visited[r] || visited[d]
							|| k == j || tree[r] != 'B' || tree[d] != 'B') {
							System.out.println(0);
							return;
						}

						visited[r] = true;
						visited[d] = true;
					}
				}
				i++;
			}
		}

		System.out.println(1);
	}

}
