class Solution {
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        // 동서남북
        int[] dx = new int[] {0, 0, 1, -1};
        int[] dy = new int[] {1, -1, 0, 0};
        
        int startX = 0;
        int startY = 0;
        
        // 시작 지점 찾기
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j <park[0].length(); j++) {
                if(park[i].charAt(j) == 'S'){
                    startX = i;
                    startY = j;
                }
            }
        }
        
        // 경로 이동 수행
        for (int i = 0; i < routes.length; i++) {
            int dir = -1;
            if (routes[i].charAt(0) == 'E') dir = 0;
            else if (routes[i].charAt(0) == 'W') dir = 1;
            else if (routes[i].charAt(0) == 'S') dir = 2;
            else dir = 3;
            int n = routes[i].charAt(2) - '0';
            
            int nx = startX;
            int ny = startY;
            boolean flag = true;
            
            for (int j = 0; j < n; j++) {
                nx += dx[dir];
                ny += dy[dir];
                
                if ((0 > nx || nx >= park.length) || (0 > ny || ny >= park[0].length())) {
                    flag = false;
                    break;
                }
                if (park[nx].charAt(ny) == 'X') {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                startX = nx;
                startY = ny;
                
            }
            
        }
        
        answer = new int[] {startX, startY};
        
        return answer;
    }
    
}