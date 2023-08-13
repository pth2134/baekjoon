import java.io.*;
import java.util.*;

class Main{

	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder str = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[][] a = new int[n][k];
			
			
			for(int i =0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<k; j++) {
					a[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());
			int n2= Integer.parseInt(st.nextToken());
			int k2 = Integer.parseInt(st.nextToken());
			int[][] b = new int[n2][k2];
			
			for(int i =0; i<n2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<k2; j++) {
					b[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<k2; j++) {
					int p =0;
					for(int l=0; l<k; l++) {
						p+= a[i][l]*b[l][j];
					}
					str.append(p+" ");
				}
				str.append("\n");
			}
			System.out.println(str);
		}
 }