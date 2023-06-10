import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<Integer> max = new ArrayList<>();
		ArrayList<Integer> order = new ArrayList<>();
		while(true) {
			int value = Integer.parseInt(br.readLine());
			if(value ==0) break;
			max.add(value);
			order.add(value);
		}
		
		Collections.sort(max);
		int n = max.get(max.size()-1);
		int m = 2*n;
		boolean[] prime = new boolean[m+1];
		prime[0]=prime[1]=true;
		
		for(int i =2; i<=Math.sqrt(m); i++) {
			if(!prime[i]) {
				for(int j =i*i; j<=m; j+=i) {
					prime[j] = true;
				}
			}
		}
		
		for(int i =0; i<order.size(); i++) {
			int cnt = 0;
			int n2 = order.get(i);
			int m2 = 2*n2;
			for(int j=n2+1; j<=m2; j++) {
				if(!prime[j]) cnt++;
			}
			bw.write(cnt+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}