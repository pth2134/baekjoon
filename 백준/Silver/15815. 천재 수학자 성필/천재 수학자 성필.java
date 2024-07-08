import java.io.IOException;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		String str = reader.nextString();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c > 47 && c < 58)
				stack.add(c - 48);
			else {
				switch (c) {
					case '+':
						stack.push(stack.pop() + stack.pop());
						break;
					case '-':
						stack.push(-stack.pop() + stack.pop());
						break;
					case '*':
						stack.push(stack.pop() * stack.pop());
						break;
					case '/':
						int p = stack.pop();
						stack.push(stack.pop() / p);
						break;
				}
			}
		}

		System.out.println(stack.pop());

	}

	static class Reader {
		final int SIZE = 1 << 15;
		byte[] buffer = new byte[SIZE];
		int index, size;

		String nextString() throws IOException {
			StringBuilder sb = new StringBuilder();
			byte c;
			while ((c = read()) <= 32)
				;
			do {
				sb.append((char)c);
			} while ((c = read()) > 32);
			return sb.toString();
		}

		byte read() throws IOException {
			if (index == size) {
				size = System.in.read(buffer, index = 0, SIZE);
				if (size < 0)
					buffer[0] = -1;
			}
			return buffer[index++];
		}
	}
}
