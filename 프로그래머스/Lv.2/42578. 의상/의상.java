import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] now : clothes) {
            map.put(now[1], map.getOrDefault(now[1], 0) + 1);
        }
        
        // 각 분류 + 1 이 경우의 수
        for (String now : map.keySet()) {
            answer *= map.get(now) + 1;
        }
        
        // 모두 착용 안 한 경우 제외
        answer -= 1;
        
        return answer;
    }
}