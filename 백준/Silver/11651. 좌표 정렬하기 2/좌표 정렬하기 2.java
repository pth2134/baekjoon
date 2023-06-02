import java.io.*;
import java.util.*;

public class Main {
			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] xy = new int[n][2];
		for(int i =0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			xy[i][0] =Integer.parseInt(st.nextToken());
			xy[i][1] =Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(xy,new Comparator<int[]>(){
			public int compare(int[] e1, int[] e2) {
				if(e1[1] == e2[1] ) {
					return e1[0] - e2[0];
				}
				else return e1[1] - e2[1];
			}
		});
		

		
		for(int[] i : xy) {
			bw.write(i[0]+" "+i[1]+"\n");
		}
		
		bw.flush();		
		bw.close();		
	}	
}

