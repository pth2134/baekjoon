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
			int[] card = new int[n];
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			
			for(int i =0; i<n; i++) {
				card[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(card);
			
			for(int i =2; i<n; i++) {
				for(int j=1; j<i; j++) {
					for(int k=0; k<j; k++) {
						if(card[i]+card[j]+card[k] > sum &&card[i]+card[j]+card[k] <= m) {
							sum = card[i]+card[j]+card[k];
						}
						else continue;
					}
				}
			}
			bw.write(sum+"");
			br.close();
			bw.flush();
			bw.close();
	
		}
		catch (Exception IO){
		}	
	}	

}