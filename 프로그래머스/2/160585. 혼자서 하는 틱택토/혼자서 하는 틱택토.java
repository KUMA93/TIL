class Solution {

        // 빙고 판별
        public static boolean isImpossibleGame(int[][] board, int o, int x) {
            // 돌 개수가 비정상인 경우
            if (x > o || o - x > 1) return true;

            int cnt = 0;
            int oBingo = 0;
            int xBingo = 0;

            // 가로
            for (int i = 0; i < 3; i++) {
                int oCnt = 0;
                int xCnt = 0;
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == 2) oCnt++;
                    else if (board[i][j] == 1) xCnt++;
                }
                if (oCnt == 3) {
                    oBingo++;
                    cnt++;
                }
                if (xCnt == 3) {
                    xBingo++;
                    cnt++;
                }
            }
            // 세로
            for (int i = 0; i < 3; i++) {
                int oCnt = 0;
                int xCnt = 0;
                for (int j = 0; j < 3; j++) {
                    if (board[j][i] == 2) oCnt++;
                    else if (board[j][i] == 1) xCnt++;
                }
                if (oCnt == 3) {
                    oBingo++;
                    cnt++;
                }
                if (xCnt == 3) {
                    xBingo++;
                    cnt++;
                }
            }
            // 대각선
            int oCnt = 0;
            int xCnt = 0;
            for (int i = 0; i < 3; i++) {
                // (0,0) (1,1) (2,2)
                // (0,2) (1,1) (2,0)

                if(board[i][i] == 2) oCnt++;
                else if(board[i][i] == 1) xCnt++;
            }
            if (oCnt == 3) {
                oBingo++;
                cnt++;
            }
            if (xCnt == 3) {
                xBingo++;
                cnt++;
            }

            oCnt = 0;
            xCnt = 0;
            for (int i = 0; i < 3; i++) {
                if(board[i][2-i] == 2) oCnt++;
                else if(board[i][2-i] == 1) xCnt++;
            }
            if (oCnt == 3) {
                oBingo++;
                cnt++;
            }
            if (xCnt == 3) {
                xBingo++;
                cnt++;
            }

            if (cnt > 1){
                if (oBingo == 2 && o == 5 && x == 4) return false;
                else return true;
            }else if (cnt == 1) {
                if (oBingo == 1 && o == x+1) return false;
                else if (xBingo == 1 && x == o) return false;
                else return true;
            }else return false;
        }


        public int solution(String[] board) {
            int answer = -1;

            int o = 0;
            int x = 0;
            int[][] map = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(board[i].charAt(j) == 'O') {
                        o++;
                        map[i][j] = 2;
                    }
                    else if(board[i].charAt(j) == 'X') {
                        x++;
                        map[i][j] = 1;
                    }
                }
            }

            if (isImpossibleGame(map, o, x)) answer = 0;
            else answer = 1;

            return answer;
        }
    }