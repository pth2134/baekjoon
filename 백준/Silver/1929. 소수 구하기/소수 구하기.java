import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		boolean[] prime = new boolean[n+1];
		prime[0] = true;
		prime[1] = true;
		for(int i =2; i*i<=n; i++) {
			if(!prime[i]) {
				for(int j =i*i; j<=n; j+=i) {
					prime[j] =true;
				}
			}
		}
		
		for(int i =m; i<=n; i++) {
			if(!prime[i]) {
				bw.write(i+"\n");
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}
}