import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        List<Integer> seq = make(k);
        int n = seq.size() - 1;
        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = ranges[i][1];
            
            answer[i] = getArea(a, n + b, seq);
        }
        // System.out.println(seq);
        
        return answer;
    }
    
    // 넓이 구하기
    double getArea(int start, int end, List<Integer> list) {
        double res = 0.0;
        
        if (start > end) return -1.0;
        if (start == end) return res;
        
        int s = start;
        int e = start + 1;
        
        while(e <= end) {
            int sl = list.get(s);
            int el = list.get(e);
            res += Math.abs(sl - el) * 0.5 + Math.min(sl, el);
            s++;
            e++;
        }
        
        return res;
    }
    
    // 우박 수열 만들기
    List<Integer> make(int n) {
        List<Integer> res = new ArrayList<>();
        
        while(n > 1) {
            res.add(n);
            if (n % 2 == 0) n /= 2;
            else n = 3 * n + 1;
        }
        
        res.add(n);
        
        return res;
    }
}