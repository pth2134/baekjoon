import java.io.IOException;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] arr;
    static List<int[]> chickens;
    static boolean[][] visited;
    static Queue<int[]> que = new LinkedList<>();
    static int[] survivors;
    static int min = Integer.MAX_VALUE;
    static int[] x_move = {-1, 0, 1, 0};
    static int[] y_move = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        n = reader.nextInt();
        m = reader.nextInt();
        arr = new int[n][n];
        visited = new boolean[n][n];
        chickens = new ArrayList<>();
        survivors = new int[m + 1];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int input = reader.nextInt();
                if (input == 2) {
                    chickens.add(new int[]{i, j});
                    arr[i][j] = 0;
                    continue;
                }
                arr[i][j] = input;
            }
        }

        int last = chickens.size() - m + 1;
        for (int i = 0; i < last; i++) {
            solve(1, i, last);
        }

        System.out.println(min);
    }

    public static void solve(int depth, int idx, int last) {
        int[] chicken = chickens.get(idx);
        survivors[depth] = idx;

        if (depth == m) {
            for (int i = 1; i <= m; i++) {
                int[] survivor = chickens.get(survivors[i]);
                que.add(new int[] {survivor[0], survivor[1], 0});
                visited[survivor[0]][survivor[1]] = true;
            }

            bfs();
            visited = new boolean[n][n];
            return;
        }

        int nl = last + 1;
        for (int i = idx + 1; i <= last; i++) {
            solve(depth + 1, i, nl);
        }
    }

    public static void bfs() {
        int chicken_distance = 0;

        while (!que.isEmpty()) {
            int[] poll = que.poll();
            int x = poll[0];
            int y = poll[1];
            if(arr[x][y] == 1) {
                chicken_distance += poll[2];
            }
            int cnt = poll[2] + 1;

            for (int i = 0; i < 4; i++) {
                int nx = x + x_move[i];
                int ny = y + y_move[i];
                if (nx < n && nx >= 0 && ny < n && ny >= 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    que.add(new int[]{nx, ny, cnt});
                }
            }
        }

        min = Math.min(min, chicken_distance);
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