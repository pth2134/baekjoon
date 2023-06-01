import java.io.*;
import java.util.*;

public class Main {
			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		XY[] xy = new XY[n];
		for(int i =0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			xy[i] = new XY(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(xy);
		
		for(XY i : xy) {
			bw.write(i.x+" "+i.y+"\n");
		}
		
		bw.flush();		
		bw.close();		
	}	
}

class XY implements Comparable<XY>{
	int x=0;
	int y=0;
	
	public XY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int compareTo(XY xy) {
		if(xy.x == x) {
			return y-xy.y;
		}
		else return x-xy.x;
	}
}