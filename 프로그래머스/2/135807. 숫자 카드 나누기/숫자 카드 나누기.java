import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        List<Integer> divA = getDivisor(arrayA, arrayB);
        List<Integer> divB = getDivisor(arrayB, arrayA);
        
        for (int x : divA) {
            answer = Math.max(answer, x);
        }
        
        for (int x : divB) {
            answer = Math.max(answer, x);
        }
        
        return answer;
    }
    
    List<Integer> getDivisor(int[] arrA, int[] arrB) {
        
        Arrays.sort(arrA);
        List<Integer> divs = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        
        // 약수 리스트 생성
        for (int i = 2; i * i < arrA[0]; i++) {
            if (arrA[0] % i == 0) {
                divs.add(i);
                divs.add(arrA[0] / i);
            }
        }
        
        divs.add(arrA[0]);
        
        // arrA의 모든 원소를 나눌 수 있고 arrB의 모든 원소를 나눌 수 없는 약수만 남기기
        for (int div : divs) {
            if (canDivideAll(div, arrA) && cantDivideAll(div, arrB)) res.add(div);
        }
        
        return res;
    }
    
    boolean canDivideAll(int divisor, int[] arr) {
        for (int x : arr) {
            if (x % divisor != 0) return false;
        }
        return true;
    }
    
    boolean cantDivideAll(int divisor, int[] arr) {
        for (int x : arr) {
            if (x % divisor == 0) return false;
        }
        return true;
    }
}