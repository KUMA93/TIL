import java.util.*;
    class Solution {

        public long solution(int[] weights) {
            long answer = 0;

            int[] origin = new int[1001];
            int[] multiWeight = new int[4001];

            // 몸무게 저장
            for (int i = 0; i < weights.length; i++) {
                int w = weights[i];

                // 중복 확인
                long dup = origin[w];

                int w2 = w * 2;
                int w3 = w * 3;
                int w4 = w * 4;

                if (dup > 0) {
                    answer += dup;

                    answer += multiWeight[w2] - dup;
                    answer += multiWeight[w3] - dup;
                    answer += multiWeight[w4] - dup;
                } else {
                    answer += multiWeight[w2];
                    answer += multiWeight[w3];
                    answer += multiWeight[w4];
                }

                origin[w]++;
                multiWeight[w2]++;
                multiWeight[w3]++;
                multiWeight[w4]++;
            }

            return answer;
        }

    }