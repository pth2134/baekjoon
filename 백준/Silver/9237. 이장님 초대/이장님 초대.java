import java.io.*;
import java.util.*;
class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] tree = new int[1000001];
		int day = 0;
		int grow = 0;
		for(int i =0; i<n; i++){
			tree[Integer.parseInt(st.nextToken())]++;
		}

		for (int i = 1000000; i > 0; i--) {
			if(tree[i]>0){
				day += tree[i];
				if(grow < day+i) {
					grow = day+i;
				}
			}
		}
		System.out.println(grow+1);
	}
 }