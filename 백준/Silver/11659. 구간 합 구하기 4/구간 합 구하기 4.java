import java.io.*;
import java.util.StringTokenizer;

class Main{
	 public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			long[] box = new long[n+1];
			
			for (int i = 1; i <= n; i++) {
				box[i] = box[i-1] + Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				bw.write(-box[Integer.parseInt(st.nextToken())-1]+box[Integer.parseInt(st.nextToken())]+"\n");
			}
			bw.flush();
		}
 }