import java.io.*;
import java.util.*;
class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer[]> mH = new PriorityQueue<>((o1,o2)->o2[1]-o1[1]);
		for (int i = 0; i < n; i++) {
			st =new StringTokenizer(br.readLine());
			Integer[] course = new Integer[2];
			course[0] = Integer.parseInt(st.nextToken());
			course[1] = Integer.parseInt(st.nextToken());
			mH.add(course);
		}
		int[] arr = new int[n];
		PriorityQueue<Integer> begin = new PriorityQueue<>((o1, o2) -> o2-o1);
		begin.add(mH.poll()[0]);
		for(int i =1; i<n; i++){
			Integer[] course = mH.poll();
			if(begin.peek() < course[1]) begin.add(course[0]);
			else {
				begin.poll();
				begin.add(course[0]);
			}
		}
		System.out.println(begin.size());
	}
}