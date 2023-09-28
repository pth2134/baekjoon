import java.io.*;
import java.util.*;
class Main{
	static int n;
	static int x;
	static ArrayList<ArrayList<Integer[]>> list = new ArrayList<>();
	static int[][] visit;
	static PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o1[2]-o2[2]);
	//각각의 길을 지나는데 걸리는 시간을 고려하기 위해 우선순위 큐 사용
	// (결국 x에서 출발하기 때문에 x -> n마을에 최단거리로 도달할 수 있음)
	static Integer[] poll;
	static Integer[] arr;
	static ArrayList<Integer[]> l;
	// 12~14 line은 get함수 사용을 줄이기 위해 선언

	// x에서 출발 -> n 마을 도착? 방문여부, 시간 확인 -> 출발 지점을 n으로 바꿈(poll[0])
	// -> n에서 지나간 도로들을 모두 체크 visit[n][?]
	// -> 출발지점이 n(poll[0]=n)이고 다시 x로 도착했을 때(poll[1]=x) visit[n][x]를 확인
	// -> 최소 시간으로 도착했으면 max 초기화
	//(더 늦게 도착했기 때문에 가장 오래걸린 학생이 마지막으로 초기화된다.)
	static void bfs(){
		while(!pq.isEmpty()){
			poll = pq.poll();
			if(poll[0]==x){ //x에서 출발해서 poll[1]에 처음 도착함
				if(visit[poll[1]][poll[1]]==0){
					visit[poll[1]][poll[1]] = poll[2];
					pq.add(new Integer[]{poll[1],poll[1],poll[2]}); //x로 돌아가기 위해 poll[1]에서 출발
				}
			}
			l = list.get(poll[1]); //poll[1]마을의 길 list 가져오기
			for (int i = 0; i < l.size(); i++) {
				arr = l.get(i);// 길 = {목표마을, 거리} 이므로 arr에 저장
				int cnt = poll[2]+arr[1];
				if(visit[poll[0]][arr[0]]==0||visit[poll[0]][arr[0]]>cnt) { //출발마을,지나간 길인지 확인하기
					//-> 출발지점이 poll[0]인데 arr[0]에 간적이 있다 || 더 빨리 오는 방법이 있다
					visit[poll[0]][arr[0]] = cnt;
					pq.add(new Integer[]{poll[0],arr[0],cnt});
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		visit = new int[n+1][n+1];
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			list.get(Integer.parseInt(st.nextToken())).add(
					new Integer[]{
							Integer.parseInt(st.nextToken()),
							Integer.parseInt(st.nextToken())
					});
		}
		pq.add(new Integer[]{x,x,1});
		bfs();
		int max = 0;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max,visit[i][x]);
		}
		System.out.println(max-1);
	}
}