import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Stack<Character> stack = new Stack<>();
        while(true) {
        	String str = br.readLine();
        	if(str.equals(".")) break;
        	char[] input = str.toCharArray();
        	ArrayList<Character> c = new ArrayList<>(List.of('(',')','[',']'));
        	
        	boolean check = true;
        	for(int j=0; j<input.length; j++) {
        		char key = input[j];
        		if(c.contains(key)&&check) {
        			try {
        				switch(key) {
                        case ')':
                            if(stack.peek() == '(') {
                            	stack.pop();
                            	break;
                            } else {
                            	check =false;
                            	break;
                            }
                            
                        case ']':
                        	 if(stack.peek() == '[') {
                             	stack.pop();
                             	break;
                             } else {
                             	check =false;
                             	break;
                             } 
                        default :
                            stack.push(key);
                            break;
            			}
					} catch (EmptyStackException e) {
						check = false;
					}
        			
        		}
        	}
        	if(!stack.empty()) check =false;
    		stack.clear();
        	if(check) {
        		bw.write("yes\n");
        	}
        	else {
        		bw.write("no\n");
        	}
        	
        }
        bw.flush();
        bw.close();
    }
}