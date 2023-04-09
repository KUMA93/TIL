import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    /*
     * 도착하고 1분 후 아래칸으로 이동 가능
     * 계단 위에는 동시에 최대 3명
     * 이미 계단에 3명이 있다면 자리 날 때까지 대기
     * 계단의 길이가 K면 K분 소요
     * 1은 사람, 2이상 10 이하는 계단
     *
     * 방의 한 변 4 ≤ N ≤ 10
     * 1 ≤ 사람의 수 ≤ 10
     * 계단은 반드시 두개
     */

    static int TC, N, res;
    static int[][] map;
    static ArrayList<person> people;
    static ArrayList<stair> stairs;
    static Deque<person> dq;
    static PriorityQueue<person> pq;

    static class person implements Comparable<person>{
        int x, y, target, cnt;

        @Override
        public int compareTo(person o) {
            return Integer.compare(this.cnt, o.cnt);
        }

        public person(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }

    static class stair {
        int x, y, length;
        PriorityQueue<Integer> down = new PriorityQueue<>();

        public stair(int x, int y, int length) {
            super();
            this.x = x;
            this.y = y;
            this.length = length;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            people = new ArrayList<>();
            stairs = new ArrayList<>();
            res = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        people.add(new person(i, j));
                    }
                    else if (map[i][j] > 1) {
                        stairs.add(new stair(i, j, map[i][j]));
                    }
                }
            }

            // 부분집합을 통해 계단에 할당
            int P = people.size();
            for(int subset = 0; subset < (1<<P); subset++) {
                ArrayList<Integer> stair1 = new ArrayList<>();
                ArrayList<Integer> stair2 = new ArrayList<>();
                for (int i = 0; i < P; i++) {
                    if((subset & (1<<i)) != 0) {
                        stair1.add(i);
                    }
                    else {
                        stair2.add(i);
                    }
                }

                for (int i = 0, size = stair1.size(); i < size; i++) {
                    people.get(stair1.get(i)).target = 0;
                }
                for (int i = 0, size = stair2.size(); i < size; i++) {
                    people.get(stair2.get(i)).target = 1;
                }

                dq = new ArrayDeque<>();
                pq = new PriorityQueue<>();

                for (person p : people) {
                    dq.offer(p);
                }

                simulation();

            }
            System.out.printf("#%d %d\n", t, res);
        }

    }

    private static void simulation() {
        int size = dq.size();
        // 타겟까지의 거리 계산 후 pq에 넣어줌
        for (int i = 0; i < size; i++) {
            person cur = dq.pollFirst();
            int target = cur.target;
            cur.cnt = Math.abs(stairs.get(target).x - cur.x) + Math.abs(stairs.get(target).y - cur.y);
            pq.offer(cur);
        }

        ArrayList<Integer>[] time = new ArrayList[2];
        for(int i = 0; i < size; i++) {
            person now = pq.poll();
            // 3명까지 도착하는 대로 내려보냄
            if(stairs.get(now.target).down.size() < 3){
                stairs.get(now.target).down.add(now.cnt + 1 + stairs.get(now.target).length);
            }
            else{
                // now가 계단에 도착해서 대기하고 있었을 경우
                if(stairs.get(now.target).down.peek() > now.cnt)
                    stairs.get(now.target).down.add(stairs.get(now.target).down.poll() + stairs.get(now.target).length);
                // now가 계단에 도착했을 때 빈 자리가 있었을 경우
                else {
                    stairs.get(now.target).down.poll();
                    stairs.get(now.target).down.add(now.cnt + stairs.get(now.target).length + 1);
                }
            }
        }


        // 최대값 찾아주기
        int max = 0;
        for (int i = 0; i < 2; i++) {
            int qSize = stairs.get(i).down.size();

            for (int j = 0; j < qSize; j++) {
                max = Math.max(max, stairs.get(i).down.poll());
            }
        }

        res = Math.min(res, max);
    }


}