import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a1 = Integer.parseInt(st.nextToken());
			int a0 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(br.readLine());
			int n0 = Integer.parseInt(br.readLine());
			
			if(a1<=c && a1*n0+a0<=c*n0) {
				bw.write(1+"");
			}
			else {
				bw.write(0+"");
			}
			
			
			br.close();
			bw.flush();
			bw.close();
	
		}
		catch (Exception IO){
		}	
	}	

}