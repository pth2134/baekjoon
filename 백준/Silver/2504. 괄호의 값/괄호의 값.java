import java.io.*;

public class Main {
			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] s = br.readLine().toCharArray();
		int l = s.length;
		int[] n = new int[l];
		boolean[] check = {true};
		
		if(s[0]==')'||s[0]==']') check[0] = false;
		
		for(int j =0; j<l-1; j++) { //첫 괄호 사이에 ()나 []를 전부 숫자로 48~57
			
			if(s[j]=='(') {
				if(s[j+1]==')') {
					s[j] ='1';
					n[j] =2;
					s[j+1] ='0';
					n[j+1] = 0;
					j++;
				}
			}
			else if(s[j]=='[') {
				if(s[j+1]==']') {
					s[j] ='1';
					n[j] = 3;
					s[j+1] ='0';
					n[j+1] = 0;
					j++;
				}
			}
				
		}
		
		int index = l-1;
		int lastIndex = 0;
		while(check[0]&&lastIndex!=index) {
			lastIndex = index;
			 //괄호를 모두 s배열에선 1로 바꾸기때문에 마지막엔 s[0]이 1이 된다.
			index = lastPare(s,index); //제일 뒷쪽에 있는 시작괄호 찾아보기 s[index] =( or [
            //마지막 괄호가 없다면 lastIndex==index를 만족 while문 탈출
			replacePare(s, n, index, l, check); //마지막 괄호를 숫자로
		}
		
		for(int j=1; j<l; j++) {  //올바르게 마쳤다면 s는 모두 '1'또는'0'으로 초기화됨		
			if(s[j]!='0'&&s[j]!='1') {
			check[0]=false;	
			}
		}
		
		if(check[0]) {	
			for(int j=1; j<l; j++) {
				n[0]+=n[j];
			}
			bw.write(n[0]+"");
		} else {
			bw.write(0+"");
		}
				
		br.close();
		bw.flush();		
		bw.close();		
	}	
	
	public static int lastPare(char[] s, int index) { 
		int i =0;
		for(int j =0; j<index; j++) { 
			if(s[j]=='(' | s[j]=='[') {
				i=j;
			}	
		} 
		return i;
	}
	
	public static void replacePare(char[] s,int[] n, int i, int l,boolean[] check) {
		if(s[i]=='(') {
			int start = i+1;
			int last = 0;
			int sum = 0;
			for(int j=start; j<l; j++) {
				if(s[j]=='1'|s[j]=='0') {
					sum += n[j];
					last = j;
					n[j] =0;
					s[j] ='0';
				}
				else if(s[j]==')') {
					s[j] ='0';
					break;
				}
				else {  //숫자가 아닌데 마지막 괄호를 닫는)대신 다른게 있으면 false
					check[0] = false;
					break;
				}
			}
			
			n[i] = sum*2;  //괄호안의 숫자 * 괄호종류   > (,[,],) = (,3,0,) = 6,0,0,0 
			s[i] = '1'; 
			if(last!=l-1) { //괄호가 닫히지 않고 끝날시 outOfArray발생 '([]'
				s[last+1] = '0';
			} else {
				check[0] =false;
			}	
		}
		
		else if(s[i]=='[') {
			int start = i+1;
			int last = 0;
			int sum = 0; //괄호 안의 숫자 합
			for(int j=start; j<l; j++) {
				if(s[j]=='1'|s[j]=='0') {
					last = j; //괄호 안의 숫자 마지막 인덱스
					sum+= n[j];
					n[j] = 0;
					s[j] = '0';
				}
				else if(s[j]==']') {
					s[j] ='0';
					break;
				}
				else {  //숫자가 아닌데 마지막 괄호를 닫는)대신 다른게 있으면 false
					check[0] = false;
					break;
				}
			}

			n[i] = sum*3;  //괄호안의 숫자 * 괄호종류   > (,[,],) = (,3,0,) = 6,0,0,0 
			s[i] = '1'; 
			if(last!=l-1) {
				s[last+1] = '0';
			} else {
				check[0] =false;
			}
		}
	}
}


