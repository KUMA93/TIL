import java.util.*;

class Solution {
    public String solution(String number, int k) {
//         String answer = "";
        
//         Deque<Character> dq = new ArrayDeque<>();
//         Deque<Character> tmp;
        
//         int size = number.length() - k;
        
        
//         for (int i = 0; i < number.length(); i++) {
//             char now = number.charAt(i);
//             tmp = new ArrayDeque<>();
            
//             if (dq.isEmpty()) {
//                 dq.offer(now);
//                 continue;
//             }
            
//             int cnt = 0;

//             while (!dq.isEmpty()){
//                 char last = dq.pollLast();
//                 if (last >= now && cnt <= k) {
//                     dq.offer(last);
//                     break;
//                 }else {
//                     tmp.offer(last);
//                     cnt++;
//                 }
//             }
            
//             if (cnt <= k) k -= cnt;
//             else {
//                 int num = k;
//                 for (int c = 0; c < num; c++) {
//                     tmp.pollFirst();
//                     k--;
//                 }
                
//                 while(!tmp.isEmpty()) dq.offer(tmp.pollLast());
//             }

            
//             dq.offer(now);
//             // System.out.println();
//             // System.out.println("이번 숫자: " + now + " cnt: " + cnt);
//             // System.out.println("tmp: " + tmp);
//             // System.out.println(dq + " " + k);
//         }
        
//         for (int i = 0; i < size; i++) {
//             answer += dq.pollFirst();
//         }
        
//         return answer;
        
        StringBuilder answer = new StringBuilder();
        
        Deque<Character> dq = new ArrayDeque<>();
        
        // 최종 결과 문자열의 길이를 계산
        int size = number.length() - k;
        
        for (int i = 0; i < number.length(); i++) {
            char now = number.charAt(i);
            
            // 덱에서 현재 숫자보다 작은 숫자들을 제거
            while (!dq.isEmpty() && dq.peekLast() < now && k > 0) {
                dq.pollLast();
                k--;
            }
            
            dq.offer(now); // 현재 숫자를 덱에 추가
        }
        
        // 결과 문자열을 만들기 위해 덱에서 숫자를 꺼내서 문자열에 추가
        while (!dq.isEmpty()) {
            answer.append(dq.pollFirst());
        }
        
        // 결과 문자열에서 최종 결과의 길이만큼만 잘라서 반환
        return answer.substring(0, size);
    }
}