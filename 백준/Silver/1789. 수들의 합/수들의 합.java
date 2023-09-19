import java.io.*;

class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long s = Long.parseLong(br.readLine());
		long n = 0;
		long sum = 0;
		while(sum<s){
			sum+=++n;
		}
		if(sum>s){
			System.out.println(n-1);
		}else{
			System.out.println(n);
		}
	}
 }