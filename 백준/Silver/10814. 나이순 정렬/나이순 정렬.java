import java.io.*;
import java.util.*;

public class Main {
			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		People[] people = new People[n];
		
		for(int i =0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			people[i] = new People(Integer.parseInt(st.nextToken()),i,st.nextToken());
		}
		Arrays.sort(people);
		
		for(People i : people) {
			bw.write(i.age+" "+i.name+"\n");
		}
		bw.flush();		
		bw.close();		
	}	
}

class People implements Comparable<People>{
	int age;
	int number;
	String name;
	
	public People(int age, int number, String name) {
		this.age = age;
		this.number = number;
		this.name = name;
	}
	
	public int compareTo(People p) {
		if(age == p.age) {
			return number - p.number;
		}
		else return age - p.age;
	}
}