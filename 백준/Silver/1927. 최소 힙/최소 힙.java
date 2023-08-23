import java.io.*;
import java.util.*;

class Main{
	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder str = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			
			for(int i =0 ; i<n; i++) {
				int input = Integer.parseInt(br.readLine());
				if(input == 0) {
					if(!minHeap.isEmpty()) {
						str.append(minHeap.poll()+"\n");
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