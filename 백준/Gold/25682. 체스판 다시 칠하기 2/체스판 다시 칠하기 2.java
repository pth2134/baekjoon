import java.io.*;
import java.util.*;

class Main{

	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[][] bStart = new int[n+1][m+1];
			
			String str;
			for(int i =1; i<=n; i++) {
				str = br.readLine();
				for(int j =1; j<=m; j++) {
					if((i+j)%2==0^str.charAt(j-1)=='B') { //B로 시작했을 때 고쳐야하는 위치 카운트
						bStart[i][j] = bStart[i][j-1]+bStart[i-1][j]-bStart[i-1][j-1]+1;
					} else {
						bStart[i][j] = bStart[i][j-1]+bStart[i-1][j]-bStart[i-1][j-1];
					}
				}
			}
			int min = bStart[k][k];
			
			int result;
			int resultB;
			int resultW;
			
			int kk = k*k;
			for(int i =0; i<=n-k; i++) {
				for(int j =0; j<=m-k; j++) {
					resultB = bStart[i+k][j+k] -bStart[i][j+k] -bStart[i+k][j] +bStart[i][j];
					resultW = kk-resultB;
					result = resultB > resultW ? resultW : resultB;
					min = min > result ? result : min;
				}
			}
			
			bw.write(min+"");
			bw.flush();
		}
 }