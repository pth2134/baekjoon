import java.io.*;

class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		if(t%10!=0) {
			System.out.println(-1);
		} else{
			int a = t/300;
			t%=300;
			int b = t/60;
			t%=60;
			int c = t/10;
			System.out.println(a+" "+b+" "+c);
		}
	}
 }