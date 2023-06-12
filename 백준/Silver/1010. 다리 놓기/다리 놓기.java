import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		try {
			int t = Integer.parseInt(br.readLine());
			for(int i =0; i<t; i++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());
				int bin = m-n;
				int result = 1;
				//mC(m-n)/(m-n)!
				for(int j=0; j<bin;j++) {
					result*= m--;
					result/= (j+1);
				}
				bw.write(result+"\n");
			}
			bw.flush();
			
		
		
		
		
		
		} catch (IOException e) {
			
		}
	}
}
