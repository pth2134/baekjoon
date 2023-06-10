import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> max = new ArrayList<>(); //가장 큰 수를 구하기 위한 리스트
		ArrayList<Integer> order = new ArrayList<>();//원래 순서를 유지하기 위한 리스트
		for(int i =0; i<t; i++) {
			int input = Integer.parseInt(br.readLine());
			max.add(input);
			order.add(input);
		}
		
		Collections.sort(max);
		int m = max.get(max.size()-1);
		
		boolean[] prime = new boolean[m+1]; //에라토스로 소수부터 다 구해놓기(가장 큰 수 한번만)
		prime[0]=prime[1]=true;		
		for(int i =2; i<=Math.sqrt(m); i++) {
			if(!prime[i]) {
				for(int j =i*i; j<=m; j+=i) {
					prime[j] = true;
				}
			}
		}
		
		for(int i =0; i<t; i++) {
			int n = order.get(i);
			int cnt = 0;
			//HashMap<Integer, Integer> goldb = new HashMap<>();
			for(int j =2; j<=n/2; j++) {
				if(!prime[j]) {
					if(!prime[n-j]) {
						//goldb.put(j, n-j);
						cnt++;
					}
				}
			}
			bw.write(cnt+"\n");
		}
		
		bw.flush();
		bw.close();
	}
	
}