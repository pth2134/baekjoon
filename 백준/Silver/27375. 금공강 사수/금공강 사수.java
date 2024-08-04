import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] lessons = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            lessons[i][0] = Integer.parseInt(st.nextToken());
            lessons[i][1] = Integer.parseInt(st.nextToken());
            lessons[i][2] = Integer.parseInt(st.nextToken());
        }

        backtracking(K,0, 0, lessons, new boolean[5][11]);
        System.out.println(count);

    }

    private static void backtracking(int K, int cnt, int start, int[][] lessons, boolean[][] visited) {
        if (cnt == K) {
            count++;
            return;
        }
        for (int i = start; i < lessons.length; i++) {
            if (isPossible(visited, lessons[i])) {
                changeStatus(lessons[i], visited, true);

                backtracking(K,cnt+(lessons[i][2]-lessons[i][1]+1),i+1,lessons,visited);

                changeStatus(lessons[i], visited, false);
            }
        }

    }

    private static void changeStatus(int[] lesson, boolean[][] visited, boolean status) {
        for (int i = lesson[1]; i <= lesson[2]; i++) {
            visited[lesson[0]][i] = status;
        }
    }

    private static boolean isPossible(boolean[][] visited, int[] lesson) {
        if (lesson[0] == 5) {
            return false;
        }
        for (int i = lesson[1]; i <= lesson[2]; i++) {
            if(visited[lesson[0]][i]) return false;
        }
        return true;

    }

}