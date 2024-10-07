import java.util.*;

class Solution {

    static List<Pass> ticketList;
    static List<String> res;
    static boolean[] visited;
    static int size;

    static class Pass implements Comparable<Pass>{
        String start;
        String end;
        int idx;
        int cnt;
        List<String> history;

        Pass(String start, String end, int idx, int cnt, List<String> history) {
            this.start = start;
            this.end = end;
            this.idx = idx;
            this.cnt = cnt;
            this.history = history;
        }

        @Override
        public int compareTo(Pass o) {
            if (this.start.equals(o.start)) {
                return this.end.compareTo(o.end);
            }
            return this.start.compareTo(o.start);
        }
    }

    public static String[] solution(String[][] tickets) {
        String[] answer = {};
        ticketList = new ArrayList<>();
        res = new ArrayList<>();

        for (int i = 0; i < tickets.length; i++){
            ticketList.add(new Pass(tickets[i][0], tickets[i][1], i, 1, new ArrayList<>()));
        }

        Collections.sort(ticketList);

        size = ticketList.size();

        int idx = 0;
        for (Pass p : ticketList) {
            p.idx = idx++;
        }

        for (Pass p : ticketList) {
            if (p.start.equals("ICN") && res.isEmpty()) {
                p.history.add("ICN");
                p.history.add(p.end);
                visited = new boolean[size];
                dfs(p);
            }
        }

        answer = new String[res.size()];

        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }


    public static void dfs(Pass p) {
        visited[p.idx] = true;

        if(p.cnt == size) {
            res = p.history;
            return;
        }

        for (Pass next : ticketList) {
            if (!next.start.equals(p.end) || visited[next.idx]) continue;
            next.history = new ArrayList<>(p.history);
            next.history.add(next.end);
            next.cnt = p.cnt + 1;
            dfs(next);
        }

        visited[p.idx] = false;
    }
    
}