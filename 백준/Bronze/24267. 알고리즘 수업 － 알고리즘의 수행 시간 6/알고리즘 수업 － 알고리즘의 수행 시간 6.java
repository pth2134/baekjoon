import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			long n = Integer.parseInt(br.readLine());
			long sum = 0;
			for(long i=1; i<=n-2; i++) {
				sum += i*(i+1)/2;
			}
			bw.write(sum+"\n"+3);
			br.close();
			bw.flush();
			bw.close();
	
		}
		catch (Exception IO){
		}	
	}	

}