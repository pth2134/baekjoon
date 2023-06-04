import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		HashSet<String> strs = new HashSet<>();
		int length = s.length();
		for(int i =0; i<length; i++) {
			for(int j=i+1; j<=length; j++) {
				strs.add(s.substring(i, j));
			}
		}
		bw.write(strs.size()+"");
		br.close();
		bw.flush();
		bw.close();
	}
}