import java.io.*;

class Main{


	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String str1 = br.readLine();
			String str2 = br.readLine();
			int l1 = str1.length();
			int l2 = str2.length();
			int[][] cnt = new int[l1+1][l2+1];
			
			for(int i = 1; i<=l1; i++) {
				for(int j =1; j<=l2; j++) {
					if(str1.charAt(i-1)==str2.charAt(j-1)) {
						cnt[i][j] = cnt[i-1][j-1]+1;
					} else {
						cnt[i][j] = cnt[i-1][j] > cnt[i][j-1] ? cnt[i-1][j] : cnt[i][j-1];
					}
				}
			}
			
			bw.write(cnt[l1][l2]+"");
			bw.flush();
		}
 }