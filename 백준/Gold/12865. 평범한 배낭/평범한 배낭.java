import java.io.*;
import java.util.*;

class Main{
	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[] pack = new int[k+1];
			int[][] item = new int[n+1][2];
			
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				item[i][0] = Integer.parseInt(st.nextToken());
				item[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for(int i =1; i<=n; i++) {
				for(int j=k; j-item[i][0]>=0; j--) {
						pack[j] = Math.max(pack[j],item[i][1]+pack[j-item[i][0]]);
				}
			}
			bw.write(pack[k]+"");
			bw.flush();
		}
 }