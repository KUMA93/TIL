import java.util.*;

class Solution {
    
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> origin = new HashMap<>();
        
        // 배열을 해시맵으로 매핑 시켜줌
        for (String x : participant) {
            origin.put(x, origin.getOrDefault(x, 0) + 1);
        }
        
        // 완주자 목록에서 하나씩 뺌
        for (String now : completion) {
            if (origin.get(now) == 1) origin.remove(now);
            else if(origin.get(now) > 1) origin.put(now, origin.get(now) - 1);
        }
        
        // 정답자
        Object[] res = origin.keySet().toArray();
        answer = res[0].toString();
        
        return answer;
    }
}