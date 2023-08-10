import java.util.*;

class Solution {
        public int solution(int[] ingredient) {
        int answer = 0;

        // 역순으로 맞는 배열
        int[] correct = new int[]{1, 3, 2, 1};
        Deque<Integer> dq = new ArrayDeque<>();
        Deque<Integer> tmp = new ArrayDeque<>();

        for (int now : ingredient) {
            dq.offer(now);
            boolean flag = true;

            if (dq.size() >= 4) {
                for (int i = 0; i < 4; i++) {
                    int cur = dq.pollLast();
                    tmp.offer(cur);
                    if (cur != correct[i]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    // 햄버거 완성된 경우
                    while(!tmp.isEmpty()) {
                        tmp.pollLast();
                    }
                    answer++;
                } else {
                    // 햄버거 완성 못한 경우
                    while(!tmp.isEmpty()) {
                        int cur = tmp.pollLast();
                        dq.offer(cur);
                    }
                }
            }
        }

        return answer;
    }
}