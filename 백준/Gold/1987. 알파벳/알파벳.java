import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, C, maxDt;
	static int[][] board;
	static boolean[] Alpha = new boolean[26];
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	
	static class Pos {
		int x;
		int y;
		int dist;
		
		public Pos(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new int[R][C];
		maxDt = 0;
		
		for (int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < C; j++) {
				board[i][j] = tmp.charAt(j)-'A';
			}
		}

		dfs(new Pos(0, 0, 1));
		System.out.println(maxDt);
	}
	
	public static void dfs(Pos p) {
		int x = p.x;
		int y = p.y;
		int dt = p.dist;
		maxDt = Math.max(maxDt, dt);
		
		Alpha[board[x][y]] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if ((nx >= 0 && nx < R) && (ny >= 0 && ny < C) ) {
				if (Alpha[board[nx][ny]]) continue;
				else{
					dfs(new Pos(nx, ny, dt+1));
				}
			}
		}
		
		Alpha[board[x][y]] = false;
	}
			
}