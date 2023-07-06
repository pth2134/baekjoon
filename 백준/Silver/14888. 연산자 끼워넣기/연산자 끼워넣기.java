import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] cal;
	static int[] number;
	static int max = -1000000000;
	static int min = 1000000000;
	static int[] seq;
		//뭐가 먼저올지 정하는 메서드
	static void calculate(int depth) {
		if(depth == n-1) {
			if(seq[depth]>max) max = seq[depth];
			if(seq[depth]<min) min = seq[depth];
		}
		for(int i =0; i<4; i++) {
			if(cal[i]>0) {
				cal[i]--;
				put(depth,i);
				calculate(depth+1);
				cal[i]++;
			}
		}
	}
	
	static void put(int depth,int i) {
		if(i == 0) {
			seq[depth+1] = seq[depth]+number[depth+1];
		} else if(i==1) {
			seq[depth+1] = seq[depth]-number[depth+1];
		} else if(i==2) {
			seq[depth+1] = seq[depth]*number[depth+1];
		} else{
			seq[depth+1] = seq[depth]/number[depth+1];
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		number = new int[n];
		cal = new int[4];
		seq = new int[n];
		for(int i =0; i<n; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		seq[0] = number[0];
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<4; i++) {
			cal[i] = Integer.parseInt(st.nextToken());
		}
		calculate(0);
		bw.write(max+"\n"+min);
		bw.flush();
	}
	
}
