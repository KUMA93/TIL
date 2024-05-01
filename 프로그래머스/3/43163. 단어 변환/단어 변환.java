import java.util.*;

class Solution {
    
    static int len, dt;
    static String[] word;
    
    static class Pos{
        String str;
        int cnt;
        
        public Pos(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        len = begin.length();
        dt = 0;
        word = words;
        
        bfs(begin, target);
        answer = dt;
        
        return answer;
    }
    
    public static void bfs(String start, String target) {
        boolean[] visited = new boolean[word.length];
        Deque<Pos> dq = new ArrayDeque<>();
        
        dq.offer(new Pos(start, 0));
        
        while(!dq.isEmpty()) {
            Pos now = dq.pollFirst();
            
            boolean[] can = canGo(now.str);
            
            if (now.str.equals(target)){
                dt = now.cnt;
                return;
            }
            
            for (int i = 0; i < word.length; i++) {
                if (!can[i] || visited[i]) continue;
                dq.offer(new Pos(word[i], now.cnt + 1));
                visited[i] = true;
            }                
        }

    }
    
    public static boolean[] canGo(String now) {
        boolean[] res = new boolean[word.length];
        
        for (int i = 0; i < word.length; i++) {
            boolean flag = false;
            int cnt = 0;
            
            for (int j = 0; j < len; j++) {
                if (now.charAt(j) != word[i].charAt(j)) cnt++;
            }
            if (cnt == 1) flag = true;
            res[i] = flag;
        }
        
        return res;
    }
}