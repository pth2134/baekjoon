import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 10000;
    static StringBuilder result = new StringBuilder();
    static String[] strs = {"","D","S","L","R"};

    private static void bfs(int a, int b) {
        int[][] visit = new int[MAX][2];
        StringBuilder sb = new StringBuilder();
        Queue<Integer> que = new LinkedList<>();
        que.add(a);

        while (!que.isEmpty()) {
            int c = que.poll();
            if (c == b) {
                while(c!=a){
                    for (int i = 1; i <= 4; i++) {
                        if(visit[c][1]==i) sb.append(strs[i]);
                    }
                    c=visit[c][0];
                }
                result.append(sb.reverse()).append("\n");
                return;
            }
            //d
            int c2 = (c << 1) % MAX;
            if (visit[c2][1]==0) {
                visit[c2][0] = c;
                visit[c2][1] = 1;
                que.add(c2);
            }
            //s
            c2 = c - 1;
            if (c2 < 0) c2 += MAX;
            if (visit[c2][1]==0) {
                visit[c2][0] = c;
                visit[c2][1] = 2;
                que.add(c2);
            }
            //l
            c2 = (c * 10 + c / 1000) % MAX;
            if (visit[c2][1]==0) {
                visit[c2][0] = c;
                visit[c2][1] = 3;
                que.add(c2);
            }
            //r
            c2 = c / 10 + c % 10 * 1000;
            if (visit[c2][1]==0) {
                visit[c2][0] = c;
                visit[c2][1] = 4;
                que.add(c2);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bfs(a,b);
        }
        System.out.println(result);
    }
}