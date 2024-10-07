import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int[][] map = new int[9][9];
    static ArrayList<int[]> zeroList = new ArrayList<>();
    static boolean finished = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = tmp.charAt(j) - '0';
                // 빈칸 저장해주기
                if(map[i][j] == 0) zeroList.add(new int[] {i, j});
            }
        }

        fill_sudoku(0);
    }

    // 0인 칸 채워주기
    public static void fill_sudoku(int cnt){
        if(finished) return;

        // 빈칸 모두 다 채우면 출력
        if(cnt == zeroList.size()) {
            for (int[] x : map){
                for (int y : x) {
                    System.out.print(y);
                }
                System.out.println();
            }
            finished = true;
            return;
        }

        int x = zeroList.get(cnt)[0];
        int y = zeroList.get(cnt)[1];
        for(int i = 1; i <= 9; i++) {
            if(isValid(x, y, i)) {
                map[x][y] = i;
                fill_sudoku(cnt + 1);
                map[x][y] = 0;
            }
        }
    }

    // 스도쿠가 완성 됐는지 확인하기
    public static boolean isValid(int x, int y, int num) {
        // 가로세로 칸 확인
        for (int i = 0; i < 9; i++) {
            if(i != x && map[i][y] == num) return false;
            if(i != y && map[x][i] == num) return false;
        }
        // 3*3 사각형 확인
        for (int i = (x/3)*3; i < (x/3)*3 + 3; i++){
            for (int j = (y/3)*3; j < (y/3)*3 + 3; j++) {
                if(i != x && j != y && map[i][j] == num) return false;
            }
        }
        // 둘다 통과하면
        return true;
    }
}