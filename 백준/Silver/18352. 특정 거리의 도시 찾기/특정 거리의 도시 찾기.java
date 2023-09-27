import java.io.*;
import java.util.*;
class Main{
	static int n;
	static int m;
	static int k;
	static ArrayList<Queue<Integer>> list = new ArrayList<>();
	static Queue<Integer[]> que = new LinkedList<>();
	static boolean[] visit;
	static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	static void bfs(){
		while(!que.isEmpty()){
			Integer[] poll = que.poll();
			if(poll[1]==k) minHeap.add(poll[0]);
			int cnt = poll[1]+1;
			Queue<Integer> q = list.get(poll[0]);
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int p = q.poll();
				if(!visit[p]) {
					visit[p] = true;
					que.add(new Integer[]{p,cnt});
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		visit = new boolean[n+1];

		for (int i = 0; i <= n; i++) {
			list.add(new LinkedList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			list.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
		}

		que.add(new Integer[]{x,0});
		visit[x] = true;
		bfs();
		int size = minHeap.size();
		if(size==0) sb.append(-1);
		else{
			for (int i = 0; i < size; i++) {
				sb.append(minHeap.poll()).append("\n");
			}
		}
		System.out.println(sb);
	}
}