import java.io.*;
import java.util.*;

public class Main {
	
	 public static boolean isInteger(String str) {
		 char c = str.charAt(0);
		  return c>= '0'&&c<= '9';
	 }
	public static void main(String[] arsg) {
	
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			HashMap<String,Integer> pk = new HashMap<>();
			String[] poketmon = new String[n];
			for(int i =0; i<n; i++) {
				String s = br.readLine();
				pk.put(s, i+1);
				poketmon[i] = s;
			}
			
			for(int i=0; i<m; i++) {
				String quiz = br.readLine();
				if(isInteger(quiz)) {
					bw.write(poketmon[Integer.parseInt(quiz)-1]+"\n");
				}
				else {
					bw.write(pk.get(quiz)+"\n");
					}	
				}
			
			br.close();
			bw.flush();
			bw.close();
		} catch (Exception IO) {
		
		}
			
	
	}
	
}
	