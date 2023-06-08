import java.io.*;
import java.util.*;

public class Main {
			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			bw.write(prime(Long.parseLong(br.readLine()))+"\n");
		}
		br.close();
		bw.flush();		
		
		bw.close();		
	}	
	
	public static long prime(Long n) {
		if(n==0^n==1) {return 2;}
		boolean check = false;
		while(!check) {
			check = true;
			int maxDiv = (int) Math.sqrt(n);
			for(int i =2; i<=maxDiv; i++) {
				if(n%i==0) {
					n++;
					check = false;
					break;
				}
			}
		}
		return n;
		
	}
}