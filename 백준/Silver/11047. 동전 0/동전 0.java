import java.io.*;
import java.util.*;

class Main{
	
		
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] value = new int[n];
			for (int i = 0; i < n; i++) {
				value[i] = Integer.parseInt(br.readLine());
			}
			
			int sum = 0;
			for (int i = value.length-1; i >= 0; i--) {
				sum+=k/value[i];
				k%= value[i];
			}
			bw.write(sum+"");
			bw.flush();
		}
 }