import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int n = Integer.parseInt(br.readLine());
			int m = 0;
			for(int i = 1; i<n; i++) {
				int sum=0;
				int ni = i;
				while(ni>0) {
					sum += ni%10;
					ni /=10;
				}
				if(i+sum == n) {
					m = i;
					break;
				}
			}
			bw.write(m+"");
			br.close();
			bw.flush();
			bw.close();
	
		}
		catch (Exception IO){
		}	
	}	

}