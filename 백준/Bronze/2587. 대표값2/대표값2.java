import java.io.*;
import java.util.*;

public class Main {
			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = 5;
		int[] a = new int[n];
		int sum = 0;
		while(n-->0) {
			a[n] = Integer.parseInt(br.readLine());
			sum += a[n];
		}
		Arrays.sort(a);
		
		bw.write(sum/5+"\n"+a[2]);
		bw.flush();		
		bw.close();		
	}	
}
