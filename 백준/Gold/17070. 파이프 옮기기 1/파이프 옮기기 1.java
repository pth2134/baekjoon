import java.io.*;
import java.util.*;

class Main {
    static boolean[][] graph;
    static int n;
    static int m;
    static int cnt = 0;

    static void dfs0(int x, int y){//가로
        if(x==m&&y==m){cnt++; return;}
        int x_move = x+1;
        int y_move = y+1;
        if(x_move<n&&!graph[y][x_move]) {
            dfs0(x_move,y);
            if(y_move<n&&!graph[y_move][x_move]&&!graph[y_move][x]){
                dfs1(x_move,y_move);
            }
        }

    }
    static void dfs1(int x, int y){//대각선
        if(x==m&&y==m){cnt++; return;}
        int x_move = x+1;
        int y_move = y+1;
        if(x_move<n&&!graph[y][x_move]) {
            dfs0(x_move,y);
            if(y_move<n&&!graph[y_move][x_move]&&!graph[y_move][x]){
                dfs1(x_move,y_move);
            }
        }
        if(y_move<n&&!graph[y_move][x]) dfs2(x,y_move);
    }
    static void dfs2(int x, int y){//세로
        if(x==m&&y==m){cnt++; return;}
        int x_move = x+1;
        int y_move = y+1;
        if(y_move<n&&!graph[y_move][x]) {
            dfs2(x,y_move);
            if(x_move<n&&!graph[y_move][x_move]&&!graph[y][x_move]){
                dfs1(x_move,y_move);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = n-1;
        graph = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (br.read() == 49) graph[i][j] = true;
                br.read();
            }
        }

        dfs0(1,0);
        System.out.println(cnt);
    }
}