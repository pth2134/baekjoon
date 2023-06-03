import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			
			int n = Integer.parseInt(br.readLine());
			boolean[] sg = new boolean[20000001]; //-10000000~0 0~10000000, 1~10000000 1..1..~2..0
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				sg[Integer.parseInt(st.nextToken())+10000000] = true;		
			}
			
			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i =0; i<m; i++) {
				int check = Integer.parseInt(st.nextToken());
				if(sg[check+10000000]) bw.write("1 ");
				else bw.write("0 ");
			}
			
			bw.flush();
			bw.close();
	
		}
		catch (Exception IO){
		}	
	}	
	

}