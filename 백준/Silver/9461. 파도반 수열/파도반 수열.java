import java.io.*;

class Main{
	 
	 static long[] len;
	 
	 public static long tri(int n) {
		 if(len[n]!=0) {
			 return len[n];
		 } else {
			 return len[n] = tri(n-1) + tri(n-5);
		 }
	 }
	 
	 public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			len = new long[101];
			len[1] = 1; len[2] = 1; len[3] = 1;
			len[4] = 2; len[5] = 2;
			int t = Integer.parseInt(br.readLine());			
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine());
				bw.write(tri(n)+"\n");	
			}
			bw.flush();
		}
 }