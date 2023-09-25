import java.io.*;
import java.util.*;
class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		long n = Long.parseLong(br.readLine());
		st = new StringTokenizer(br.readLine());
		long[] dice = new long[10];
		for (int i = 2; i < 8; i++) {
			dice[i] = Long.parseLong(st.nextToken());
		}

		if(n==1){
			long max = 0;
			long sum = 0;
			for (int i = 2; i < 8; i++) {
				sum+= dice[i];
				max = Math.max(max,dice[i]);
			}
			System.out.println(sum-max);
			return;
		}

		boolean[] ops = new boolean[10];
		long[] comb = {150,150,150};
		for (int i = 0; i <= 5; i++) {
			long sum = dice[i];
			ops[9-i] = true;
			for (int j = i+1; j <= 6; j++) {
				if(ops[j]) continue;
				sum += dice[j];
				ops[9-j] = true;
				for (int k = j+1; k <=7 ; k++) {
					if(ops[k]) continue;
					sum += dice[k];
					if(i>=2) comb[2] = Math.min(comb[2],sum);
					else if(j>=2) comb[1] = Math.min(comb[1],sum);
					else comb[0] = Math.min(comb[0],sum);
					sum -= dice[k];
				}
				sum-=dice[j];
				ops[9-j] = false;
			}
			ops[9-i] = false;
		}

		long result = comb[2]*4 +
				comb[1]*((n-2)*8+4)+
				comb[0]*((n-2)*(n-2)*5+(n-2)*4);
		System.out.println(result);
	}
}