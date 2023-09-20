import java.io.*;

class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int f = 0;
		int t = 0;
		if(n%2==0){
			f= (n/10)*2;
			n%=10;
			t=n/2;
			n%=2;
		} else{
			f= (n/10)*2;
			n=n%10;
			if(n>=5){
				n-=5;
				f++;
			} else{
				n+=5;
				f--;
			}
			t=n/2;
			n%=2;
		}
		if(f>=0){
			System.out.println(t+f);
		}else{
			System.out.println(-1);
		}
	}
 }