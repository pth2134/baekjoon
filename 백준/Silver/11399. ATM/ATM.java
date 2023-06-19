import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> people =  new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			people.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(people);
		int[] waitSum = new int[people.size()];
		
		waitSum[0] = people.get(0);
		int sum = waitSum[0];
		for (int i = 1; i < waitSum.length; i++) {
			waitSum[i] = waitSum[i-1]+people.get(i);
			sum +=waitSum[i];
		}
		
		System.out.println(sum);
		
	}
}
