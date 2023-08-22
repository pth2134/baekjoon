import java.io.*;
import java.util.*;

class Main{
	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder str = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2) -> o2-o1);
			
			for(int i =0 ; i<n; i++) {
				int input = Integer.parseInt(br.readLine());
				if(input == 0) {
					if(!maxHeap.isEmpty()) {
						str.append(maxHeap.poll()+"\n");
					} else {
						str.append(0+"\n");
					}
				} else {
					maxHeap.add(input);
				}
			}
			
			System.out.println(str);
	}
 }