import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st = new StringTokenizer(br.readLine());			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			String[] s = new String[n];
			for(int i =0; i<n; i++) {
				s[i] = br.readLine();
			}
			
			int cnt = 0;
			for(int i=0; i<m; i++) {
				String check = br.readLine();
				for(int j=0; j<n; j++) {
					if(check.equals(s[j])) {
						cnt++;
					}
				}
				
			}
			
			bw.write(cnt+"");
			bw.flush();
			bw.close();
	
		}
		catch (Exception IO){
		}	
	}	
	

}