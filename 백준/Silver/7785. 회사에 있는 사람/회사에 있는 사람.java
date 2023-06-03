import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] arsg) {
	
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder str = new StringBuilder(); //bw대신 사용 String 이어주는 역할
			StringTokenizer st;
			
			HashSet<String> company = new HashSet<>();
			int n = Integer.parseInt(br.readLine());
			int p = 0;
			for(int i =0; i<n; i++) {
				st= new StringTokenizer(br.readLine());
				String name = st.nextToken();
				company.add(name); p++;
				if(st.nextToken().equals("leave")) {
					company.remove(name);
					p-=2;
				}
			}
			List<String> result = new ArrayList<String>(company);
			Collections.sort(result, Collections.reverseOrder());
			
			for(int i=0; i<p; i++) {
				str.append(result.get(i)+"\n");
			}
			System.out.println(str);
			
		} catch (Exception IO) {
		
		}
			
	
	}
	
}