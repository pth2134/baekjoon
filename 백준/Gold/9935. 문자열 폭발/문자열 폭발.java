import java.io.*;
import java.util.*;

class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		sb.append(str);
		Stack<Integer> s = new Stack<>();
		String bomb = br.readLine();
		int l = bomb.length();
		int[] cnt = new int[str.length()/l+1];
		int cntIdx = 0;
		int idx = 0;

		for(int i =0; i<str.length(); i++){
			char a = str.charAt(i);
			if(a==bomb.charAt(idx)){
				s.add(++idx);
				if(idx==l){
					for (int j = 0; j < l; j++) {
						s.pop();
					}
					cnt[cntIdx] = i;
					cntIdx++;
					if(s.isEmpty()) {
						idx = 0;
					} else{
						idx = s.peek();
					}
				}
			} else if(a==bomb.charAt(0)) {
				s.add(1);
				idx = 1;
			} else {
				s.clear();
                idx = 0;
			}
		}
		int start = str.length()+1;
		for(int i = cntIdx-1; i>= 0; i--) {
			int end = cnt[i] +1;
			if(start < end) {
				end = start;
				start = end -l;
			} else{
				start = end -l;
			}
			sb.delete(start,end);
		}
		if(sb.toString().isEmpty()){
			System.out.println("FRULA");
		} else{
			System.out.println(sb);
		}
	}
 }