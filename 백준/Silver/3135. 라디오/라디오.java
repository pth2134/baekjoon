import java.io.*;
import java.util.*;
class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		int[] mark = new int[n];
		int min = Math.abs(b-a);
		for (int i = 0; i < n; i++) {
			mark[i] = Integer.parseInt(br.readLine());
			int move = Math.abs(b-mark[i])+1;
			if(move < min) {
				min = move;
			}
		}
		System.out.println(min);
	}
 }