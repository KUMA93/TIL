import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	// 50보다 작거나 같은 자연수 N, M
	static int N, M, res;
	static char[][] map;
	static Set<int[]> water;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static class hog{
		int x, y, cnt;

		public hog(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		res = Integer.MAX_VALUE;
		map = new char[N][M];
		water = new HashSet<>();
		
		hog start = null;
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j);
				
				if (map[i][j] == '*') water.add(new int[] {i, j});
				if (map[i][j] == 'S') {
					map[i][j] = '.';
					start = new hog(i, j, 0);  
				}
			}
		}
		
		move(start);
		System.out.println(res == Integer.MAX_VALUE ? "KAKTUS" : res);
		
	}
	
	// 물 채워주기 
	public static void fillWater() {

		for (int[] cur : water) {
			int x = cur[0];
			int y = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(!isInMap(nx, ny) || map[nx][ny] == 'D' || map[nx][ny] == '*' || map[nx][ny] == 'X' ) continue;
				
				map[nx][ny] = '*';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '*') water.add(new int[] {i, j});
			}
		}
	}
	
	// 고슴도치 이동
	public static void move(hog h) {
		boolean[][] visited = new boolean[N][M];
		Deque<hog> dq = new ArrayDeque<>();
		dq.offer(h);
		visited[h.x][h.y] = true; 
		
		while(!dq.isEmpty()) {
			fillWater();
			for (int d = 0, size = dq.size(); d < size; d++) {
				hog cur = dq.pollFirst();
				int x = cur.x;
				int y = cur.y;
				int dt = cur.cnt;
				
				if(map[x][y] == 'D') {
					res = dt;
					return;
				}
				
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(!isInMap(nx, ny) || map[nx][ny] == '*' || map[nx][ny] == 'X' || visited[nx][ny]) continue;
					
					dq.offer(new hog(nx, ny, dt+1));
					visited[nx][ny] = true;
				}

			}
			
		}
		
	}
	
	public static boolean isInMap(int x, int y) {
		if ((0 <= x && x < N) && (0 <= y && y < M)) return true;
		return false;
	}
}