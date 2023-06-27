import java.io.*;

public class Main {
	public static long[] fib(long n) {
		long[] f = new long[2];
		long[] f2; 
				
		if(n >1) {
			f2 = fib(n-1);
			f[0] = f2[0]+f2[1]; //f[1]은 n번째
			f[1] = f2[0]; // f[2]는 n-1번째
		} else if(n==1) {
			f[0] = 1;
		} else {
			f[0] = 0;
		}
		return f;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		bw.write(fib(n)[0]+"");
		
		
		bw.flush();
	}
	
}