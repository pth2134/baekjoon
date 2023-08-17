import java.io.*;

class Main{
	static long r = 1000000007;
	
	static long[][] div(long[][] p,long n) {
		if(n==1) {
			return p;
		}
		long n2 = n%2;
		long[][] p2 = mp(p,p);
		if(n2==1) {
			return mp(div(p2,n/2),p);
		}
		return div(p2,n/2);
	}
	
	static long[][] mp(long[][] a, long[][] b) {
		long[][] c = new long[2][2]; 
		for(int i =0; i<2; i++) {
			for(int k =0; k<2; k++) {
				long p = 0;
				for(int j =0; j<2; j++) {
					p += a[i][j]*b[j][k]%r;
				}
				c[i][k] = p%r;
			}
		}
		return c;
	}
	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			long n = Long.parseLong(br.readLine());
			long[][] p = {{1,1},{1,0}};
			if(n>=2) {
				System.out.println(div(p,n-1)[0][0]);;
			} else {
				System.out.println(1);
			}
			
		}
 }