import java.io.*;

public class Main {
	static int code1 = 0;
	static int code2 = 0;
	
	public static int fib(int n) {
		if(n==1 || n==2) {
			code1++;
			return 1;
		}
		return (fib(n-1) + fib(n-2));
	}
	
	public static int fibonacci(int n) {
		int[] f = new int[n+1];
		f[1] = f[2] = 1;
		for(int i = 3; i<=n; i++) {
			f[i] = f[i-1] + f[i-2];
			code2++;
		}
		return f[n];
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		fib(n);
		fibonacci(n);
		
		bw.write(code1+" "+code2);
		bw.flush();
	}
	
}
