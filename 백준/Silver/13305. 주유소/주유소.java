import java.io.*;
import java.util.*;

class Main{

	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			int n = Integer.parseInt(br.readLine());
			
			int[] distance = new int[n]; //distance[i] = i번쨰 인덱스 도시까지의 거리
			
			st= new StringTokenizer(br.readLine());
			for(int i =1; i<n; i++) {
				distance[i] = Integer.parseInt(st.nextToken());
			}
			
			st= new StringTokenizer(br.readLine());
			int min = Integer.parseInt(st.nextToken());
			long cost =  min*distance[1];;
			int price = 0;
			for(int i =1; i<n-1; i++) {
				price = Integer.parseInt(st.nextToken());
				min = min > price ? price : min;
				cost += (long)min*distance[i+1];
			}
			
			bw.write(cost+"");
			bw.flush();
		}
 }