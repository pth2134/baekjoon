import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			long n = Integer.parseInt(br.readLine());
			
			bw.write((n*n*n)+"\n"+3);
			br.close();
			bw.flush();
			bw.close();
	
		}
		catch (Exception IO){
		}	
	}	

}