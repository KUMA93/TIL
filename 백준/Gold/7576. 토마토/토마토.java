import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int M, N, maxValue;
	static int[][] board;
	static Deque<tomato> dq = new ArrayDeque<>();
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	
	
	static class tomato {
		int x;
		int y;
		int date;
		
		public tomato(int x, int y, int date) {
			super();
			this.x = x;
			this.y = y;
			this.date = date;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		maxValue = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1) dq.addLast(new tomato(i, j, 0));
			}
		}
		
		bfs();
		System.out.println(check());
		
	}
	
	public static int check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(board[i][j] == 0) return -1;
			}
		}
		return maxValue;
	}
	
	public static void bfs() {
		
		while(!dq.isEmpty()) {
			tomato cur = dq.pollFirst();
			int x = cur.x;
			int y = cur.y;
			int dt = cur.date;
			
			maxValue = Math.max(maxValue, dt);
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if ((nx >= 0 && nx < N) && (ny >= 0 && ny < M) &&
						board[nx][ny] == 0) {
					board[nx][ny] = 1;
					dq.addLast(new tomato(nx, ny, dt + 1));		
				}
			}
		}
	}
}