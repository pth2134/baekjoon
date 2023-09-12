import java.io.*;
import java.util.*;

class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while(true){
			st = new StringTokenizer(br.readLine());
			int maxIdx = 0;
			int[] length = new int[3];
			length[0] = Integer.parseInt(st.nextToken());
			length[1]= Integer.parseInt(st.nextToken());
			length[2] = Integer.parseInt(st.nextToken());
			if(length[0]==0&&length[1]==0&&length[2]==0) break;
			if(length[maxIdx] < length[1]) maxIdx = 1;
			if(length[maxIdx] < length[2]) maxIdx = 2;
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				if(i!=maxIdx){
					sum+=length[i]*length[i];
				}
			}
			if(sum==length[maxIdx]*length[maxIdx]){
				sb.append("right").append("\n");
			} else{
				sb.append("wrong").append("\n");
			}

		}
		System.out.println(sb);
	}
 }