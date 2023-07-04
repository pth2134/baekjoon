import java.io.*;
import java.util.*;

public class Main {
	
	static int[][][] wf = new int[21][21][21];
	
	static int w(int a,int b,int c) {
		if(a<=0 || b<=0 || c<=0) return 1;
		if(a>20 || b>20 || c>20) return w(20,20,20);
		if(wf[a][b][c] != 0) return wf[a][b][c];
		if(a<b&&b<c) {
			return wf[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c); 
		} else {
			return wf[a][b][c] = w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			String input = br.readLine();
			if(input.equals("-1 -1 -1")) break;
			st = new StringTokenizer(input);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			System.out.printf("w(%d, %d, %d) = %d\n",a,b,c,w(a,b,c));
		}
	}
	
}