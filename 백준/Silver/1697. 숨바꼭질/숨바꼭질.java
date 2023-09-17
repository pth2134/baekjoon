import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
	static int n;
	static int k;
	static int k2;
	static int[] visited;
	static Queue<Integer> que = new LinkedList<>();

	static void bfs(int p) {
		visited[p] = 1;
		que.add(p);
		while(!que.isEmpty()){
			int poll = que.poll();
			if(poll == k) return;
			if(poll>0){
				if(visited[poll-1]==0) {
					que.add(poll-1);
					visited[poll-1] = visited[poll]+1;
				}
			}
			if(poll<k&&visited[poll+1]==0) {
				que.add(poll+1);
				visited[poll+1] = visited[poll]+1;
			}
			if(poll<=k2&&poll>0) {
				if(visited[poll*2]==0){
					que.add(poll*2);
					visited[poll*2] = visited[poll]+1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		k2 = k/2+1;
		visited = new int[Math.max(n+1,k+3)];
		bfs(n);
		System.out.println(visited[k]-1);
	}
 }