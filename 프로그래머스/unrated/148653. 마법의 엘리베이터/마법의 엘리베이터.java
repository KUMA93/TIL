class Solution {    
    
    // 1555 16 / 5 4 4 2
    // 1554  / 4 4 6 / 5 5 4
    // 15554 / 4 4 4 6 / 5 5 5 4
    public static int solution(int storey) {
        int answer = 0;

        answer = calc(storey, 0);

        return answer;
    }

    public static int calc(int storey, int sum) {

        if (storey == 0) return sum;

        int now = storey % 10;
        int res;
        
        if (storey >= 10){
            res = Math.min(calc(storey / 10, sum + now ),
                    calc(storey / 10 + 1, sum + (10 - now)));    
        }else {
            res = Math.min(calc(storey / 10, sum + now), sum + (10 - now) + 1);
        }
        

        return res;
    }
}