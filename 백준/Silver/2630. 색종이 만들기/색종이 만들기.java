import java.io.*;
import java.util.*;

class Main{
	static int[][] paper;
	static int bCnt = 0;
	static int wCnt = 0;
	static void cut(int s, int x, int y) {
		int check = paper[x+s][y+s] - paper[x][y+s] -paper[x+s][y] + paper[x][y];
		if(check == s*s) {
			bCnt++;
			return;
		} else if(check == 0) {
			wCnt++;
			return;
		}
		int s2 = s/2;
		cut(s2,x,y);
		cut(s2,x+s2,y);
		cut(s2,x,y+s2);
		cut(s2,x+s2,y+s2);
	}
	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			int n = Integer.parseInt(br.readLine());
			
			paper = new int[n+1][n+1];
			
			for(int i = 1; i<=n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j<=n; j++) {
					paper[i][j] = paper[i][j-1]+paper[i-1][j]-paper[i-1][j-1]+Integer.parseInt(st.nextToken());
				}
			}
			
			cut(n,0,0);
			bw.write(wCnt+"\n"+bCnt);
			bw.flush();
		}
 }