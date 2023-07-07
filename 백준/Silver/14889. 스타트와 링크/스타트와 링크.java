import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] s;
	static boolean[] zeroTeam; //true면 0팀
	static int t;
	static int[] zn;
	static int[] xzn;
	static int min = 2000;
	
	static void team(int i, int depth, int xdepth) {
		
		if(depth == t) {
			int x= xdepth;
			for(int j = zn[t-1]+1; j<n; j++) {
				if(!zeroTeam[j]) {
					xzn[x++] = j;
				}
			}
			int result = sum(0, zn) - sum(0, xzn);
			if(result < 0) result *= -1;
			if(result < min) min = result;
			return;
		}
		//0이 포함된 팀과 아닌 팀, 0은 true니까 1부터 입력
		for(int j = i; j<n-t+1+depth; j++) {
			int x= xdepth;
			zeroTeam[j] = true;
			zn[depth] = j;
			for(int k = zn[depth-1]+1; k<zn[depth]; k++) {
				if(!zeroTeam[k]) {
					xzn[x++] = k;
				}
			}
			team(j+1,depth+1,x);
			zeroTeam[j] = false;
		}
	}
	
	static int sum(int k, int[] team) {
		if(k == t) return 0;
		int p = 0;
		for(int i =k+1; i<t; i++) {
			p+= s[team[k]][team[i]] + s[team[i]][team[k]];
		}
		return p + sum(k+1,team);
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		t = n/2;
		s = new int[n][n];
		zn = new int[t];
		xzn = new int[t];
		zeroTeam = new boolean[n];
		zeroTeam[0] = true;
		for(int i =0; i<n; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j <n; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		team(1, 1, 0);
		bw.write(min+"");
		bw.flush();
	}
	
}