import java.io.*;
import java.util.*;

class Main{
	static int[][] screen;
	static int[][][] dp;
	static boolean clear = false;
	static StringBuilder str = new StringBuilder();
	static int mCnt = 0;
	static int zCnt = 0;
	static int pCnt = 0;
	
	static void check(int x, int y, int n, int size) {
		
		int s1 = dp[y+n][x+n][0]-dp[y+n][x][0]-dp[y][x+n][0]+dp[y][x][0];
		int s2 = dp[y+n][x+n][1]-dp[y+n][x][1]-dp[y][x+n][1]+dp[y][x][1];
		if(s1==size) {
			pCnt++;
		} else if(s2==size) {
			mCnt++;
		} else if(s1==0&&s2==0) {
			zCnt++;
		} else {
			int next = n/3;
			int nextS = size/9;
			int x1 = x+next;
			int y1 = y+next;
			int x2 = x1+next;
			int y2 = y1+next;
			check(x,y,next,nextS);
			check(x1,y,next,nextS);
			check(x2,y,next,nextS);
			check(x,y1,next,nextS);
			check(x1,y1,next,nextS);
			check(x2,y1,next,nextS);
			check(x,y2,next,nextS);
			check(x1,y2,next,nextS);
			check(x2,y2,next,nextS);
		}
	}
	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			int n = Integer.parseInt(br.readLine());
			
			dp = new int[n+1][n+1][2];
			screen = new int[n+1][n+1];
			for(int i =1; i<=n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <=n; j++) {
					screen[i][j] = Integer.parseInt(st.nextToken());
					if(screen[i][j]>=0) {
						dp[i][j][0] = dp[i-1][j][0]+dp[i][j-1][0]-dp[i-1][j-1][0]+screen[i][j];
						dp[i][j][1] = dp[i-1][j][1]+dp[i][j-1][1]-dp[i-1][j-1][1];
					} else {
						dp[i][j][0] = dp[i-1][j][0]+dp[i][j-1][0]-dp[i-1][j-1][0];
						dp[i][j][1] = dp[i-1][j][1]+dp[i][j-1][1]-dp[i-1][j-1][1]+1;
					}
				}
			}

			check(0,0,n,n*n);
			str.append(mCnt).append("\n").append(zCnt).append("\n").append(pCnt);
			System.out.println(str);
		}
 }