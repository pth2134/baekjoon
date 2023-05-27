import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			while(true) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				if(a==0) break;
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				if(a>=b+c||b>=a+c||c>=a+b) {
					bw.write("Invalid\n");
				}
				else if(a==b&&b==c) {
					bw.write("Equilateral\n");
				}
				else if(a==b||a==c||b==c) {
					bw.write("Isosceles\n");
				}
				else bw.write("Scalene\n");
			}
			
			br.close();
			bw.flush();
			bw.close();
	
		}
		catch (Exception IO){
		}	
	}	

}