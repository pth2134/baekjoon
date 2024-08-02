import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] c_move = {0, 0, -1, 1};
	static int[] r_move = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] blocks = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				blocks[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		long white = 0;

		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < m - 1; j++) {
				int height = blocks[i][j] - 1;
                if(height < 0) continue;
                
				for (int k = 0; k < 4; k++) {
					int r = i + r_move[k];
					int c = j + c_move[k];

					if (height > blocks[r][c])
						height = blocks[r][c];
				}

				white += height;
			}
		}

		System.out.println(white);

	}

}
