import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = " "+br.readLine();
		String b = " "+br.readLine();

		int[][] dp = new int[a.length()][b.length()];
		int max = 0;
		for (int i = 1; i < a.length(); i++) {
			for (int j = 1; j < b.length(); j++) {
				if(a.charAt(i)==b.charAt(j)) {
					dp[i][j] = dp[i-1][j-1]+1;
					max = Math.max(max,dp[i][j]);
				}
			}
		}
		System.out.println(max);
	}
}