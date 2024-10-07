import java.util.*;

class Solution {
    
    class Point implements Comparable<Point>{
        int num;
        int score;
        
        public Point(int num, int score) {
            this.num = num;
            this.score = score;
        }
        
        @Override
        public int compareTo(Point o) {
            if (this.score > o.score) return 1;
            else if(this.score == o.score) return o.num - this.num;
            else return -1;
        }
        
    }
    
    public int[] solution(int[] answers) {
        int[] answer = {};
        List<Point> res = new ArrayList<>();
        
        int one = one(answers);
        int two = two(answers);
        int three = three(answers);
        
        res.add(new Point(1, one));
        res.add(new Point(2, two));
        res.add(new Point(3, three));
        
        Collections.sort(res, Collections.reverseOrder());
        
        // for (Point x : res) {
        //     System.out.printf("%d번 수포자: %d\n", x.num, x.score);
        // }
        
        int max = res.get(0).score;
        int num = 0;
        
        for (int i = 0; i < 3; i++) {
            if (res.get(i).score == max){
                num++;
            }else break;
        }
        
        answer = new int[num];
        
        for (int i = 0; i < num; i++) {
            answer[i] = res.get(i).num;
        }
                
        return answer;
    }
    
    public static int one(int[] answer) {
        int res = 0;
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int i = 0;
        
        for (int x : answer) {
            if (x == arr[i]) res++;
            i++;
            i = i%5;
        }
        
        return res;
    }
    
    public static int two(int[] answer) {
        int res = 0;
        int[] arr = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int i = 0;
        
        for (int x : answer) {
            if (x == arr[i]) res++;
            i++;
            i = i%8;
        }
        
        return res;
    }
    
    public static int three(int[] answer) {
        int res = 0;
        int[] arr = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int i = 0;
        
        for (int x : answer) {
            if (x == arr[i]) res++;
            i++;
            i = i%10;
        }
        
        return res;
    }
}