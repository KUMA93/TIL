import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    /*
     * 3 ≤ N ≤ 10
     * 1 ≤ M ≤ 5
     * 10 ≤ C ≤ 30
     * 벌통 하나당 최대 9
     */

    static int TC, N, M, C, maxProfit;
    static ArrayList<Integer> honey;
    static int[][] map;
    static int[] selected;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            maxProfit = 0;

            map = new int[N][N];
            selected = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            combination(0, 0);
            System.out.printf("#%d %d\n", t, maxProfit);
        }
    }

    public static void combination(int cnt, int start) {
        if (cnt == 2) {
            for (int i = 0; i < N - M + 1; i++) {
                for (int j = 0; j < N - M + 1; j++) {
                    int sum = getHoney(selected[0], i) + getHoney(selected[1], j);
                    maxProfit = Math.max(maxProfit, sum);
                }
            }
            return;
        }
        for (int i = start; i < N; i++) {
            selected[cnt] = i;
            combination(cnt + 1, i + 1);
        }
    }

    public static int getHoney(int x, int y) {
        ArrayList<Integer> cand = new ArrayList<>();
        int max = 0;

        for (int i = y; i < y + M; i++) {
            cand.add(map[x][i]);
        }

        // 현재 지점 기준 주어진 범위 M 내에서 가장 많은 꿀을 채취 하는 경우를 따져본다.
        for (int subset = 0; subset < (1 << M); subset++) {
            ArrayList<Integer> select = new ArrayList<>();
            int sum = 0;
            int profit = 0;

            for (int i = 0; i < M; i++) {
                if ((subset & (1 << i)) != 0) {
                    int cur = cand.get(i);
                    sum += cur;
                    profit += (int) Math.pow(cur, 2);

                    if(sum > C) profit = 0;
                }
            }
            max = Math.max(max, profit);
        }
        return max;
    }
}