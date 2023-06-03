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
			
			HashSet<String> s = new HashSet<>();
	
			for(int i =0; i<n; i++) {
				s.add(br.readLine());
			}
			
			int cnt = 0;
			for(int i=0; i<m; i++) {
				if(s.contains(br.readLine())) {
					cnt++;
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