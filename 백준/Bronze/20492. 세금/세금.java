import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int a = n/100*78;
		int b = n/1000*956;
		System.out.println(a+" "+b);
	}
}