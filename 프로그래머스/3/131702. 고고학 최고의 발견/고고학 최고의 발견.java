import java.util.*;

class Solution {
    static int n, res, answer;
    static int[] rotateNum;
    static int[][] map, origMap;
    
    public int solution(int[][] clockHands) {
        answer = Integer.MAX_VALUE;
        n = clockHands.length;
        origMap = clockHands;
        rotateNum = new int[n];

        permutation(0);
        
        return answer;
    }
    
    void permutation(int cnt) {
        if (cnt == n) {
            res = 0;
            map = copyMap(origMap);
            
            // 첫 째줄 세팅
            for (int i = 0; i < n; i++) {
                res += rotateNum[i];
                rotate(0, i, rotateNum[i]);
            }
            
            // 이후 줄 검사
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int prev = map[i-1][j];

                    if (prev == 0) continue;
                    else {
                        res += (4 - prev) % 4;
                        rotate(i, j, (4 - prev) % 4);    
                    }
                }
            }
            boolean flag = true;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] != 0) flag = false;
                    // System.out.print(map[i][j] + " ");
                }
                // System.out.println();
            }
            // System.out.println(res);
            
            if (flag) answer = Math.min(answer, res);
            
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            rotateNum[cnt] = i;
            permutation(cnt + 1);
        }
        
    }
    
    int[][] copyMap(int[][] orig) {
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = orig[i][j];
            }
        }
        return res;
    }
    
    void rotate(int x, int y, int degree) {
        if (isInMap(x-1, y)) map[x-1][y] = (map[x-1][y] + degree) % 4;
        if (isInMap(x, y-1)) map[x][y-1] = (map[x][y-1] + degree) % 4;
        if (isInMap(x, y+1)) map[x][y+1] = (map[x][y+1] + degree) % 4;
        if (isInMap(x+1, y)) map[x+1][y] = (map[x+1][y] + degree) % 4;
        map[x][y] = (map[x][y] + degree) % 4;
    }
    
    boolean isInMap(int x, int y) {
        return ((0 <= x && x < n) && (0 <= y && y < n));
    }
}