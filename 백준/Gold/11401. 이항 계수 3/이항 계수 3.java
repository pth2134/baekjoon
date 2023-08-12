import java.io.*;
import java.util.*;

class Main{
	
	static long a;
	static int b;
	static int c = 1000000007;
	
	static long rest(long r,int bDiv,int bRest) {
		if(bDiv==0) return r*bRest%c;
		long r2 = r*r%c;
		long r3 = bRest==1? r:1;
		return (rest(r2,bDiv/2,bDiv%2)*r3)%c;
	}


	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			long nk = 1;
			long div = 1;
			if(k>n/2) k = n-k;
			
			if(k==0||k==n) {
				nk = 1;
			} else if(k==1||k==n-1) {
				nk = n;
			}
			else {
				for(int i =n; i>n-k; i--) {
					nk = nk*i%c;
				}
				for(int i = 2; i<=k; i++) {
					div = div*i%c;
				}
			}
			
			div = (rest(div,(c-2)/2,c%2));
			
			System.out.println(nk*div%c);
		}
 }