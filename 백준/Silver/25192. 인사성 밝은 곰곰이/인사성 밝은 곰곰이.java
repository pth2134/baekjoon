import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int t = Integer.parseInt(br.readLine());
			HashSet<String> hello = new HashSet<>();
			int result = 0;
			for(int i=0; i<t; i++) {
				String input = br.readLine();
				if(!input.equals("ENTER")) { //enter가 아니라면 중복없이 저장한다.
					hello.add(input);	
				}else{
					result+=hello.size(); //enter가 들어오면 갯수를 세서 result에 저장한다.
					hello.clear(); //새로 입력받기 위해 clear
				}
			}
			result += hello.size();
			bw.write(result+"");
			bw.flush();
			
		
		
		
		} catch (IOException e) {
			
		}
	}
}