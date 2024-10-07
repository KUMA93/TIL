import java.util.*;

class Solution {
    static int[] select;
    static boolean[] visited;
    static int answer, size;
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        size = dungeons.length;
        
        select = new int[size];
        visited = new boolean[size];
        
        dfs(0, size, k, dungeons);
        
        return answer;
    }
    
    public void dfs(int lv, int depth, int k, int[][] dungeons) {
        if (lv == depth) {
            int cnt = 0;
            for (int x : select) {
                if (dungeons[x][0] > k) continue;
                k -= dungeons[x][1];
                cnt++;
            }
            
            answer = Math.max(answer, cnt);
        
            return;
        }
        
        for (int i = 0; i < size; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            select[lv] = i;
            dfs(lv + 1, depth, k, dungeons);
            visited[i] = false;
        }
    }
    
    
}