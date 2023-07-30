import java.io.*;
import java.util.*;

class Main{

	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			
			int n = Integer.parseInt(br.readLine());
			int[][] meeting = new int[n][2]; 
			
			for(int i =0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				meeting[i][0] = Integer.parseInt(st.nextToken());
				meeting[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(meeting, (o1, o2) -> {
				if(o1[1]==o2[1]) { return o1[0]-o2[1];}
				else return o1[1]-o2[1];}
			);
			
			int s = meeting[0][1];
			int cnt = 1;
			
			for(int i =1; i<n; i++) {
				if(meeting[i][0]>=s) {
					s = meeting[i][1];
					cnt++;
				}
			}
			bw.write(cnt+"");
			bw.flush();
		}
 }