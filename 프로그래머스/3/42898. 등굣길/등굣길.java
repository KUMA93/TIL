import java.util.*;

class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] map = new int[n+1][m+1];
        
        // 물에 잠긴 지역 마킹
        for (int[] x : puddles) {
            map[x[1]][x[0]] = -1;
        }
        
        map[1][1] = 1;
        
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == -1) map[i][j] = 0;
                else {
                    map[i][j] += (map[i-1][j] + map[i][j-1]) % 1000000007;
                }
            }
        }
        
        // for (int[] x : map) {
        //     for (int y : x) {
        //         System.out.printf("%d ", y);
        //     }
        //     System.out.println();
        // }
        
        answer = map[n][m];
        
        return answer;
    }
    
}