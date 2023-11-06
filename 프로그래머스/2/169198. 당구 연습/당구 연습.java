class Solution {
        static int x, y, sx, sy;

        static int[] dx = {-1, 0, 1, 0};
        static int[] dy = {0, 1, 0, -1};

        // 거리 제곱 계산하는 함수
        public int calculateDistance(int[] ball){
            int MIN = Integer.MAX_VALUE;
            int tx = ball[0];
            int ty = ball[1];

            for (int i = 0; i < 4; i++) {
                int nx = sx + dx[i];
                int ny = sy + dy[i];

                // 벽보다 타겟을 먼저 만나는 경우(노쿠션)
                boolean flag = false;
                while((0 <= nx && nx < x) && (0 <= ny && ny < y)){
                    if (nx == tx && ny == ty) flag = true;
                    nx += dx[i];
                    ny += dy[i];
                }

                if (flag) continue;

                int ex = 0;
                int ey = 0;
                // 원 쿠션 만족하는 상황
                if (i == 0) {
                    ex = -tx;
                    ey = ty;

                    MIN = (int) Math.min(MIN, Math.pow(ex - sx, 2) + Math.pow(ey - sy, 2));
                }else if (i == 1) {
                    ex = tx;
                    ey = ty + 2 * (y - ty);

                    MIN = (int) Math.min(MIN, Math.pow(ex - sx, 2) + Math.pow(ey - sy, 2));
                }else if (i == 2) {
                    ex = tx + 2 * (x - tx);
                    ey = ty;

                    MIN = (int) Math.min(MIN, Math.pow(ex - sx, 2) + Math.pow(ey - sy, 2));
                }else {
                    ex = tx;
                    ey = -ty;

                    MIN = (int) Math.min(MIN, Math.pow(ex - sx, 2) + Math.pow(ey - sy, 2));
                }
                
            }
            
            return MIN;
        }

        public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
            int[] answer = new int[balls.length];

            x = m;
            y = n;
            sx = startX;
            sy = startY;

            for (int i = 0; i < balls.length; i++) {
                answer[i] = calculateDistance(balls[i]);
            }

            return answer;
        }
    }
