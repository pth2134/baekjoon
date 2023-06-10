import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			int m = 2*n;
			if(n==0) break;
			boolean[] prime = new boolean[m+1];
			prime[0] = true;
			prime[1] = true;
			for(int i =2; i<=Math.sqrt(m); i++) {
				if(!prime[i]) {
					for(int j =i*i;j<=m; j+=i) {
						prime[j] =true;
					}
				}
			}
			
			int cnt =0;
			for(int i =n+1; i<=m; i++) {
				if(!prime[i]) {
					cnt++;
				}
			}
			bw.write(cnt+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}