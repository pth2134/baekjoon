import java.io.*;
import java.util.*;

public class Main {
			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		while(n-->0) {
			a[n] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(a);
		
		for(int i : a) {
			bw.write(i+"\n");
		}
		bw.flush();		
		bw.close();		
	}	
}