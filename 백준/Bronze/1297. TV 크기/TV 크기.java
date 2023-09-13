import java.io.*;
import java.util.StringTokenizer;

class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Double l = Double.parseDouble(st.nextToken());
		Double a = Double.parseDouble(st.nextToken());
		Double b = Double.parseDouble(st.nextToken());
		Double c = Math.sqrt(a*a+b*b);
		int h = (int)(l*a/c);
		int w = (int)(l*b/c);
		System.out.println(h+" "+w);
	}
 }