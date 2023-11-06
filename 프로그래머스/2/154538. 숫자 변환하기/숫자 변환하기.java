import java.util.*;
class Solution {
        public int solution(int x, int y, int n) {
            int answer = -1;

            Deque<int[]> dq = new ArrayDeque<>();
            Set<Integer> visited = new HashSet<>();

            dq.offer(new int[] {x, 0});
            visited.add(x);

            while(!dq.isEmpty()) {
                int[] now = dq.pollFirst();
                int cur = now[0];
                int cnt = now[1];

                if (cur > y) continue;
                if (cur == y) answer = cnt;


                if (!visited.contains(cur + n)) {
                    visited.add(cur + n);
                    dq.offer(new int[] {cur + n, cnt + 1});
                }
                if (!visited.contains(cur * 2)) {
                    visited.add(cur * 2);
                    dq.offer(new int[] {cur * 2, cnt + 1});

                }
                if (!visited.contains(cur * 3)) {
                    visited.add(cur * 3);
                    dq.offer(new int[] {cur * 3, cnt + 1});
                }
            }

            return answer;
        }
    }