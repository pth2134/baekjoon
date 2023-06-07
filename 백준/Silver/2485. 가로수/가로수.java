import java.io.*;
import java.util.*;

public class Main {
			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] tree = new int[n];
		ArrayList<Integer> g = new ArrayList<>();
		tree[0]= Integer.parseInt(br.readLine());
		for(int i=1; i<n; i++) {
			tree[i] = Integer.parseInt(br.readLine());
			g.add(tree[i]-tree[i-1]);
		}
		int max = tree[n-1];
		int min = tree[0];
		
		int result = ((max-min)/minGap(g))+1 - n;
		bw.write(result+"");
		bw.flush();		
		
		bw.close();		
	}	
	
	public static int minGap(ArrayList<Integer> g) {
		Collections.sort(g);
		int minGap = g.get(0);
		boolean check = false;
		while(!check) {
			check = true;
			for(int i=0; i<g.size(); i++) {
				if(g.get(i)%minGap!=0) {
					minGap--;
					check = false;
					break;
				}
			}
			
		}
		return minGap;
	}
}
