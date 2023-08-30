import java.util.*;

class Solution {
    public static int solution(int[] topping) {
        int answer = 0;
        int size = topping.length;

        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        // 해시맵에 모든 토핑 개수 저장
        for (int i = 0; i < size; i++) {
            if (map.get(topping[i]) == null) {
                map.put(topping[i], 1);
            } else{
                map.put(topping[i], map.get(topping[i]) + 1);
            }
        }

        // 왼쪽부분 하나씩 카운트
        for (int i = 0; i < size; i++) {
            set.add(topping[i]);
            map.put(topping[i], map.get(topping[i]) - 1);
            if (map.get(topping[i]) == 0){
                map.remove(topping[i]);
            }
            if (set.size() == map.size()) {
                answer++;
            }
        }

        return answer;
    }
}