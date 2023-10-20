import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        List<Integer[]> answerList = new ArrayList<>();
        
        int left = 0, right = 0;
        int idx = 0, min = Integer.MAX_VALUE;
        int sum = sequence[left];
        int size = sequence.length;
                
        while(left <= right) {
            if (sum == k) answerList.add(new Integer[] {left, right});
            
            if (right < size - 1) {
                if (sum < k) sum += sequence[++right];
                else sum -= sequence[left++];
            }else {
                sum -= sequence[left++];
            }
        }
        
        Collections.sort(answerList, (o1, o2) -> {
            return (o1[1] - o1[0]) - (o2[1] - o2[0]);
        });
        
        // for (Integer[] x : answerList) {
        //     System.out.print(x[0] + " ");
        //     System.out.println(x[1]);
        // }
        
        answer = new int[] {answerList.get(0)[0], answerList.get(0)[1]};
        
        return answer;
    }
}