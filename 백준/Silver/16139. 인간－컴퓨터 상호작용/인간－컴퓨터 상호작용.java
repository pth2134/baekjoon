import java.io.*;
import java.util.*;

class Main{
	
		
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			//a~z = 97~122 > 0~25
			char[] s = br.readLine().toCharArray();
			int[][] cnt = new int[s.length][26];
			
			cnt[0][s[0]-97] = 1;
			for(int i =1; i<s.length; i++) {
				int a = s[i] - 97;
				for(int j=0; j<a; j++) {
					cnt[i][j] = cnt[i-1][j];
				}
				cnt[i][a]= cnt[i-1][a] +1;
				for(int j=a+1; j<=25; j++) {
					cnt[i][j] = cnt[i-1][j];
				}
			}
			
			int t = Integer.parseInt(br.readLine());
			for(int i =0; i<t; i++) {
				st = new StringTokenizer(br.readLine());
				int al = st.nextToken().charAt(0)-97;
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int result = start>0? cnt[end][al]-cnt[start-1][al] : cnt[end][al];
				bw.write(result+"\n");
			}
			bw.flush();
		}
 }