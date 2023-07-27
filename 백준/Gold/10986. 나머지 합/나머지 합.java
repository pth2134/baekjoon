import java.io.*;
import java.util.*;

class Main{
	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			long cnt = 0;
			
			st = new StringTokenizer(br.readLine());
			int[] sum = new int[n];
			int[] sumCnt = new int[m+1];
			int input = Integer.parseInt(st.nextToken())%m;
			sumCnt[input]++;
			if(input == 0) cnt++;
			sum[0] = input;
			for(int i =1; i<n; i++) {
				input = Integer.parseInt(st.nextToken());
				sum[i] = (input + sum[i-1])%m;
				cnt += sumCnt[sum[i]]++;
				if(sum[i] ==0) cnt++;
			}
			
			bw.write(cnt+"");
			bw.flush();
		}
 }