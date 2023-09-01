import java.io.*;
import java.util.*;

class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		st = new StringTokenizer(br.readLine());
		
		for(int i =0; i <n; i++){
			s.add(Integer.parseInt(st.nextToken()));
		}
		int[] arr = new int[n];
		arr[0] = -1;
		s2.add(s.pop());
		
		for(int i =1; i<n; i++){
			int neg_now = s.pop();
			int s2_top = s2.peek();
			if(neg_now < s2_top){
				s2.add(neg_now);
				arr[i] = s2_top;
			} else{
				s2.pop();
				boolean get_neg = false;
				while(!s2.isEmpty()){
					if (neg_now >= s2.peek()) {
						s2.pop();
					} else{
						arr[i] = s2.peek();
						get_neg = true;
						break;
					}
				}
				if(!get_neg){
					arr[i] = -1;
				}
				s2.add(neg_now);
			}
		}

		for (int i = n-1; i >=0 ; i--) {
			sb.append(arr[i]).append(" ");
		}

		System.out.println(sb);
	}
 }