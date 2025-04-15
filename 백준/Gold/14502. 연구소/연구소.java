import java.io.IOException;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] arr;
    static List<int[]> virus;
    static int safe;
    static int[] x_move = {1, 0, 0, -1};
    static int[] y_move = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        n = reader.nextInt();
        m = reader.nextInt();
        arr = new int[n][m];

        virus = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = reader.nextInt();
                if (arr[i][j] == 2) virus.add(new int[]{i, j});
                if (arr[i][j] == 0) safe++;
            }
        }
        safe -= 3;
        int lastIdx = n * m;
        int max = 0;

        for (int i = 0; i < lastIdx - 2; i++) {
            if (arr[i / m][i % m] > 0) continue;
            arr[i / m][i % m] = 1;
            for (int j = 0; j < lastIdx - 1; j++) {
                if (arr[j / m][j % m] > 0) continue;
                arr[j / m][j % m] = 1;
                for (int k = 0; k < lastIdx; k++) {
                    if (arr[k / m][k % m] > 0) continue;
                    arr[k / m][k % m] = 1;
                    max = Math.max(max, bfs());
                    arr[k / m][k % m] = 0;
                }
                arr[j / m][j % m] = 0;
            }
            arr[i / m][i % m] = 0;
        }

        System.out.println(max);
    }

    public static int bfs() {
        Queue<int[]> que = new LinkedList<>();

        boolean[][] visited = new boolean[n][m];

        for (int[] v : virus) {
            que.add(v);
            visited[v[0]][v[1]] = true;
        }

        int s = safe;


        while (!que.isEmpty()) {
            int[] v = que.poll();
            int y = v[0];
            int x = v[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + x_move[i];
                int ny = y + y_move[i];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited[ny][nx]) continue;
                if (arr[ny][nx] == 0) {
                    s--;
                    que.add(new int[]{ny, nx});
                }
                visited[ny][nx] = true;
            }
        }

        return s;
    }


    static class Reader {
        final int SIZE = 1 << 15;
        byte[] buffer = new byte[SIZE];
        int index, size;

        boolean isNumber(byte c) {
            return 47 < c && c < 58;
        }

        int nextInt() throws IOException {
            int n = 0;
            byte c;
            while ((c = read()) <= 32) ;
            boolean neg = c == '-';
            if (neg) c = read();
            do n = (n << 3) + (n << 1) + (c & 15); while (isNumber(c = read()));
            return neg ? -n : n;
        }

        byte read() throws IOException {
            if (index == size) {
                size = System.in.read(buffer, index = 0, SIZE);
                if (size < 0) buffer[0] = -1;
            }
            return buffer[index++];
        }
    }
}