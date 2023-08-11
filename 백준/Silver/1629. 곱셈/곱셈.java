import java.io.*;
import java.util.*;

class Main{
	static long a;
	static int b;
	static int c;
	
	static long rest(long r,int bDiv,int bRest) {
		if(bDiv==0) return r*bRest%c;
		long r2 = r*r%c;
		long r3 = bRest==1? r:1;
		return (rest(r2,bDiv/2,bDiv%2)*r3)%c;
	}
	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Long.parseLong(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			System.out.println(rest(a,b/2,b%2));
		}
 }