import java.io.*;

public class Main {
	
	static int[] f;
	
	static int f(int n) {
		if(f[n]!=0) return f[n];
		else {
			f[n] = f(n-1) + f(n-2);
			if(f[n]>15746) f[n]%=15746; //15746이면 0이 저장되서 반복할 수 있음, 나중에 결과에서 나눠주기
			return f[n];
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		f = new int[n+1];
		f[1] = 1;
		if(n>=2) f[2] = 2;
		
		bw.write(f(n)%15746+"");
		bw.flush();
	}
	
}