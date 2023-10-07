import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] choice;
	static int[][] visit;
	static boolean[] check;
	static int team;

	static void dfs(int num, int cnt, int roop){
		int next = choice[num];
		visit[num][0] = cnt;
		visit[num][1] = roop;
		if(visit[next][0]!=0&&visit[next][1]==roop){
			team+= cnt-visit[next][0]+1;
			return;
		}
		if(visit[next][0]==0){
			dfs(next,cnt+1,roop);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			visit = new int[n+1][2];
			choice = new int[n+1];
			team = 0;

			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int input = Integer.parseInt(st.nextToken());
				choice[j] = input;
			}

			int roop = 1;
			for (int j = 1; j <= n; j++) {
				if(visit[j][0]==0){
					dfs(j,1,roop++);
				}
			}

			sb.append(n-team).append("\n");
		}
		System.out.println(sb);
	}
}