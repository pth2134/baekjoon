import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        long k = reader.nextLong();
        List<Long> list = new ArrayList<>();
        
        long i = 2;
        while (i * i <= k) {
            if(k%i ==0) {
                list.add(i);
                k /= i;
            } else i++;
        }
        if (k > 1) list.add(k);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append('\n');
        for (Long l : list) {
            sb.append(l).append(' ');
        }
        System.out.println(sb.toString());
    }


    static class Reader {
        final int SIZE = 1 << 15;
        byte[] buffer = new byte[SIZE];
        int index, size;

        boolean isNumber(byte c) {
            return 47 < c && c < 58;
        }

        long nextLong()  throws IOException {
            long n = 0;
            byte c;
            while ((c = read()) <= 32) ;
            boolean neg = c == '-';
            if (neg) c = read();
            do n = (n << 3) + (n << 1) + (c & 15); while (isNumber(c = read()));
            return neg ? -n : n;
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