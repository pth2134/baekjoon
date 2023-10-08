import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] graph = new int[n][m];
		boolean[][] visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Integer[]> que = new LinkedList<>();
		int full = n*m;
		int[] x_move = {-1,1,0,0};
		int[] y_move = {0,0,-1,1};
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] == 1) {
					que.add(new Integer[]{i, j, 0});
					full--;
					visit[i][j] = true;
				} else if (graph[i][j] == -1) {
					full--;
					visit[i][j] = true;
				}
			}
		}
		int day = 0;
		while(!que.isEmpty()){
			Integer[] poll = que.poll();
			for (int k = 0; k < 4; k++) {
				int x =poll[1]+x_move[k];
				int y =poll[0]+y_move[k];
				if(x>=0&&x<m&&y>=0&&y<n){
					if(!visit[y][x]){
						visit[y][x] = true;
						if(graph[y][x]==0){
							full--;
							graph[y][x]=1;
							day = poll[2]+1;
							que.add(new Integer[]{y,x,day});
						}
					}
				}
			}
		}
		if(full!=0){
			System.out.println(-1);
			return;
		}
		System.out.println(day);
	}
}