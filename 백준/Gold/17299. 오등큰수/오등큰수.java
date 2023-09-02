import java.io.*;
import java.util.*;

class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] seq = new int[n];
		int[] cnt = new int[1000001];
		int[] result = new int[n];
		Stack<Integer> s = new Stack<>();

		st = new StringTokenizer(br.readLine());
		for(int i =0; i <n; i++){
			seq[i] = Integer.parseInt(st.nextToken());
			cnt[seq[i]]++;
		}

		result[n-1] = -1;
		s.add(seq[n-1]);
		for (int i = n-2; i >= 0; i--) {
			int f_ai = cnt[seq[i]];
			int s_peek = s.peek();
			if(f_ai >= cnt[s_peek]){
				boolean check = false;
				int s_pop = s.pop();
				while(!s.isEmpty()){
					s_pop = s.pop();
					if(f_ai < cnt[s_pop]){
						check = true;
						s.add(s_pop);
						break;
					}
				}
				if(check) {
					result[i] = s_pop;
				} else{
					result[i] = -1;
				}
			} else{
				result[i] = s_peek;
			}
			s.add(seq[i]);
		}

		for(int i =0; i<n; i++){
			sb.append(result[i]).append(" ");
		}

		System.out.println(sb);
	}
 }