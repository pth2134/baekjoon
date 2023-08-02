import java.io.*;
import java.util.*;

class Main{
	static int[] A;
	
	static int binary(int input ,int mid, int s, int f) {
		if(s>=f) return 0;
		if(input > A[mid]) {
			return binary(input, (mid+f)/2, mid+1, f);
		} else if (input < A[mid]) {
			return binary(input, (mid+s)/2, s, mid);
		} else {
			return 1;
		}
	}
	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			
			int n = Integer.parseInt(br.readLine());
			A = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i =0; i<n; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(A);
			
			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i =0; i<m; i++) {
				bw.write(binary(Integer.parseInt(st.nextToken()), n/2, 0, n)+"\n");
			}

			bw.flush();
		}
 }