import java.io.*;
import java.util.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2)-> o2-o1);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			minHeap.add(Integer.parseInt(st.nextToken()));
		}

		st= new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			maxHeap.add(Integer.parseInt(st.nextToken()));
		}

		long sum = 0;
		for (int i = 0; i < n; i++) sum += minHeap.poll() * maxHeap.poll();

		System.out.println(sum);
	}
 }