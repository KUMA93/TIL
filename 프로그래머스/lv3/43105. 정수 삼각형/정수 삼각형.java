import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        // 맨 아래에서 윗줄부터 아랫줄 양옆 중 높은 숫자 더해줌
        int size = triangle.length; 
        // if (size == 1) return triangle[0][0];
        
        for (int i = size-2; i >= 0; i--) {
            for (int j = 0; j < i+1; j++) {
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);    
            }
        }
        answer = triangle[0][0];
        return answer;
    }
}