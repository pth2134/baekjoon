import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n<100){
			System.out.println(n);
			return;
		} else{
			int sum = 99;
			for (int i = 111; i <= n; i++) {
				int r = i%100;
				int d = i/100;
				int a = d-r/10;
				if(r%10+2*a==d) sum++;
			}
			System.out.println(sum);
		}
	}
}