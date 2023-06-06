import java.io.*;
import java.util.*;

public class Main {
			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int[] a = new int[2];
		int[] b = new int[2];
		a[0] = Integer.parseInt(st.nextToken());
		a[1] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		b[0] = Integer.parseInt(st.nextToken());
		b[1] = Integer.parseInt(st.nextToken());
		int[] ab = minMult(a,b);
		bw.write(ab[0]+" "+ab[1]);
		
		bw.flush();		
		bw.close();		
	}	
	
	public static int[] minMult(int[] a, int[] b) {
		int[] ab = new int[2];
		ab[0] = a[0]*b[1]+b[0]*a[1];
		ab[1] = a[1]*b[1];
		int large = ab[0]>ab[1]? ab[0]:ab[1];
		int small = ab[0]>ab[1]? ab[1]:ab[0];
		int r1 = large;
		int r2 = small;
		while(r1%r2!=0) {
			small = r2;
			r2 = r1%small;
			r1 = small;
		}
		ab[0] /= r2;
		ab[1] /= r2;
		return ab;
	}
}
