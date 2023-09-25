import java.io.*;
import java.util.*;
class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[] sensor = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			sensor[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sensor);

		int[] distance = new int[1000000];
		for (int i = 1; i < n; i++) {
			distance[sensor[i]-sensor[i-1]]++;
		}
		int sum = 0;
		for(int i =0; i<1000000; i++){
			if(distance[i]>0){
				n-=distance[i];
				if(n<=k) {
					sum+=(distance[i]-k+n)*i;
					break;
				}
				sum+=distance[i]*i;
			}
		}
		System.out.println(sum);
	}
}