import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    /*
    방향 존재
    여러 정점에 동시 연락 가능
    연락 인원 최대 100명
    중간에 비어있는 번호 존재가능 ~100번까지
     */
    // 입력 데이터 길이 N, 시작점 start
    static int N, start, maxLv;
    static int[] visited;
    static ArrayList<Integer>[] adj;

    static class pos {
        int num;
        int Lv;
        public pos(int num, int lv) {
            this.num = num;
            Lv = lv;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for(int tc = 1; tc <= 10; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            visited = new int[101];
            adj = new ArrayList[101];
            for(int i = 0; i < 101; i++) adj[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N/2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adj[from].add(to);
            }

            bfs(new pos(start, 1));

            int maxIdx = 0;
            for(int i = 0; i < 101; i++){
                if(visited[i] == maxLv) maxIdx = Math.max(maxIdx, i);
            }
            System.out.printf("#%d %d\n", tc, maxIdx);
        }
    }

    private static void bfs(pos p) {
        Deque<pos> dq = new ArrayDeque<>();
        dq.offer(p);
        visited[p.num] = p.Lv;
        maxLv = 0;

        while(!dq.isEmpty()) {
            pos cur = dq.pollFirst();
            maxLv = Math.max(maxLv, cur.Lv);
            int size = adj[cur.num].size();

            for (int i = 0; i < size; i++) {
                int next = adj[cur.num].get(i);
                if (visited[next] == 0) {
                    dq.offer(new pos(next, cur.Lv + 1));
                    visited[next] = cur.Lv + 1;
                }
            }
        }
    }
}
