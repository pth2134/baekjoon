import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        StringBuilder builder = new StringBuilder();

        int l = reader.nextInt();
        int c = reader.nextInt();
        char[] chars = new char[c];
        boolean[] isVowels = new boolean[c];
        Set<Character> vowels = Set.of(
                'a', 'e', 'i', 'o', 'u'
        );

        for (int i = 0; i < chars.length; i++) {
            chars[i] = reader.nextChar();
        }
        Arrays.sort(chars);

        for (int i = 0; i < chars.length; i++) {
            if (vowels.contains(chars[i])) isVowels[i] = true;
        }

        int[] idx = new int[l];
        Arrays.fill(idx, -1);
        int depth = 0;
        int last = c - l;
        int start = 0;
        int son = 0;
        int mom = 0;

        while (idx[0] <= last) {
            if (l - depth > c - start) {
                if (depth == 0) break;
                if (idx[depth] != -1) {
                    if (isVowels[idx[depth]]) mom--;
                    else son--;
                }
                idx[depth] = -1;
                depth--;
                start = idx[depth] + 1;
                continue;
            }
            if (depth < l) {
                if (idx[depth] != -1) {
                    if (isVowels[idx[depth]]) mom--;
                    else son--;
                }
                idx[depth] = start;
                if (isVowels[start]) mom++;
                else son++;
                start++;
                depth++;
            } else {
                if (son >= 2 && mom >= 1) {
                    for (int i = 0; i < l; i++) {
                        builder.append(chars[idx[i]]);
                    }
                    builder.append('\n');
                }

                if (isVowels[idx[l - 1]]) mom--;
                else son--;
                depth--;
                start = idx[depth] + 1;
                idx[depth] = -1;
            }
        }
        System.out.print(builder);
    }


    static class Reader {
        final int SIZE = 1 << 15;
        byte[] buffer = new byte[SIZE];
        int index, size;

        boolean isNumber(byte c) {
            return 47 < c && c < 58;
        }

        int nextInt() throws IOException {
            int n = 0;
            byte c;
            while ((c = read()) <= 32) ;
            boolean neg = c == '-';
            if (neg) c = read();
            do n = (n << 3) + (n << 1) + (c & 15); while (isNumber(c = read()));
            return neg ? -n : n;
        }

        char nextChar() throws IOException {
            byte c;
            while ((c = read()) <= 32) ;
            return (char) c;
        }

        byte read() throws IOException {
            if (index == size) {
                size = System.in.read(buffer, index = 0, SIZE);
                if (size < 0) buffer[0] = -1;
            }
            return buffer[index++];
        }
    }
}