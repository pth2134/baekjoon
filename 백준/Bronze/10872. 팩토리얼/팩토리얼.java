import java.io.*;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			int result = 1;
			for(int i =n; i>0; i--) {
				result*=i;
			}
			bw.write(result+"");
			bw.flush();
			
		} catch (IOException e) {
			
		}
	}
}