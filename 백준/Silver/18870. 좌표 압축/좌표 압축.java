import java.io.*;
import java.util.*;

public class Main {
			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[][] numbers = new int[n][3];
		
		for(int i =0; i<n; i++) {
			numbers[i][0] = Integer.parseInt(st.nextToken());
			numbers[i][1] = i;
		}
		
		Arrays.sort(numbers, new Comparator<int[]>() {
			public int compare(int[] e1, int[] e2) {
				return e1[0] - e2[0];
			}
		});
		
		int press = 1;
		numbers[0][2] = 0;
		for(int i =1; i<n; i++) {
			if(numbers[i-1][0]==numbers[i][0]) {
				numbers[i][2]=--press;
			}
			else numbers[i][2]=press;
			press++;
		}
		
		Arrays.sort(numbers, new Comparator<int[]>() {
			public int compare(int[] e1, int[] e2) {
				return e1[1] - e2[1];
			}
		});
		
		for(int i=0; i<n; i++) {
			bw.write(numbers[i][2]+" ");
		}
		
		bw.flush();		
		bw.close();		
	}	
}