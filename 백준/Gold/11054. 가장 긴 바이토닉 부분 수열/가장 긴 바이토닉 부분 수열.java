import java.io.*;
import java.util.*;

class Main{
	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] seq = new int[n];
			int[] up = new int[n];
			int[] down = new int[n];
			for (int i = 0; i < n; i++) {
				seq[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			
			for(int i=0; i<n; i++) {
				//결과에 +1 해줘야 함
				
				for(int j=i+1; j<n; j++) {
					//왼쪽부터 증가하는 수열
					if(seq[j]>seq[i]&&up[j]<=up[i]) {
						up[j] = up[i]+1;
					}
				}
				int now = n-1-i;				
				for(int j=now-1; j>=0; j--) {
					//오른쪽부터 증가하는 수열
					if(seq[j]>seq[now]&&down[j]<=down[now]) {
						down[j] = down[now]+1;
					}
				}
			}
			
			for(int i=0; i<n; i++) {
				int result = up[i]+down[i];
				if(result > max) {
					max = result;
				}
			}
			bw.write(max+1+"");
			bw.flush();
		}
 }