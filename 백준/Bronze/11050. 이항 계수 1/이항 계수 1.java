import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] co = {n,k,n-k};
			int[] co2 = {1,1,1}; //co[i]!이 들어갈 배열
			for(int i=0; i<co.length; i++) {
				for(int j =co[i]; j>0; j--) {
					co2[i]*=j;
				}
			}
			bw.write(co2[0]/(co2[1]*co2[2])+"");
			
			bw.flush();
			
		} catch (IOException e) {
			
		}
	}
}