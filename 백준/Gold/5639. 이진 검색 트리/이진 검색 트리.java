import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> que = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			try {
				que.add(Integer.parseInt(br.readLine()));
			} catch (NumberFormatException e) {
				break;
			}
		}

		if (que.isEmpty())
			return;

		Node rootNode = constructBST(Integer.MIN_VALUE, Integer.MAX_VALUE);
		//전위순회
		exportResult(rootNode);
		System.out.print(sb);
	}

	static class Node {
		int value;
		Node left;
		Node right;

		Node(int value) {
			this.value = value;
		}
	}

	static Node constructBST(int min, int max) {
		if (que.isEmpty())
			return null;
		int value = que.peek();
		if (value < min || value > max)
			return null; // 현재 인덱스의 값이 범위에 맞지 않으면 null 반환

		Node rootNode = new Node(que.poll());
		rootNode.left = constructBST(min, value); // 왼쪽 서브트리 생성
		rootNode.right = constructBST(value, max); // 오른쪽 서브트리 생성
		return rootNode;
	}

	public static void exportResult(Node rootNode) {
		if (rootNode.left != null)
			exportResult(rootNode.left);
		if (rootNode.right != null)
			exportResult(rootNode.right);
		sb.append(rootNode.value).append("\n");
	}

}
