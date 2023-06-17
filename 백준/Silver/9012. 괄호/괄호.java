import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        for(int i =0; i<n; i++) {
        	char[] input = br.readLine().toCharArray();
        	boolean check = true;
        	for(int j=0; j<input.length; j++) {
        		stack.push(input[j]);
        	}
        	
        	int right = 0;
        	while(!stack.empty()){
        		char pop = stack.pop();
        		if(pop==')') {
        			right++;
        		}
        		else if(pop=='(') {
        			right--;
        		}
        		if(right<0) {
        			check = false;
        			stack.clear();
        			break;
        		}
        	}
        	if(right!=0) check = false;
        	
        	if(check) {
        		bw.write("YES"+"\n");
        	}
        	else {
        		bw.write("NO"+"\n");
        	}
        	
        }
        bw.flush();
        bw.close();
    }
}