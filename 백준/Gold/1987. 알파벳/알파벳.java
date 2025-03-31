import java.io.IOException;

public class Main {
    static int[] x_move = {1, -1, 0, 0};
    static int[] y_move = {0, 0, 1, -1};
    static char[][] board;
    static boolean[] visited = new boolean[26];
    static int r;
    static int c;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        r = reader.nextInt();
        c = reader.nextInt();
        board = new char[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                board[i][j] = reader.nextChar();
            }
        }

        visited[board[0][0] - 65] = true;
        solve(0, 0, 1);
        System.out.println(max);
    }

    public static void solve(int row, int col, int cnt) {
        max = Math.max(max, cnt);
        for (int i = 0; i < 4; i++) {
            int x = row + x_move[i];
            int y = col + y_move[i];
            if (x < r && y < c && x >= 0 && y >= 0 && !visited[board[x][y] - 65]) {
                visited[board[x][y] - 65] = true;
                solve(x, y, cnt + 1);
                visited[board[x][y] - 65] = false;
            }
        }
    }

    static class Reader {
        final int SIZE = 1 << 15;
        byte[] buffer = new byte[SIZE];
        int index, size;

        int nextInt() throws IOException {
            int n = 0;
            byte c;
            while ((c = read()) <= 32) ;
            boolean neg = c == '-';
            if (neg) c = read();
            do n = (n << 3) + (n << 1) + (c & 15); while (isNumber(c = read()));
            return neg ? -n : n;
        }

        char nextChar() throws IOException {
            byte c;
            while ((c = read()) <= 32) ;
            return (char) c;
        }

        boolean isNumber(byte c) {
            return 47 < c && c < 58;
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