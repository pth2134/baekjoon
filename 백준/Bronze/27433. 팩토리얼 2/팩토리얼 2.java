import java.io.*;

public class Main {
	public static long fac(long n) {
		if(n>1) {
			return n*fac(n-1);
		} else {
			return 1;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		bw.write(fac((long)n)+"");
		
		
		bw.flush();
	}
	
}
