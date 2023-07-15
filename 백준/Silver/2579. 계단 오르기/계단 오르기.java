import java.io.*;

class Main{
	
	 public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int[] jump = new int[301];//점프로 도착한 최대점수
			int[] walk = new int[301];//한칸이동으로 도착한 최대점수
			
			int n = Integer.parseInt(br.readLine());
			boolean jumprule = false;
			boolean walkrule = false;
			int input = Integer.parseInt(br.readLine());
			
			walk[1] = input;
			jump[1] = input;//두번째 칸 예외처리용
			for(int i =2; i<=n; i++) {
				input = Integer.parseInt(br.readLine());
				jump[i] = jump[i-2]>walk[i-2] ? jump[i-2]+input : walk[i-2]+input;
				walk[i] = jump[i-1] + input; //한칸이동을 해야하기 때문에 점프한 뒤에만 갈 수 있다. 
			}
			int result = jump[n]>walk[n] ? jump[n] : walk[n];
			bw.write(result+"");
			bw.flush();
		}
 }