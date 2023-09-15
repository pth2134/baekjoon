import java.io.*;
import java.util.StringTokenizer;

class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] x = new int[3];
		int[] y = new int[3];
		for(int i =0; i<3; i++){
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		int result = (x[1]-x[0])*(y[2]-y[0])-(x[2]-x[0])*(y[1]-y[0]);
		if(result ==0){
			System.out.println(0);
		} else if(result > 0){
			System.out.println(1);
		}else{
			System.out.println(-1);
		}
	}
 }