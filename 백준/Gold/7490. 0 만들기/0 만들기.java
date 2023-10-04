import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] num = {0,1,2,3,4,5,6,7,8,9};
	static char[] cal = new char[9];

	static void zero(int m, int r,int mult,int a,char c){
		if(m==n) {
			if(c=='+') {
				r +=a;
			} else if(c=='-'){
				r -=a;
			}
			if(r==0){
				for (int i = 1; i < n; i++) {
					sb.append(num[i]);
					sb.append(cal[i]);
				}
				sb.append(n).append("\n");
			}
		} else {
			int next = m+1;
			cal[m] = ' ';
			zero(next,r,mult*10,a*mult+next,c);
			if(c=='+') {
				r +=a;
			} else if(c=='-'){
				r -=a;
			}
			cal[m] = '+';
			zero(next,r,10,next,'+');
			cal[m] = '-';
			zero(next,r,10,next,'-');
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			zero(1,0,10,1,'+');
			sb.append("\n");
		}
		System.out.println(sb);
	}
}