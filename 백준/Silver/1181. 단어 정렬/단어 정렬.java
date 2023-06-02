import java.io.*;
import java.util.*;

public class Main {
			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		String[] strs = new String[n];
		
		for(int i =0; i<n; i++) {
			strs[i] = br.readLine();
		}
		
		Arrays.sort(strs,new Comparator<String>() {
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					for(int i =0; i<s1.length(); i++) {
						if(s1.charAt(i) != s2.charAt(i)) {
							return s1.charAt(i) - s2.charAt(i);
						}
					}
				}
				return s1.length() - s2.length();
			}
		});
		
		for(int i = 0; i<n; i++) {
			if(i>0&&strs[i].equals(strs[i-1])) continue;
			bw.write(strs[i]+"\n");
		}
		
		bw.flush();		
		bw.close();		
	}	
}