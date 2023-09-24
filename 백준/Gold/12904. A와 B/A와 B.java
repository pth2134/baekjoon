import java.io.*;
class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		boolean reverse = false;
		int size = t.length();
		int start = 0;
		int last = t.length()-1;
		while(size>s.length()){
			if(reverse){
				if(t.charAt(start)=='B') reverse = !reverse;
				start++;
				size--;
			} else{
				if(t.charAt(last)=='B') reverse = !reverse;
				last--;
				size--;
			}
		}
		String result="";
		if(!reverse){
			result = t.substring(start,last+1);
		} else{
			for (int i = last; i >= start; i--) {
				result+=t.charAt(i);
			}
		}
		if(result.equals(s)){
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}