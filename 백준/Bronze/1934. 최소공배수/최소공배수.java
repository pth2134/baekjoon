import java.io.*;
import java.util.*;

public class Main {
			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		for(int i =0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			bw.write(minMult(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()))+"\n");
		}
		
		bw.flush();		
		bw.close();		
	}	
	
	public static int minMult(int a, int b) {
		int maxDiv=1;
		int m = 2;
		while(m<=a&&m<=b) {
			if(a%m==0&&b%m==0) {
				maxDiv = m;
			}
			m++;
		}
		return (a/maxDiv)*b;
	}
}