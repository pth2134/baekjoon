import java.io.*;

public class Main {
	static int n;
	static boolean[] s1;
	static boolean[] s2;
	static boolean[] bulb;
	static int l;
	static int answer;

	static void reverse(int idx, int cnt, boolean r){ //이번 idx가 reverse 되었는지 = r
		if(idx==l) {
			boolean b1 = bulb[l-1]==s1[l-1];
			boolean b2 = bulb[l]==s1[l];
			if(r){
				if(!b1&&!b2) answer = Math.min(answer,cnt);
			} else{
				if(b1&&b2) answer = Math.min(answer,cnt);
			}
			return;
		}
		int pre = idx-1;
		int next = idx+1;
		if(!r){
			if(bulb[pre]!=s1[pre]) return;
			bulb[next] = s2[next];
			reverse(next,cnt,false);
			reverse(next,cnt+1,true);
		}
		else{
			if(bulb[pre]==s1[pre]) return;
			bulb[pre] = s1[pre];
			bulb[idx] = !bulb[idx];
			bulb[next] = !s2[next];
			reverse(next,cnt,false);
			reverse(next,cnt+1,true);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		n = Integer.parseInt(br.readLine());
		s1 = new boolean[n];
		s2 = new boolean[n];
		bulb = new boolean[n];
		l = n-1;
		answer = n+1;
		for (int i = 0; i < n; i++) {
			s1[i] = br.read()==49? true : false;
		}
		br.read();
		for (int i = 0; i < n; i++) {
			s2[i] = br.read()==49? true : false;
		}
		bulb[0] = s2[0]; bulb[1] = s2[1];
		reverse(1,0,false);
		reverse(1,1,true);
		bulb[0] = !s2[0]; bulb[1] = !s2[1];
		reverse(1,1,false);
		reverse(1,2,true);
		if(answer == n+1) System.out.println(-1);
		else System.out.println(answer);
	}
}