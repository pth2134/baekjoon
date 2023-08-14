import java.io.*;
import java.util.*;

class Main{
	static int[][] a;

	static int n;
	static long b;	
	static StringBuilder str = new StringBuilder();
	
	static int[][] mp(int[][] r, int[][] r2) {
		int[][] nw = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int p =0;
				for(int l=0; l<n; l++) {
					p+= r[i][l]*r2[l][j];
				}
				nw[i][j] = p%1000;
			}
		}
		return nw;
	}
	
	static int[][] div(long b) {
		if(b==1) return a;
		long b2 = b%2;
		int[][] div2 = div(b/2);
		if(b2==0) {
			return mp(div2,div2);
		} else {
			return mp(mp(div2,div2),a);
		}
	}
	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Long.parseLong(st.nextToken());
			
			a = new int[n][n];
			int[][] result;
			for(int i =0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					a[i][j] = Integer.parseInt(st.nextToken())%1000;
				}
			}
			
			result = div(b);
			
			for(int i =0; i<n; i++) {
				for(int j=0; j<n; j++) {
					str.append(result[i][j]+" ");
				}
				str.append("\n");
			}
			
			System.out.println(str);
		}
 }