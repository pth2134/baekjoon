import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		try {
			int t = Integer.parseInt(br.readLine());
			st= new StringTokenizer(br.readLine());
			int min = Integer.parseInt(st.nextToken());
			int max = min;
			for(int i =0; i<t-1; i++) {
				int input =Integer.parseInt(st.nextToken());
				if(input < min) {
					min = input;
				} else if(input >max) {
				max = input;
				}
			}
			
			
			int result = min*max;
			bw.write(result+"");
			bw.flush();
			
		
		
		
		} catch (IOException e) {
			
		}
	}
}