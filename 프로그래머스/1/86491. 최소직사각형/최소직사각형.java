import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 1000000;
        int size = sizes.length;
        
        for (int i = 0; i < size; i++) {
            if (sizes[i][1] >= sizes[i][0]) swap(i, sizes);
        }
        
        answer = calculate(sizes);
        
        return answer;
    }
    
    public static void swap(int x, int[][] map) {
        int tmp = map[x][0];
        map[x][0] = map[x][1];
        map[x][1] = tmp;
    }
    
    public static int calculate(int[][] map) {
        int maxX = 0, maxY = 0;
        
        for (int i = 0; i < map.length; i++) {
            maxX = Math.max(maxX, map[i][0]);
            maxY = Math.max(maxY, map[i][1]);
        }
        
        return maxX * maxY;
    }
}