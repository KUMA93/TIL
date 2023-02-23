import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main {
    static int N, M, D, maxVal;
    static archer[] archers;
    static int[] selected;
    static int[][] map;
    static class archer {
        int x;
        int y;
        int d;
        int minDt;
        public archer(int y, int d) {
            this.x = N;
            this.y = y;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        selected = new int[3];
        archers = new archer[3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        getPosition(0, 0);
        System.out.println(maxVal);
    }
    public static void getPosition(int cnt, int start) {
        if (cnt == 3) {
            for (int i = 0; i < 3; i++) {
                archers[i] = new archer(selected[i], D);
//                System.out.print(selected[i] + " ");
            }
//            System.out.println();
            maxVal = Math.max(maxVal, simulation(archers));
            return;
        }
        for (int i = start; i < M; i++) {
            selected[cnt] = i;
            getPosition(cnt + 1, i + 1);
        }
    }
    public static int simulation(archer[] archers) {
        int cnt = 0;
        int[][] cpymap = copyMap(map);
        for (int t = 0; t < N; t++) {
            ArrayList<Integer[]> targetList = new ArrayList<>(); //선택된 enemy들
            for (int a = 0; a < 3; a++) {
                int minD = Integer.MAX_VALUE;
                int minX = Integer.MAX_VALUE;
                int minY = Integer.MAX_VALUE;
                for (int i = N-1; i >= 0; i--) {
                    for (int j = 0; j < M; j++) {
                        if (cpymap[i][j] == 1){
                            int range = calcRange(i, j, archers[a].x, archers[a].y);
                            if (minD > range){
                                minD = range;
                                minX = i;
                                minY = j;
                            }else if (minD == range){
                                if(minY > j){
                                    minX = i;
                                    minY = j;
                                }
                            }
                        }
                    }
                }
                if(minD <= archers[a].d){
                    Integer[] tg = {minX, minY, minD};
                    // 중복 검사
                    boolean flag = true;
                    for (int e = 0; e < targetList.size(); e++) {
                        if (!duplicationCheck(tg, targetList.get(e))) flag = true;
                        else flag = false;
                    }
                    if(flag) targetList.add(tg);
                }
            }

            // 화살 쏘기
            for (Integer[] tg : targetList) {
                cpymap[tg[0]][tg[1]] = 0;
                cnt++;
//                System.out.print(tg[0] + " " + tg[1] + "\n");
            }
            // 한 칸씩 당기기
            for (int i = N-1; i > 0; i--) {
                for (int j = 0; j < M; j++) {
                    cpymap[i][j] = cpymap[i-1][j];
                }
            }
            for (int i = 0; i < M; i++) {
                cpymap[0][i] = 0;
            }
        }
        return cnt;
    }
    private static boolean duplicationCheck(Integer[] a, Integer[] b) {
        for (int i = 0; i < 2; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
    public static int calcRange(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
    public static int[][] copyMap (int[][] orig){
        int[][] cpy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cpy[i][j] = orig[i][j];
            }
        }
        return cpy;
    }
}