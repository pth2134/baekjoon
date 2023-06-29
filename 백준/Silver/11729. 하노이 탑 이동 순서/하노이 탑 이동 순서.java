import java.io.*;


public class Main {
	static StringBuilder str = new StringBuilder();
	static int cnt = 0;
	
	public static void hanoi(int n, int start, int last, int rest) {
		cnt++;
		if(n>=2) {
			hanoi(n-1, start, rest, last); //n을 제외한 나머지 탑을 rest에 쌓는다.
			str.append(start+" "+last+"\n"); // n을 last에 쌓는다.
			hanoi(n-1,rest, last, start);// rest에 있던 n-1탑을 last로 옮긴다.
		}
		if(n==1) {
			str.append(start+" "+last+"\n");
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		hanoi(n,1,3,2);
		System.out.println(cnt);
		System.out.println(str);
	}
	
}
