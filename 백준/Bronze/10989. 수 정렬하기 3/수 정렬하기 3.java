import java.io.*;
import java.util.*;

public class Main {
			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n = Integer.parseInt(br.readLine());
		int[] count = new int[10001];
		int[] countSum = new int[10001];
		int[] a = new int[n+1];
		int[] b = new int[n+1];
		for(int i = 1; i<=n; i++) {
			a[i] = Integer.parseInt(br.readLine());
			count[a[i]]++;
		}
		
		for(int i=1; i<=10000; i++) {
			countSum[i] = countSum[i-1]+count[i];
		}
		
		for(int i=n; i>0; i--) {
			b[countSum[a[i]]]= a[i];
			countSum[a[i]]--;
		}
		
		for(int i=1; i<=n; i++) {
			bw.write(b[i]+"\n");
		}
		bw.flush();		
		bw.close();		
	}	
}
