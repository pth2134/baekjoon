import java.io.*;

public class Main {
	
	static StringBuilder str = new StringBuilder();
	
	public static void reduce(int n) {
		if(n >= 1) {
			reduce(n-1);
			String r = str.toString();
			for(int i =0; i<r.length(); i++) {
				str.append(" ");
			}
			str.append(r);
		} else {
			str.append("-");
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input=" ";
		
		while((input = br.readLine()) != null && !input.isEmpty()) {
			str = new StringBuilder();
			int n = Integer.parseInt(input);
			reduce(n);
			System.out.println(str);
		}
	}
	
}