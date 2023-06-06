import java.io.*;
import java.util.*;

public class Main {
			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		bw.write(minMult(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()))+"");
		
		bw.flush();		
		bw.close();		
	}	
	
	public static long minMult(int a, int b) {
		int large = a>b? a:b;
		int small = a>b? b:a;
		int r1 = large;
		int r2 = small;
		while(r1%r2!=0) {
			small = r2;
			r2 = r1%small;
			r1 = small;
		}
		return ((long)a/r2)*b;
	}
}