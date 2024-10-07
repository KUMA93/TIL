import java.util.*;

class Solution {
    // s와 e에서 발사하는 미사일로는 요격 불가능
    // 실수인 x 좌표에서도 발사가능 -> 끝좌표 기준으로 하면 됨
    // 1 ≤ targets의 길이 ≤ 500,000
    // 0 ≤ s < e ≤ 100,000,000
    
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        
        int std = 0;
        for (int[] x : targets) {
            if (x[0] >= std) {
                std = x[1];
                answer++;
            }
        }        
        
        return answer;
    }
}