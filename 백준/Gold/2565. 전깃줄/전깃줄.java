import java.io.*;
import java.util.*;

class Main{
	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer> A = new ArrayList<>();
			int[] B = new int[501];
			int[] up = new int[n];
			int[] cnt = new int[n];
			for(int i =0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				A.add(Integer.parseInt(st.nextToken()));
				B[A.get(i)] = Integer.parseInt(st.nextToken());
			}
			
			Collections.sort(A);
			for(int i =0; i<n; i++) {
				up[i] = B[A.get(i)];
			}
			
			int max = 0;
			
			for(int i=0; i<n; i++) {
				for(int j=i+1; j<n; j++) {
					if(up[j]>up[i]&&cnt[j]<=cnt[i]) {
						cnt[j]=cnt[i]+1;
					}
				}
				max = max < cnt[i] ? cnt[i] : max;
			}
			bw.write(n-max-1+"");
			bw.flush();
		}
 }