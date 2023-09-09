import java.io.*;
import java.util.*;

public class Main{
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int change = 1000-Integer.parseInt(br.readLine());
		int[] coin = {500,100,50,10,5,1};
		int cnt = 0;
		for (int j = 0; j < coin.length; j++) {
			while(change>=coin[j]) {
				change-=coin[j];
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
