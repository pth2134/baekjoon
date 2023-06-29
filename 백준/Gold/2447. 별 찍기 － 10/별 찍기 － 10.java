import java.io.*;


public class Main {
	static StringBuilder str = new StringBuilder();
	
	public static String[] star(int n) {
		int m = n/3;
		String[] s1 = new String[n];
		if(n>3) {
			String[] s2 = star(m);
			line(s1,s2,0,m);
			middle(s1,s2,m);
			line(s1,s2,m*2,m);
		} else {
			s1[0] = "***";
			s1[1] = "* *";
			s1[2] = "***";
		}
		return s1;
	}
	
	public static void line(String[] s1,String[] s2, int firstIndex, int m) {
		for(int i =0; i<m; i++) {
			s1[i+firstIndex] = s2[i]; //null값이 안찍히도록
			for(int j = 0; j<2; j++) {
				s1[i+firstIndex] += s2[i];
			}
		}
	}
	
	public static void middle(String[] s1,String[] s2, int m) {
		for(int i =0; i<m; i++) {
			s1[i+m] = s2[i];
			for(int j=0; j<m; j++) {
				s1[i+m]+=" ";
			}
			s1[i+m] += s2[i];
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String[] s = star(n);
		for(int i =0; i<n; i++) {
			str.append(s[i]+"\n");
		}
		
		System.out.println(str);
	}
	
}