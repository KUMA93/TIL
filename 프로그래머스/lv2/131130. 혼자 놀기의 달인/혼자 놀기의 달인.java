import java.util.*;

class Solution {
    static int size, answer;
    static int[] numbers;
    static List<Integer>[] group;

    public static int solution(int[] cards) {
        // cards idx -> boolean 으로 방문처리
        // idx 1부터 그룹핑
        // (idx, val)

        answer = 0;
        size = cards.length;
        boolean[] visited;
        group = new ArrayList[size + 1];
        for (int i = 0; i < size + 1; i++) {
            group[i] = new ArrayList<>();
        }

        for (int i = 1; i <= size; i++) {
            visited = new boolean[size];
            int idx = i - 1;

            while(!visited[idx]){
                visited[idx] = true;
                group[i].add(cards[idx]);
                idx = cards[idx] - 1;
            }
        }

        numbers = new int[2];

        // 2개 그룹 뽑기
        combination(0, 0);

        return answer;
    }

    public static void combination(int cnt, int start) {
        if (cnt == 2) {
            boolean[] visited = new boolean[size + 1];
            boolean flag = true;
            for (int x : group[numbers[0]]) {
                visited[x] = true;
            }
            for (int x : group[numbers[1]]) {
                if (visited[x]) flag = false;
            }

            if (flag) answer = Math.max(answer, group[numbers[0]].size()*group[numbers[1]].size());

            return;
        }
        for (int i = start; i < size; i++) {
            numbers[cnt] = i+1;
            combination(cnt+1, i+1);
        }
    }
}