import java.io.*;
import java.util.StringTokenizer;

class Main{
	 public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int max = -1000;
			int[] sum = new int[n+1];
			for (int i = 1; i < sum.length; i++) {
				sum[i] = Integer.parseInt(st.nextToken());
				if(sum[i-1]>0) sum[i] += sum[i-1];
				max = sum[i]>max? sum[i]:max;
			}
			
			bw.write(max+"");
			bw.flush();
		}
 }