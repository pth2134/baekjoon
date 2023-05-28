import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			int i =666;
			int[] n666 = new int[n];
			
			while(n >0) {
				String str = i+"";
				if(str.contains("666")) n--;
				i++;
			}
			bw.write(--i+"");
			bw.flush();
			bw.close();
	
		}
		catch (Exception IO){
		}	
	}	
	

}