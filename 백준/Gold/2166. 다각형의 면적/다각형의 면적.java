import java.io.*;
import java.util.StringTokenizer;

class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		double[] x = new double[n];
		double[] y = new double[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] =Double.parseDouble(st.nextToken());
			y[i] =Double.parseDouble(st.nextToken());
		}
		double area = 0;
		for(int i = 0; i<n-1; i++){
			area+= (x[i+1]-x[i])*(y[i]-y[0])-(y[i+1]-y[i])*(x[i]-x[0]);
		}
		area/= 2;
		if(area <0){
			area = -area;
		}
		System.out.println(String.format("%.1f",area));
	}
 }