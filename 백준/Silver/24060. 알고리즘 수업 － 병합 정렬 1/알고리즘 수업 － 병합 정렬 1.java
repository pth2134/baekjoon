import java.io.*;
import java.util.*;

public class Main {
	static int[] temp;
	static int cnt = 0;
	static int k;
	static int result= -1;
	
	public static void merge(int[] a, int p, int q, int r) {
		int i = p; int j = q+1; int t = 0;
		while(i<= q && j<=r) { //p~q, p+1~r까지를 합쳐서 정렬
			if(a[i]<=a[j]) {
				temp[t++] = a[i++];
			} else {
				temp[t++] = a[j++];
			}
		}
		while(i<=q) {
			temp[t++] = a[i++];
		}
		while(j<=r) {
			temp[t++] = a[j++];
		}
		i = p; t = 0;
		while(i<=r) {
			a[i++] = temp[t++];
			cnt++;
			if( cnt == k) result = a[--i];
		}
	}
	
	public static void merge_sort(int[] a, int p, int r) {
		if(p<r) {
			int q = (p+r)/2;
			merge_sort(a, p, q);
			merge_sort(a,q+1,r);
			merge(a, p, q, r); // (a, p, p, p+1)부터 시작  > p~p , p+1~p+1 정렬
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		temp = new int[n];
		k = Integer.parseInt(st.nextToken());
		int[] a = new int[n];
		
		st= new StringTokenizer(br.readLine());
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		merge_sort(a, 0, n-1);
		bw.write(result+"");
		bw.flush();
	}
	
}
