import java.io.*;
import java.util.*;

public class Main {
	public static int n;
	public static int m;
	public static StringBuilder str = new StringBuilder();
	public static int[] result;
	
	public static void sequence(int index) {
		if(index == m) {
			for(int i=0; i<m; i++) {
				str.append(result[i]).append(" ");
			}
			str.append("\n");
		} else {
			for(int i=1; i<=n; i++) {	
				result[index] = i;
				sequence(index+1);
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = new int[m];
        
        sequence(0);
        System.out.println(str);
    }
}