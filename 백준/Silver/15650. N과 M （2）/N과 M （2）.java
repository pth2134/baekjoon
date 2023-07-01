import java.io.*;
import java.util.*;

public class Main {
	public static int n;
	public static int m;
	public static StringBuilder str = new StringBuilder();
	public static boolean[] check;
	public static int[] result;
	
	public static void sequence(int index) {
		if(index == m) {
			for(int i=0; i<m; i++) {
				str.append(result[i]).append(" ");
			}
			str.append("\n");
		} else {
			int k;
			k = index > 0 ? index-1:index; 
			for(int i=result[k]; i<=n; i++) {
				if(!check[i]) {
					check[i] = true;
					result[index] = i;
					sequence(index+1);
					check[i] = false;
					
				}
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        check = new boolean[n+1];
        result = new int[m];
        
        for(int i =0; i<m; i++) {
        	result[i] = 1;
        }
        sequence(0);
        System.out.println(str);
    }
}