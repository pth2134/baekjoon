import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		try {
			int t = Integer.parseInt(br.readLine());
			int i =0;
			HashMap<String, Integer> rainbow = new HashMap<>();
			for (; i < t; i++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				if(a.equals("ChongChong")||b.equals("ChongChong")) {
					rainbow.put(a,i);
					rainbow.put(b,i++);
					break;
				}
			}
			for(;i<t; i++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				if(rainbow.containsKey(a)){
					rainbow.put(b, i);
				} else if(rainbow.containsKey(b)) {
					rainbow.put(a, i);
				}
			}
			
			bw.write(rainbow.size()+"");
			bw.flush();
			
		
		
		
		} catch (IOException e) {
			
		}
	}
}