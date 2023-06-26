import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken()); //세로
		int p = Integer.parseInt(st.nextToken()); //가로
		int vGoal = v-1;
		int pGoal = p-1;
		
		boolean[][] map = new boolean[v][p];
		for (int i = 0; i < v; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < p; j++) {
				if(c[j] == '1') {
					map[i][j] = true;
				}
			}
		}
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0)); 
		map[0][0] = false;
		while(q.peek().p!=pGoal||q.peek().v!=vGoal) {
			q.poll().search(map, q);
		}
		
		bw.write(q.peek().cnt+"");
		bw.flush();
	}
	
}

class Point{
	int v;
	int p;
	int cnt = 1;
	
	Point(int v,int p) {
		this.v = v;
		this.p = p;
	}
	
	Point(int v,int p, int cnt) {
		this.v = v;
		this.p = p;
		this.cnt = cnt;
	}
	
	public void search(boolean[][] map,Queue<Point> q) {
		if(v<map.length-1) {
			if(map[v+1][p]) {
				q.add(new Point(v+1,p,cnt+1));
				map[v+1][p] = false;
			}
		}
		if(v>0) {
			if(map[v-1][p]) {
				q.add(new Point(v-1,p,cnt+1));
				map[v-1][p] = false;
			}
		}
		if(p<map[0].length-1) {
			if(map[v][p+1]) {
				q.add(new Point(v,p+1,cnt+1));
				map[v][p+1] = false;
			}
		}
		if(p>0) {
		if(map[v][p-1]) {
			q.add(new Point(v,p-1,cnt+1));
			map[v][p-1] = false;
			}
		}
	}
}