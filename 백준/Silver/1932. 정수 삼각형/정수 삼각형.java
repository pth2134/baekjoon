import java.io.*;
import java.util.StringTokenizer;

class Main{
	static int[] input = new int[501]; //각각의 행 입력
	static int n;
	
	static int[] set(int index,int[] sum) {
		int[] seq = new int[index+1];
		for(int i =1; i<index; i++) {
			seq[i] = sum[i-1]>sum[i]? sum[i-1]+input[i] : sum[i]+input[i];
		}
		seq[index] = sum[index-1] + input[index];
		return seq;
	}
	
	 public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
						
			n = Integer.parseInt(br.readLine());
			int[] seq = new int[2];
			
			for(int i =1; i<=n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=i; j++) {
					input[j] = Integer.parseInt(st.nextToken());
				}
				seq = set(i,seq);
			}
			int max = seq[1];
			for (int i = 2; i <= n; i++) {
				max = seq[i] > max ? seq[i]:max;
			}
			
			bw.write(max+"");
			bw.flush();
		}
 }