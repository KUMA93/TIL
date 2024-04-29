class Solution {
    public int[] solution(int brown, int yellow) {
        
        int x = 3;
        
        while(true) {
            int y = brown / 2 - x + 2;
            
            if (x * y == brown + yellow && x >= y) return new int[]{x, y};
            
            x++;
        }
        
    }
}