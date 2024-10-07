class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        /**
        0 1 0 0 1
        2 0 2 2 1
        0 1 0 2 1
        0 1 1 0 1
        2 2 2 2 0
        **/
        
        int[][] map = new int[n][n];
        
        for (int[] res : results) {
            map[res[0]-1][res[1]-1] = 1;
            map[res[1]-1][res[0]-1] = -1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (map[i-1][k-1] == 1 &&  map[k-1][j-1] == 1) {
                        map[i-1][j-1] = 1;
                        map[j-1][i-1] = -1;
                    }
                    
                    if (map[i-1][k-1] == -1 && map[k-1][j-1] == -1) {
                        map[i-1][j-1] = -1;
                        map[j-1][i-1] = 1;
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            int zero = 0;
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) zero++;
            }
            
            if (zero == 1) answer++; 
        }
        
        for (int[] x : map) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
        
        
        return answer;
    }
}