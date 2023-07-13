import java.io.*;
import java.util.StringTokenizer;

class Main{
    
	 public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
						
			int n = Integer.parseInt(br.readLine());
			int sum1 = 0;
			int sum2 = 0;
			int sum3 = 0;
			int[] route = new int[2];
			int[] now = new int[3];
			int maxWall = 0;
			
			int max = 0;
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				int input = Integer.parseInt(st.nextToken());
				now[j] = input;
				if(input > max) {
					max = input;
					maxWall = j;
				}
			}
			route[0] = ++maxWall%3;
			route[1] = ++maxWall%3;
			sum1 += now[route[0]];
			sum2 += now[route[1]];
			
			for (int i = 1; i < n; i++) {
				max = 0;
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<3; j++) {
					int input = Integer.parseInt(st.nextToken());
					now[j] = input;
					if(input > max) {
						max = input;
						maxWall = j;
					}
				}
				
				if(maxWall==route[0]) {
					//sum1 이 max랑 만남(final =sum1)
					if(sum1<=sum2) {
						sum2 = sum1;
						route[0] = (++maxWall)%3;
						route[1] = (++maxWall)%3;
					} else {
						//sum2가 더 작아서 가던 길 유지
						
						route[0] = route[1];
						route[1] = 3 -maxWall -route[1];
					}
				} else if(maxWall==route[1]) {
					//sum2가 max랑 만남(final =sum2)
					if(sum1>=sum2) {
						sum1 = sum2;
						route[0] = (++maxWall)%3;
						route[1] = (++maxWall)%3;
					} else {
						//sum1이 더 작아서 가던 길 유지
						
						route[1] = route[0];
						route[0] = 3 -maxWall -route[0];
						
					}
				} else {
					//둘다 안만남
					route[0] = 3 -maxWall -route[0];
					route[1] = 3 -maxWall -route[1];
					
				}
				sum3 = sum1>sum2? sum2:sum1;
				sum1+= now[route[0]];
				sum2+= now[route[1]];
				sum3 += max;
                //작은 sum에 max를 더해보고 나머지 sum보다 작다면 선택폭이 넓은 sum3로 바꿔준다.
				if(sum3<sum1) {
					sum1 = sum3;
				} else if(sum3 < sum2) {
					sum2 = sum3;
				}				
			}
			int result = sum1>sum2? sum2:sum1;
			bw.write(result+"");
			bw.flush();
		}
 }