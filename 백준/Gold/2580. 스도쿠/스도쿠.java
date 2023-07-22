import java.io.*;
import java.util.*;

class Main{
	static boolean[][] row = new boolean[10][10];
	static boolean[][] column = new boolean[10][10];
	static boolean[][] square = new boolean[10][10];
	static int[][] sudoku = new int[10][10];
	static boolean clear = false;
	
	static void sudoku(int r, int c) {
		int j = c;
		for(int i =r; i<=9; i++) {
			for (;j <=9; j++) {
				if(sudoku[i][j]==0) {
					boolean pos = false;
					for (int k = 1; k <=9; k++) {
						if(!row[i][k]&&!column[j][k]&&!square[(i-1)/3*3+(j+2)/3][k]) {
							pos = true;
							row[i][k]=column[j][k]=square[(i-1)/3*3+(j+2)/3][k]=true;
							sudoku[i][j]=k;
							sudoku(i,j+1);
							if(!clear) {
								pos = false;
								row[i][k]=column[j][k]=square[(i-1)/3*3+(j+2)/3][k]=false;
								sudoku[i][j]=0;
							}
						}
					}
					if(!pos) return;
				}
			}
			j=1;
			
		}
		clear = true;
	}
	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			
			for (int i = 1; i <= 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= 9; j++) {
					int input = Integer.parseInt(st.nextToken());
					sudoku[i][j] = input;
					row[i][input] = true;
					column[j][input] = true;
					square[(i-1)/3*3+(j+2)/3][input] = true;
				}
			}
			
			sudoku(1,1);
			
			for(int i =1; i<=9; i++) {
				for(int j=1; j<=9; j++) {
					bw.write(sudoku[i][j]+" ");
				}
				bw.newLine();
			}
			bw.flush();
		}
 }