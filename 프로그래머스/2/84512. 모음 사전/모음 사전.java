import java.util.*;

class Solution {
    
    static String[] words = {"A", "E", "I", "O", "U"};
    static Map<String, Integer> map;
    static int cnt = 0;
    
    public int solution(String word) {
        int answer = 0;
        map = new HashMap<>();
        dfs("");
        
        answer = map.get(word);
        
        return answer;
    }
    
    public static void dfs(String str) {
        
        if (str.length() > 5) return;
        
        map.put(str, cnt++);
        
        for (int i = 0; i < 5; i++) {
            dfs(str + words[i]);
        }
    }
}