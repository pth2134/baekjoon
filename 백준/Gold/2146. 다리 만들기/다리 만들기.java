import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] graph;
    static boolean[][] visit;
    static boolean[][] visit_for_land;
    static Queue<Integer[]> que_for_point = new LinkedList<>();
    static Queue<Integer[]> que_for_bridge = new LinkedList<>();
    static Queue<Integer[]> que = new LinkedList<>();
    static int[] r_move = {-1, 1, 0, 0};
    static int[] c_move = {0, 0, -1, 1};
    static int min = Integer.MAX_VALUE;

    public static void bfs_for_point(int k) {
        while (!que_for_point.isEmpty()) {
            Integer[] poll = que_for_point.poll();
            for (int j = 0; j < 4; j++) {
                int row = poll[0] + r_move[j];
                int col = poll[1] + c_move[j];
                if (row >= 0 && row < n && col >= 0 && col < n && !visit_for_land[row][col]) {
                    visit_for_land[row][col] = true;
                    if (graph[row][col] == 1) {
                        que_for_point.add(new Integer[]{row, col});
                        graph[row][col] = k;
                    } else que_for_bridge.add(new Integer[]{row, col, 1});
                }
            }
        }
    }

    public static void bfs_for_bridge(int k) {
        int size = que_for_bridge.size();
        for (int i = 0; i < size; i++) {
            visit = new boolean[n][n];
            que.add(que_for_bridge.poll());
            while (!que.isEmpty()) {
                Integer[] rc = que.poll();
                int cnt = rc[2] + 1;
                for (int j = 0; j < 4; j++) {
                    int row = rc[0] + r_move[j];
                    int col = rc[1] + c_move[j];
                    if (row >= 0 && row < n && col >= 0 && col < n && !visit[row][col]) {
                        visit[row][col] = true;
                        if (graph[row][col] == 0) que.add(new Integer[]{row, col, cnt});
                        else if (graph[row][col] != k) {
                            min = Math.min(min, rc[2]);
                            que.clear();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visit = new boolean[n][n];
        visit_for_land = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = br.read() - '0';
                br.read();
            }
        }
        int k = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit_for_land[i][j] && graph[i][j] == 1) {
                    graph[i][j] = k;
                    que_for_point.add(new Integer[]{i, j});
                    bfs_for_point(k);
                    bfs_for_bridge(k);
                    k++;
                }
            }
        }

        System.out.println(min);
    }
}
