import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			bw.write(1+"\n"+0);
			bw.flush();
			bw.close();
	
		}
		catch (Exception IO){
		}	
	}	

}