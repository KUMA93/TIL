class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int size = arr.length;
        
        answer = arr[0];
        
        for (int i = 1; i < size; i++) {
            answer = getCommonMutiple(answer, arr[i]);
        }
        
        return answer;
    }
    
    int getCommonMutiple(int x, int y) {
        int max = 1;
        int origX = x;
        int origY = y;
        
        while(x % y != 0) {
            max = x % y;
            x = y;
            y = max;
        }
        
        return origX * origY / y;
    }
}