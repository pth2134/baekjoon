import java.io.*;
import java.util.*;

public class Main {
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int i =0; i<t; i++) {
			Rec rec = new Rec(br.readLine());
			bw.write(rec.recursion(0, rec.str.length()-1)+" "+rec.cnt+"\n");			
		}

		bw.flush();
	}
	
}

class Rec{
	int cnt=0;	
	String str;
	
	Rec(String str) {
		this.str =str;
	}
	
	public int recursion(int l, int r){
		this.cnt++;
        if(l >= r) return 1;
        else if(str.charAt(l) != str.charAt(r)) return 0;
        else return recursion(l+1, r-1);
    }
	
}