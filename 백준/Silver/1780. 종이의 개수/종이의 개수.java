import java.io.*;
import java.util.*;

class Main{
	static int[][] paper;
	static StringBuilder str = new StringBuilder();
	static int[] mzp = new int[3]; //0 m, 1 z, 2 p
	
	static void check(int x, int y, int n) {
		int begin = paper[y][x];
		for(int i = y; i< y+n; i++) {
			for(int j = x; j<x+n; j++) {
				if(paper[i][j]!=begin) {
					int next = n/3;
					for(int k =0; k <3; k++) {
						for(int l =0; l<3; l++) {
							check(x+l*next,y+k*next,next);
						}
					}
					return;
				}
			}
		}
		
		mzp[begin+1]++;
	}
	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			int n = Integer.parseInt(br.readLine());
			paper = new int[n+1][n+1];
			for(int i =1; i<=n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <=n; j++) {
					paper[i][j] = Integer.parseInt(st.nextToken());	
				}
			}

			check(1,1,n);
			str.append(mzp[0]).append("\n").append(mzp[1]).append("\n").append(mzp[2]);
			System.out.println(str);
		}
 }