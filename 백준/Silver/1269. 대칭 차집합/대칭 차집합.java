import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, Boolean> a = new HashMap<>();
		
		st =  new StringTokenizer(br.readLine());
		for(int i =0; i<n; i++) {
			a.put(Integer.parseInt(st.nextToken()), true);
		}
		st =  new StringTokenizer(br.readLine());
		int duplicate = 0;
		for(int i =0; i<m; i++) {
			int key = Integer.parseInt(st.nextToken());
			if(a.containsKey(key)) {
				duplicate++;
			}
		}
		bw.write(n+m-2*duplicate+"");
		
		br.close();
		bw.flush();
		bw.close();
	}
}