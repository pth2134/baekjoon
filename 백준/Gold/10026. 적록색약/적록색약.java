import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] graph;
	static int[][] visit;
	static int[] x_move = {1,-1,0,0};
	static int[] y_move = {0,0,1,-1};
	static Queue<Integer[]> que = new LinkedList<>();
	static ArrayList<HashSet<Integer>> list = new ArrayList<>();
	//인접한 area를 입력받는 hashset
	static int[] color;
	static int[] match;

	static void bfs(int area, HashSet<Integer> hash){
		while(!que.isEmpty()){
			Integer[] poll = que.poll();
			visit[poll[0]][poll[1]]=area;
			for (int i = 0; i < 4; i++) {
				int x = poll[1]+x_move[i];
				int y = poll[0]+y_move[i];
				if(x>=0&&x<n&&y>=0&&y<n){
					if(visit[y][x]==0&&color[area]==graph[y][x]){
						que.add(new Integer[]{y,x});
						visit[y][x] = area;
					}
					else if(visit[y][x]!=area&&visit[y][x]!=0&&color[area]!=66&&color[visit[y][x]]!=66) hash.add(visit[y][x]);
					//인접한&&자신의 area의 색상이 파랑이 아니고, 이미 방문한적이 있으면(자신의 area보다 작으면)
					//list의 area인덱스(hashset)에 인접한 area를 추가
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		visit = new int[n][n];
		color = new int[n*n+1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				graph[i][j] = br.read(); //R 82 G 71 B 66
			}
			br.read();
		}

		int area = 0;
		list.add(new HashSet<>());

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(visit[i][j]==0) {
					area++;
					list.add(new HashSet<>());
					que.add(new Integer[]{i,j});
					visit[i][j] = area;
					color[area] = graph[i][j];
					bfs(area, list.get(area));
					//한번의 bfs당 한area를 모두 방문함
				}
			}
		}

		sb.append(area).append(" ");
		match = new int[area+1];
		//적,녹 area가 하나가 될 때 두개이상의 area가 하나로 합쳐진 것을 알기 위해
		for (int i = 1; i <= area; i++) {
			match[i] = i;
		}
		for (int i = list.size()-1; i >1 ; i--) {
			HashSet<Integer> set = list.get(i);
			Iterator<Integer> iter = set.iterator();
			while(iter.hasNext()){
				int next = iter.next();
				// Find the root of the current group and the next group.
				int rootI = findRoot(i);
				int rootNext = findRoot(next);
				if(rootNext != rootI){
					// Merge groups if roots are different.
					match[rootNext] = match[rootI];
					area--;
				}
			}
		}

		sb.append(area);
		System.out.println(sb);
	}
	static int findRoot(int x) {
		if (match[x] == x)
			return x;
		else
			return match[x] = findRoot(match[x]);
	}
}
