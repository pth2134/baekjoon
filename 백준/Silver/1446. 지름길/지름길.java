import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		int min = goal+1;
		Integer[][] road = new Integer[n+1][3];
		int[] visit = new int[n];

		for (int i = 0; i < n; i++) {
			st= new StringTokenizer(br.readLine());
			road[i][0] = Integer.parseInt(st.nextToken());
			road[i][1] = Integer.parseInt(st.nextToken());
			road[i][2] = Integer.parseInt(st.nextToken());
		}
		road[n] = new Integer[]{0,0,1};

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
			ArrayList<Integer> a = list.get(i);
			for (int j = 0; j < n; j++) {
				if (road[j][1]<=goal) {
					if (road[j][0] >= road[i][1]) a.add(j);
				}
			}
		}

		PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
		pq.add(new Integer[]{n,1});
		while(!pq.isEmpty()){
			Integer[] poll = pq.poll();
			int start = road[poll[0]][1];
			min = Math.min(goal-start+poll[1],min);
			ArrayList<Integer> a = list.get(poll[0]);
			int size = a.size();
			for (int i = 0; i < size; i++) {
				int j = a.get(i);
				int t = poll[1]+road[j][2]+road[j][0]-start;
				if (visit[j]==0||visit[j]>t){
					visit[j]=t;
					pq.add(new Integer[]{j,t});
				}
			}
		}
		System.out.println(min-1);
	}
}