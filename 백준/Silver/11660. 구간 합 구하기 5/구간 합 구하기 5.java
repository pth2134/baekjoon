import java.io.*;
import java.util.*;

class Main{

	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] range = new int[n+1][n+1];
			
			for(int i = 1; i<=n; i++) {
				st = new StringTokenizer(br.readLine());				
				for (int j = 1; j <= n; j++) {
					range[i][j] = range[i-1][j] + range[i][j-1] - range[i-1][j-1] + Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i =1; i<= m; i++) {
				st = new StringTokenizer(br.readLine());
	            int x1 = Integer.parseInt(st.nextToken());
	            int y1 = Integer.parseInt(st.nextToken());
	            int x2 = Integer.parseInt(st.nextToken());
	            int y2 = Integer.parseInt(st.nextToken());
	            int result = range[x2][y2] + range[x1-1][y1-1] - range[x2][y1-1] - range[x1-1][y2] ;
	            bw.write(result +"\n");
			}
			
			bw.flush();
		}
}