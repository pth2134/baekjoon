import java.io.*;
import java.util.*;

public class Main {
			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		br.close();
		
		int v = 0;
		v = n/5;
		if((n>=9&&n%5==4) ||(n>=12 &&n%5==2)) v+=2;
		else if(n%5==3 || (n>=6&&n%5==1)) v+=1;
		else if(n%5==0) v +=0;
		else v= -1;
		bw.write(v+"");
		
		bw.flush();		
		bw.close();		
	}	
}
