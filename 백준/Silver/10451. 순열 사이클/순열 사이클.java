import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int i =0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			boolean[] check = new boolean[n+1]; //방문한 곳 true
			int[] item = new int[n+1];
			int cnt = 0;
			
			st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= n; j++) {
				item[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 1; j < item.length; j++) {
				if(!check[j]) {
					check[j] = true;
					int k = j;
					while(true) {
						if(!check[item[k]]) {
							check[item[k]] =true;
							k = item[k];
						} else {
							cnt ++;
							break;
						}
					}
				}
			}
			bw.write(cnt+"\n");
		}

		bw.flush();
	}
	
}