import java.util.*;

class Solution {
    // 접두어인 경우 false
    
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);
        
        for (int i = 0; i < phone_book.length - 1; i++) {
            String std = phone_book[i];
            
            if(phone_book[i+1].startsWith(std)) return false;
        }
        
        return true;
    }
}