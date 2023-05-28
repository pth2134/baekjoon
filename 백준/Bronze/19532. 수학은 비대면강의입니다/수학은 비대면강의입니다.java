import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			br.close();
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			
			int x = (e*c-b*f)/(a*e-b*d);
			int y = (a*f-d*c)/(a*e-b*d);
			bw.write(x+" "+y);
			bw.flush();
			bw.close();
	
		}
		catch (Exception IO){
		}	
	}	

}