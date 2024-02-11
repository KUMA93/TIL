import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int size = numbers.length;
        
        // 앞자리 1 ~ 9 순으로 묶음
        List[] tmp = new ArrayList[10];
        
        for (int i = 0; i < 10; i++) tmp[i] = new ArrayList<Integer>();
        
        for (int i = 0; i < size; i++) {
            
            int cur = numbers[i];
            
            while(cur >= 10) cur /= 10;
            
            // System.out.print(cur + " ");
            
            tmp[cur].add(numbers[i]);
        }
        
        // 가장 큰 수 만들 경우로 정렬
        for (int i = 0; i < 10; i++) {
            Collections.sort(tmp[i], new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    String combined1 = o1.toString() + o2.toString();
                    String combined2 = o2.toString() + o1.toString();
                    return combined2.compareTo(combined1);
                }
            });
        }
        
        for (int i = 9; i >= 0; i--){
            for (int j = 0; j < tmp[i].size(); j++) {
                answer += tmp[i].get(j).toString();
            }
        }
        
        if (answer.charAt(0) == '0') answer = "0";
        
        return answer;
    }
}