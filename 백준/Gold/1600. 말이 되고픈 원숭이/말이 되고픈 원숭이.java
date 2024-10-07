import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class Main {
	static int k, w, h, res;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int[] horseX = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] horseY = {1, 2, 2, 1, -1, -2, -2, -1};
	
	static class pos {
		int x, y, hm, cnt;

		public pos(int x, int y, int hm, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.hm = hm;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		res = Integer.MAX_VALUE;
		map = new int[h][w];
		for(int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs(new pos(0, 0, k, 0));
		System.out.println((res == Integer.MAX_VALUE ? -1 : res));
	}
	
	public static void bfs(pos p) {
		boolean[][][] visited = new boolean[h][w][k+1];
		Deque<pos> dq = new ArrayDeque();
		dq.offer(p);
		visited[p.x][p.y][p.hm] = true;
		
		while(!dq.isEmpty()) {
			pos cur = dq.pollFirst();
			int x = cur.x;
			int y = cur.y;
			int hm = cur.hm;
			int cnt = cur.cnt;
			
			if(x == h-1 && y == w-1) {
				res = Math.min(res, cur.cnt);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(isInMap(nx, ny) && visited[nx][ny][hm] == false) {
					dq.offer(new pos(nx, ny, hm, cnt+1));
					visited[nx][ny][hm] = true;
				}
			}
			
			if(hm > 0) {
				for (int i = 0; i < 8; i++) {
					int nx = x + horseX[i];
					int ny = y + horseY[i];
					
					if(isInMap(nx, ny) && visited[nx][ny][hm-1] == false) {
						dq.offer(new pos(nx, ny, hm-1, cnt+1));
						visited[nx][ny][hm-1] = true;
					}
				}
			}
		}
	}
	
	public static boolean isInMap(int x, int y) {
		if ((0 <= x && x < h) && (0 <= y && y < w) && map[x][y] != 1) return true;
		return false;
	}
}