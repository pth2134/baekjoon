import java.io.*;
import java.util.PriorityQueue;

class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2)->o2-o1);
		int dasom = Integer.parseInt(br.readLine());
		for(int i =1; i<n; i++){
			maxHeap.add(Integer.parseInt(br.readLine()));
		}

		int cnt = 0;
		if(!maxHeap.isEmpty()){
			while(true){
				int poll = maxHeap.poll();
				if(dasom <= poll){
					dasom++;
					maxHeap.add(poll-1);
					cnt++;
				} else {
					break;
				}
			}
		}
		System.out.println(cnt);
	}
 }