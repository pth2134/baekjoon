import java.io.*;
import java.util.*;

class Main{
	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder str = new StringBuilder();
			StringTokenizer st;
			int n = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1,o2)->{
				if(Math.abs(o1) > Math.abs(o2)){
					return 1;
				} else if(o1==-o2){
					return o1-o2;
				} else return -1;
			});
			
			for(int i =0 ; i<n; i++) {
				int input = Integer.parseInt(br.readLine());
				if(input == 0) {
					if(!minHeap.isEmpty()) {
						str.append(minHeap.poll()).append("\n");
					} else {
						str.append(0+"\n");
					}
				} else {
					minHeap.add(input);
				}
			}
			
			System.out.println(str);
	}
 }