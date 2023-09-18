import java.io.*;
import java.util.*;

class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		Integer[] rope = new Integer[n];
		for (int i = 0; i < n; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(rope,(o1,o2)->o2-o1);
		int max = 0;
		for (int i = 0; i <n; i++) {
			int f = rope[i]*(i+1);
			max = max>f? max:f;
		}
		System.out.println(max);
	}
 }