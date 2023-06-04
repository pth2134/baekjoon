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
			if(card.containsKey(key)) {
				card.put(key, card.get(key)+1);
			}
			else card.put(key, 1);
		}
		
		int m = Integer.parseInt(br.readLine());
		st= new StringTokenizer(br.readLine());
		
		for(int i =0; i<m; i++) {
			int key = Integer.parseInt(st.nextToken());
			int nu = isInteger(card, key);
			bw.write(nu+" ");
		}
		br.close();
		bw.flush();
		bw.close();
	}

	public static int isInteger(HashMap<Integer , Integer> card, int key) {
		try {
			return card.get(key);
		}
		catch(NullPointerException e){
			return 0;
		}
	}
}