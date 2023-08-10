

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};

        int n = wallpaper.length;
        int m = wallpaper[0].length();

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        int maxX = -1;
        int maxY = -1;

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char now = wallpaper[i].charAt(j);
                if(now == '.') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;

                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);

                    maxX = Math.max(maxX, i+1);
                    maxY = Math.max(maxY, j+1);

                }
            }
        }

        answer = new int[]{minX, minY, maxX, maxY};

        // 맵 출력용
//        System.out.println(Arrays.toString(answer));
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        return answer;
    }
}