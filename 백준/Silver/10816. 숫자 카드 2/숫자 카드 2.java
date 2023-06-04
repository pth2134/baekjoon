import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		HashMap<Integer , Integer> card = new HashMap<>();
		
		for(int i =0; i<n; i++) {
			int key = Integer.parseInt(st.nextToken());
			card.put(key, card.getOrDefault(key,0)+1);
		}
		
		int m = Integer.parseInt(br.readLine());
		st= new StringTokenizer(br.readLine());
		
		for(int i =0; i<m; i++) {
			int key = Integer.parseInt(st.nextToken());
			int nu = card.getOrDefault(key,0);
			bw.write(nu+" ");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}