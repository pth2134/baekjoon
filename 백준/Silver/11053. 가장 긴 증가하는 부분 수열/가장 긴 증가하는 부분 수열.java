import java.io.*;
import java.util.*;

class Main{
	
		
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			
			int t= Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			int[] A = new int[t];
			int[] maxCnt = new int[t];
			
			int up = 0;
			int max = 0;
			
			for(int i = 0; i<t; i++) {
				A[i] = Integer.parseInt(st.nextToken());
				maxCnt[i] = 1;
			}
			
			for(int i=0; i<t; i++) {
				if(maxCnt[i] > max) {
					max = maxCnt[i];
				}
				up = A[i];
				int len = maxCnt[i]+1;
				for(int j=i+1; j<t; j++) {
					if(A[j]>up && maxCnt[j] < len) {
						maxCnt[j] = len;
					}
				}
				
			}
			
			bw.write(max+"");
			bw.flush();
		}
 }