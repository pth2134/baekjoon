import java.io.*;
import java.util.*;

class Main{

	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			int n = Integer.parseInt(br.readLine());
			
			int[] distance = new int[n]; //distance[i] = i번쨰 인덱스 도시까지의 거리
			int[][] price = new int[n][2];
			
			st= new StringTokenizer(br.readLine());
			for(int i =1; i<n; i++) {
				distance[i] = distance[i-1]+Integer.parseInt(st.nextToken());
			}
			st= new StringTokenizer(br.readLine());
			for(int i =0; i<n; i++) {
				price[i][0] = i;
				price[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(price, (o1,o2)->{
				if(o1[1]==o2[1]) return o1[0]-o2[0];
				return o1[1]-o2[1];
			});
			
			long cost = (long) price[0][1]*(distance[n-1]-distance[price[0][0]]);
			int city = price[0][0];
			for(int i =1; i<n; i++) {
				if(price[i][0]<city) {
					cost+= (long) price[i][1]*(distance[city]-distance[price[i][0]]);
					city = price[i][0];
				}
			}
			bw.write(cost+"");
			bw.flush();
		}
 }