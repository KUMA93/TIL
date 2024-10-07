import java.io.*;
import java.math.BigInteger;

public class Main {
    static int N;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        br.close();
        BigInteger cnt = new BigInteger("2");
        BigInteger res = cnt.pow(N).subtract(BigInteger.ONE);
        System.out.println(res);

        if (N <= 20) {
            hanoi(N, 1, 2, 3);
            bw.flush();
            bw.close();
        }
    }

    public static void hanoi(int num, int from, int by, int to) throws IOException {
        if(num == 1) {
            bw.write(from + " " + to + "\n");
            return;
        }else {
            hanoi(num-1, from, to, by);
            bw.write(from + " " + to + "\n");
            hanoi(num-1, by, from, to);
        }
    }
}
