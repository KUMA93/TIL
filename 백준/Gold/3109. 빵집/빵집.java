import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, C, cnt;
	static char[][] board;
	static int[] dx = {-1, 0, 1};
	static int[] dy = {1, 1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = tmp.charAt(j);
			}
		}
		for (int i = 0; i < R; i++) {
			checkRoot(i, 0);
		}

		System.out.println(cnt);
	}
	
	public static boolean checkRoot(int x, int y) {
		if(y == C-1) {
			cnt++;
			return true;
		}
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < R) {
				if(board[nx][ny] == 'x') continue;
				else if (board[nx][ny] == '.'){
					board[x][y] = 'x';
					if (checkRoot(nx, ny))
						return true;
				}
			}
		}
		return false;
	}
	
}