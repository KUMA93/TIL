import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static int[][] map;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for(int testcase = 1; testcase <= t; testcase++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxSum = 0;

            for (int i = 0; i < N-M+1; i++) {
                for (int j = 0; j < N-M+1; j++) {
                    int tmpSum = 0;
                    for (int x = 0; x < M; x++){
                        for (int y = 0; y < M; y++) {
                            tmpSum += map[i+x][j+y];
                        }
                    }
                    if (tmpSum > maxSum) maxSum = tmpSum;
                }
            }

            System.out.printf("#%d %d\n", testcase, maxSum);
        }
    }
}
