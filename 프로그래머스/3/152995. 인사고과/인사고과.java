import java.util.*;

class Person implements Comparable<Person>{
    int idx;
    int score;
    
    Person(int idx, int score) {
        this.idx = idx;
        this.score = score;
    }
    
    @Override
    public int compareTo(Person O) {
        return O.score - this.score;
    }
}

class Rank implements Comparable<Rank>{
    int idx;
    int a;
    int b;
    
    Rank(int idx, int a, int b) {
        this.idx = idx;
        this.a = a;
        this.b = b;
    }
    
    @Override
    public int compareTo(Rank O) {
        if (this.a == O.a) return this.b - O.b;
        else return O.a - this.a;
    }
}

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int n = scores.length;
        
        int stdA = scores[0][0], stdB = scores[0][1];
        boolean flag = true;

        Queue<Person> pq = new PriorityQueue<>();
        Queue<Rank> rq = new PriorityQueue<>();
        Set<Integer> exc = new HashSet<>();
        
        pq.offer(new Person(0, stdA + stdB));
        rq.offer(new Rank(0, stdA, stdB));
        
        for (int i = 1; i < n; i++) {
            int a = scores[i][0];
            int b = scores[i][1];
            int sum = a + b;
            
            if (stdA < a && stdB < b) flag = false;
                
            pq.offer(new Person(i, sum));
            rq.offer(new Rank(i, a, b));
        }
        
        // 원호가 인센티브를 받지 못하는 경우
        if (!flag) return -1;
        
        // 인센티브를 받지 못하는 직원 거르기
        Rank first = rq.poll();
        int beforeA = first.a, beforeB = first.b;
        int maxB = first.b;
        // System.out.println(first.idx + "번째 사원: " + first.a + " " + first.b);

        while(!rq.isEmpty()) {
            Rank cur = rq.poll();
            // System.out.println(cur.idx + "번째 사원: " + cur.a + " " + cur.b);
            // System.out.println(beforeA + " " + beforeB + "과 비교");
            
            if (beforeA > cur.a) beforeB = maxB;
            if (beforeB > cur.b) exc.add(cur.idx);
            
            beforeA = cur.a;
            maxB = Math.max(maxB, cur.b);
        }
        
        // 석차 매기기
        int prevScore = -1, cnt = 0;
        
        while(!pq.isEmpty()) {
            Person cur = pq.poll();
            
            // 인센티브 미지급자 제외
            if (exc.contains(cur.idx)) continue;
            
            // System.out.println(cur.idx + " " + cur.score);
            
            if (cur.score == prevScore) cnt++;
            else{
                answer += cnt;
                cnt = 1;
            }
            
            // 원호를 찾으면 종료
            if (cur.idx == 0) break;
            
            prevScore = cur.score;
        }
        
        return answer;
    }
}