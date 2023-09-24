import java.io.*;
import java.util.*;
class Main{
	static int n;
	static int[][] graph;
	static int size = 2;
	static int exp = 0;
	static int[] y_move = {-1,0,0,1};//위, 왼쪽을 우선 탐색
	static int[] x_move = {0,-1,1,0};
	static boolean[][] visit;
	static PriorityQueue<Integer[]> que = new PriorityQueue<>(((o1, o2) -> {
		if(o1[2]==o2[2]){
			if(o1[0]==o2[0]) return o1[1]-o2[1];
			else return o1[0]-o2[0];
		} else{
			return o1[2]-o2[2];
		}
	}));
	static void bfs(int y, int x,int cnt){
		for (int i = 0; i < 4; i++) {
			int y2 = y+y_move[i];
			int x2 = x+x_move[i];
			if(y2>0&&x2>0&&y2<=n&&x2<=n) {
				if(!visit[y2][x2]&&graph[y2][x2]<=size){
					visit[y2][x2] = true;
					Integer[] dest = {y2,x2,cnt+1};
					que.add(dest);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		graph = new int[n+2][n+2];
		visit = new boolean[n+1][n+1];
		int[] loc = new int[2];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int input = Integer.parseInt(st.nextToken());
				graph[i][j]= input;
				if(input==9) {
					loc[0] = i;
					loc[1] = j;
					graph[i][j] = 0;
				}
			}
		}
		int last_cnt = 0;
		visit[loc[0]][loc[1]]= true;
		bfs(loc[0],loc[1],0);
		while(!que.isEmpty()){
			Integer[] poll = que.poll();
			if (graph[poll[0]][poll[1]]>0&&graph[poll[0]][poll[1]]<size) {
				graph[poll[0]][poll[1]] = 0;
				last_cnt += poll[2];
				poll[2] = 0;
				visit = new boolean[n+1][n+1];
				visit[poll[0]][poll[1]]=true;
				que.clear();
				exp++;
				if (exp==size){
					size++;
					exp =0;
				}
			}
			bfs(poll[0],poll[1],poll[2]);
		}
		System.out.println(last_cnt);
	}
}