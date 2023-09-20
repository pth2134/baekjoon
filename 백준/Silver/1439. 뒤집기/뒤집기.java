import java.io.*;

class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char a = s.charAt(0);
		int cnt = 1;
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i)!=a) cnt++; a=s.charAt(i);
		}
		System.out.println(cnt/2);
	}
 }