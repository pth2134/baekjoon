import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] x_move = {-1,1,0,0};
        int[] y_move = {0,0,-1,1};

        int[][] visit = new int[n+1][m+1];
        Integer[] start = new Integer[2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                int input = Integer.parseInt(st.nextToken());
                if(input==1) continue;
                else if (input==0) visit[i][j] = 1; //1은 0으로, 0은 -1로 바꿔서 출력하도록
                else {
                    start[0] = i; start[1] = j;
                }
            }
        }

        Queue<Integer[]> q = new LinkedList<>();
        q.add(start);
        visit[start[0]][start[1]] = 1;
        while(!q.isEmpty()){
            Integer[] poll = q.poll();
            int cnt = visit[poll[0]][poll[1]] + 1;
            for (int i = 0; i < 4; i++) {
                int x = poll[1] + x_move[i];
                int y = poll[0] + y_move[i];
                if(x>0&&x<=m&&y>0&&y<=n&&visit[y][x]==0){
                    q.add(new Integer[]{y,x});
                    visit[y][x] = cnt;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sb.append(visit[i][j]-1).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}