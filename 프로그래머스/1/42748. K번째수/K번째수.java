import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int size = commands.length;
        int[] answer = new int[size];
        
        for(int n = 0; n < size; n++) {
            int i = commands[n][0];
            int j = commands[n][1];
            int k = commands[n][2];
            
            int[] tmp = new int[j-i+1];
            for (int m = 0; m < j - i + 1; m++) {
                tmp[m] = array[i + m - 1];
            }
            
            Arrays.sort(tmp);
            
            answer[n] = tmp[k-1];
        }
        
        return answer;
    }
}