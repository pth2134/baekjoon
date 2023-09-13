import java.io.*;

class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		double r = Double.parseDouble(br.readLine());
		double ucl = r*r*Math.PI;
		double taxi = r*r*2;
		sb.append(ucl+"\n"+taxi);
		System.out.println(sb);
	}
 }