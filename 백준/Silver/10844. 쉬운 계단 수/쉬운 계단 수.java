import java.io.*;

class Main{
	
		
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			int limit = 1000000000;
			
			int[][] k = new int[n+1][10]; //i는 자리수, j는 끝자리 수 k[i][j]는 j로 끝나는 수의 갯수
			
			for(int i =1; i<=9; i++) {
				k[1][i] = 1;
			}
			
			for(int i =2; i<=n; i++) {
				
				k[i][0] = k[i-1][1];
				
				for(int j=1; j<=8; j++) {
					k[i][j] = (k[i-1][j-1] + k[i-1][j+1])%limit;
				}
				
				k[i][9] = k[i-1][8];
				
			}
			
			long sum = 0;
			for(int i =0; i<=9; i++) {
				sum+=k[n][i];
			}
			bw.write(sum%limit+"");
			bw.flush();
		}
 }