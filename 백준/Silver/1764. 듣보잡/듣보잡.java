import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String,Integer> d = new HashMap<>();
		ArrayList<String> result = new ArrayList<>();
		for(int i=0; i<n; i++) {
			d.put(br.readLine(),1);
		}
		int cnt = 0;
		for(int i=0; i<m; i++) {
			String name = br.readLine();
			if(d.getOrDefault(name,0)>0) {
				result.add(name);
				cnt++;
			}
		}
		Collections.sort(result);
		bw.write(cnt+"\n");
		for(int i =0; i<cnt; i++) {
			bw.write(result.get(i)+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}