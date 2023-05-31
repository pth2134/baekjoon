import java.io.*;
import java.util.*;

public class Main {
			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		String n = br.readLine();
		int[] count = new int[10];
		int[] countSum = new int[10];
		int[] a = new int[n.length()+1];
		int[] b = new int[n.length()+1];
		for(int i = 0; i<n.length(); i++) {
			a[i] = n.charAt(i)-48;
			count[a[i]]++;
		}
		
		countSum[0] = count[0];
		for(int i=1; i<=9; i++) {
			countSum[i] = countSum[i-1]+count[i];
		}
		
		for(int i=n.length()-1; i>=0; i--) {
			b[countSum[a[i]]]= a[i];
			countSum[a[i]]--;
		}
		
		for(int i=n.length(); i>=1; i--) {
			bw.write(b[i]+"");
		}
		bw.flush();		
		bw.close();		
	}	
}
