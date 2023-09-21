import java.io.*;

class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char[] ucpc = {'U','C','P','C'};
		int idx = 0;
		boolean UCPC = false;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)==ucpc[idx]){
				idx++;
			}
			if(idx==4) {
				UCPC = true;
				break;
			}
		}
		if (UCPC) System.out.println("I love UCPC");
		else System.out.println("I hate UCPC");
	}
 }