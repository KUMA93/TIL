class Solution {
    static int[] pm = {1, -1};
    static int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        dfs(0, numbers, target);
        
        answer = cnt;
        
        return answer;
    }
    
    public static void dfs(int lv, int[] num, int target){
        if (lv == num.length){
            int sum = 0;
            for (int x : num) {
                sum += x;
            }
            
            if (sum == target) cnt++;
            
            return;
        }
        
        for (int i = 0; i < 2; i++) {
            num[lv] *= pm[i];
            dfs(lv+1, num, target);
        }
    }
}