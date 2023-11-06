import java.util.*;
class Solution {

        static long answer;
        static int[] selected;

        public long solution(int[] weights) {
            answer = 0;

            Map<Integer, Integer> candidate = new HashMap<>();

            // 몸무게 저장
            for (int i = 0; i < weights.length; i++) {
                if (candidate.get(weights[i]) == null) candidate.put(weights[i], 1);
                else candidate.put(weights[i], candidate.get(weights[i]) + 1);
            }

            for (int x : candidate.values()){
                answer += (long)x * (x - 1) / 2;
            }

            List<Integer> origin = new ArrayList<>(candidate.keySet());

            selected = new int[2];
            combination(origin, candidate, 0, 0);

            return answer;
        }

        public void combination(List<Integer> origin, Map<Integer, Integer> cand, int cnt, int start) {
            if (cnt == 2) {
                int w1 = selected[0];
                int w2 = selected[1];

                if (w1*2 == w2*3 || w1*2 == w2*4 || w1*3 == w2*2 || w1*3 == w2*4 || w1*4 == w2*2 || w1*4 == w2*3) {
                    if (cand.get(w1) > 1 || cand.get(w2) > 1) answer +=  (long)cand.get(w1) * cand.get(w2);
                    else answer++;
                }

                return;
            }
            for (int i = start; i < origin.size(); i++) {
                selected[cnt] = origin.get(i);
                combination(origin, cand, cnt+1, i+1);
            }
        }

    }