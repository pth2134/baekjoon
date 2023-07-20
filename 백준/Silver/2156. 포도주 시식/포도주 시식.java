import java.io.*;

class Main{
	
		
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int t= Integer.parseInt(br.readLine());
			int[] walk = new int[t];
			int[] jump = new int[t];
			int[] jump2 = new int[t]; //두칸을 넘는 경우는 있을 수 있지만
			//세칸을 넘을 경우 가운데 한칸을 먹는게 무조건 이득이기 때문에 없음
			int[] max = new int[t];
			
			int input = Integer.parseInt(br.readLine());
			walk[0] = input;
			max[0] = walk[0];
			if(t>=2) {
				input = Integer.parseInt(br.readLine());
				walk[1] = walk[0]+ input;
				jump[1] = input;
				max[1] = walk[1];
			}
			if(t>=3) {
				input = Integer.parseInt(br.readLine());
				walk[2] = jump[1] + input;
				jump[2] = walk[0] + input;
				jump2[2] = input;
				max[2] = walk[2] > jump[2] ? walk[2] : jump[2];
			}
			
			for(int i =3; i<t; i++) {
				input = Integer.parseInt(br.readLine());
				walk[i] = jump[i-1] > jump2[i-1]? jump[i-1] + input : jump2[i-1] + input;
				jump[i] = max[i-2] + input;
				jump2[i] = max[i-3] + input;
				if(walk[i] > max[i]) max[i] = walk[i];
				if(jump[i] > max[i]) max[i] = jump[i];
				if(jump2[i] > max[i]) max[i] = jump2[i];
			}
			int result = 0;
			if(t>=2) result = max[t-1] > max[t-2] ? max[t-1] : max[t-2];
			else result = max[t-1];
			//max[t-3]은 마지막 한칸을 먹는게 무조건 이득이므로 max[t-1]보다 작을 수 밖에 없음
			bw.write(result+"");
			bw.flush();
		}
 }