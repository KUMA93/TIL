class Solution {
    
    static int[][] map;
    static int n, m;
    
    public int solution(int[][] beginning, int[][] target) {
        int answer = -1;
        n = beginning.length;
        m = beginning[0].length;
        
        int[][] orig = new int[n][m];
        map = new int[n][m];
        
        int res = Integer.MAX_VALUE;
        
        // 상태가 다른 지점 기록
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                if (beginning[i][j] != target[i][j]) orig[i][j] = 1;
                else orig[i][j] = 0;
            }
        }
        
        for (int r = 0; r < (1 << n); r++) {
            for (int c = 0; c < (1 << m); c++) {
                
                map = copyMap(orig);
                int cnt = 0;
                
                for (int i = 0; i < n; i++) {
                    if ((r & (1 << i)) != 0) {
                        cnt++;
                        reverseRow(i);
                    }
                }
                
                for (int j = 0; j < m; j++) {
                    if ((c & (1 << j)) != 0) {
                        cnt++;
                        reverseCol(j);
                    }
                }
                
                if (checkMap()) res = Math.min(res, cnt);
                
            }
        }
        
        if (res != Integer.MAX_VALUE) answer = res;
        
        return answer;
    }
    
    boolean checkMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1)return false;
            }
        }
        return true;
    }
    
    int[][] copyMap(int[][] orig) {
        int[][] res = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = orig[i][j];
            }
        }
        
        return res;
    }
    
    void reverseRow(int k) {
        for (int i = 0; i < m; i++) {
            map[k][i] = (map[k][i] + 1) % 2;
        }
    }
    
    void reverseCol(int k) {
        for (int i = 0; i < n; i++) {
            map[i][k] = (map[i][k] + 1) % 2;
        }
    }
    
    // void printMap(int[][] map) {
    //     for (int[] x : map) {
    //         for (int y : x) {
    //             System.out.print(y + " ");
    //         }
    //         System.out.println();
    //     }
    // }
}