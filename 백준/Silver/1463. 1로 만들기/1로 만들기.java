import java.io.*;

class Main{
	static int[] s;
	
	static void min(int m,int t) {
		if(m<=1) {
			return;
		}
		int x;
		if(m%3==0) {
			x=m/3;
			if(s[x]==0 || s[x] > t+1) {
				s[x] = t+1;
				min(x,t+1);
			}
		}
		if(m%2==0) {
			x= m/2;
			if(s[x]==0 || s[x] > t+1) {
				s[x] = t+1;
				min(x,t+1);
			}
		}

		x=m-1;
		if(s[x]==0 || s[x] > t+1) {
			s[x] = t+1;
			min(x,t+1);
		}
	}
	
	 public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			s = new int[n+1];
			
			min(n,0);
			bw.write(s[1]+"");
			bw.flush();
		}
 }