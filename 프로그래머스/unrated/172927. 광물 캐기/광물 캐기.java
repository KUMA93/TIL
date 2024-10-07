import java.util.*;

class Solution {
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int max = 0;
        
        // 채광 효율표
        int[][] score = new int[][] {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        
        // 채광할 광석의 개수 계산
        for (int i = 0; i < 3; i++) {
            max += picks[i]*5;
        }   
        // System.out.println(max);
        
        // 5개씩 광물 분할
        int[][] order = new int[max/5][3];
        
        for (int i = 0; i < max; i++) {
            if(i >= minerals.length) break;
            String now = minerals[i];
            int idx = i/5;
            
            if (now.equals("diamond")){
                order[i/5][0]++;    
            }else if (now.equals("iron")) {
                order[i/5][1]++;
            }else {
                order[i/5][2]++;
            }
        }
        
        // 다이아 많은 순 / 그 다음은 철 많은 순으로 정렬
        Arrays.sort(order, (o1, o2) -> {
            if (o1[0] == o2[0]) return o2[1] - o1[1];
            else return o2[0] - o1[0];   
        });

        for (int[] x : order) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
        
        // 광물 캐기
        int idx = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < picks[i]; j++) {
                answer += score[i][0]*order[idx][0] + score[i][1]*order[idx][1] + score[i][2]*order[idx][2];
                idx++;
            }              
        }
        
        return answer;
    }
    
}