import java.io.*;

class Main{
	static int[][] screen;
	static int[][] dp;
	static boolean clear = false;
	static StringBuilder str = new StringBuilder();
	static void check(int x, int y, int n, int size) {
		if(n==1) {
			str.append(screen[y+1][x+1]);
			return;
		}
		int s1 = dp[y+n][x+n]-dp[y+n][x]-dp[y][x+n]+dp[y][x];
		if(s1==size) {
			str.append("1");
		} else if(s1==0) {
			str.append("0");
		} else {
			str.append("(");
			int next = n/2;
			int nextS = size/4;
			check(x,y,next,nextS);
			check(x+next,y,next,nextS);
			check(x,y+next,next,nextS);
			checkLast(x+next,y+next,next,nextS);
		}
	}
	
	static void checkLast(int x, int y, int n, int size) {
		if(n==1) {
			str.append(screen[y+1][x+1]);
			str.append(")");
			return;
		}
		int s1 = dp[y+n][x+n]-dp[y+n][x]-dp[y][x+n]+dp[y][x];
		if(s1==size) {
			str.append("1");
		} else if(s1==0) {
			str.append("0");
		} else {
			str.append("(");
			int next = n/2;
			int nextS = size/4;
			check(x,y,next,nextS);
			check(x+next,y,next,nextS);
			check(x,y+next,next,nextS);
			checkLast(x+next,y+next,next,nextS);
		}
		str.append(")");
	}
	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int n = Integer.parseInt(br.readLine());
			
			dp = new int[n+1][n+1];
			screen = new int[n+1][n+1];
			for(int i =1; i<=n; i++) {
				String str = br.readLine();
				for (int j = 1; j <=n; j++) {
					screen[i][j] = str.charAt(j-1)-48;
					dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+screen[i][j];
				}
			}			
			check(0,0,n,n*n);
			System.out.println(str);
		}
 }