import java.io.*;
import java.util.*;
class Main{
	static int n;
	static int m;
	static int[] student; //학생 레벨 저장
	static int[] find_min; //가장 낮은 레벨의 학생찾기
	static ArrayList<Queue<Integer>> list = new ArrayList<>();
	static boolean[] visit;
	static int dfs(int s){
		Queue<Integer> q = list.get(s);
		int size = q.size();
		int level = student[s];
		for (int i = 0; i < size; i++) {
			int poll = q.poll();
			if(!visit[poll]) level = Math.max(level,dfs(poll)+1);
		}
		return student[s]=level;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		student = new int[n+1];
		find_min = new int[n+1];
		visit = new boolean[n+1];
		Queue<Integer> bottom = new LinkedList<>();

		for (int i = 0; i <= n; i++) {
			list.add(new LinkedList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(b).add(a);
			find_min[a]++;
		}

		for (int i = 1; i <= n; i++) {
			if (find_min[i]==0) bottom.add(i);//자기보다 작은애가 없으면 큐에 추가
		}

		while(!bottom.isEmpty()){
			dfs(bottom.poll());
		}

		ArrayList<Queue<Integer>> sort = new ArrayList<>();
		int size = -1; //sort의 인덱스와 i를 맞춰주기 위함
		for (int i = 1; i <= n; i++) {
			while (size<=student[i]){
				sort.add(new LinkedList<>());
				size++;
			}
			sort.get(student[i]).add(i);
		}
		for (int i = 0; i <= size; i++) {
			Queue<Integer> s = sort.get(i);
			while(!s.isEmpty()){
				sb.append(s.poll()).append(" ");
			}
		}

		System.out.println(sb);
	}
}