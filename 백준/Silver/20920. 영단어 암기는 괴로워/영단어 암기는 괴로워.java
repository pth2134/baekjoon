import java.io.*;
import java.util.*;

class Voca{ //빈도별로 생성되며 길이에 따라 리스트를 선언, 저장하고 정렬하는 class
	 ArrayList<String>[] vl = new ArrayList[11];
	    int[] a = new int[11];
	    
	    public void getVoca(String str, int l) {
	        if (vl[l] == null) {
	            vl[l] = new ArrayList<>();
	        }
	        vl[l].add(str);
	        a[l]++;
	    }
}

public class Main {
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		try {
			st= new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int maxValue = 0;
			HashMap<String, Integer> vc = new HashMap<>();
			for(int i=0; i<n; i++) {
				String input = br.readLine();
				int value = vc.getOrDefault(input, 0)+1;
				vc.put(input, value);
				if(value > maxValue) {
					maxValue = value;
				}
			}

			Voca[] v = new Voca[maxValue+1];
			for(int i =1; i<=maxValue; i++) {
				v[i] = new Voca();
			}
			for(String key : vc.keySet()) {
				int l = key.length();
				if(l<m) continue;
				v[vc.get(key)].getVoca(key, l);
			}
			
			for(int i = 1; i<=maxValue; i++) {
				for(int j=m; j<=10; j++) { //v객체의 vl(길이별로 저장된)리스트를 각각 sort
				if(v[i].vl[j] == null) continue;
				Collections.sort(v[i].vl[j]);
				}
			}
			
			for(int i = maxValue; i>0; i--) {//빈도가 많은 것부터
				for(int j=10; j>=m; j--) {//길이가 긴 것부터
					if(v[i].vl[j] == null) continue;
					for(int k = 0; k< v[i].vl[j].size(); k++) {
						bw.write(v[i].vl[j].get(k)+"\n");
					}
				}
			}
			bw.flush();
			
		
		
		
		} catch (IOException e) {
			
		}
	}
}