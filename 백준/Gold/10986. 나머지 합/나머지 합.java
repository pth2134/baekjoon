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
			int sum = 0;
			long[] sumCnt = new long[m];
			for(int i =0; i<n; i++) {
				sum= (Integer.parseInt(st.nextToken()) + sum)%m;
				//cnt += sumCnt[sum]; sumCnt[sum]을 sum이 나올 때마다 증가시키며 cnt에 더하는 방법
				sumCnt[sum]++;
				if(sum ==0) cnt++;
			}
			
			for(int i =0; i<m; i++) {
				//1부터 sumCnt[i]-1까지 순차적으로 증가했고, 이를 cnt에 더하기 때문에 1~sumCnt[i]-1의 수열의 합을 cnt에 더해준다.
				//sumCnt[i]-1까지만 더하는 이유는 sum이 나머지가 i일 때 자기보다 앞서나온 나머지가 i인것의 갯수를 더하는데, 
				//sumCnt[i]-1에서 sumCnt[i]가 될 때 나머지가 i인 값이 더이상 등장하지 않기 때문에 더해줄 필요가 없다.
				cnt+= (sumCnt[i]*(sumCnt[i]-1))/2;
			}
			
			bw.write(cnt+"");
			bw.flush();
		}
 }