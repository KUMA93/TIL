import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, TC;
	static int INF = Integer.MAX_VALUE;
	static int[][] map, visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};	
	
	static class pos {
		int x, y, val;

		public pos(int x, int y, int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			TC++;
			N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			map = new int[N][N];
			visited = new int[N][N];
			for (int[] x : visited) {
				Arrays.fill(x, INF);
			}
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited[0][0] = map[0][0];
			
			for (int p = 0; p < 4; p++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						for (int d = 0; d < 4; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							
							if (isInMap(nx, ny)) {
								visited[nx][ny] = Math.min(visited[nx][ny], map[nx][ny] + visited[i][j]);
							}
						}
						
					}
				}
			}
			
			
			System.out.printf("Problem %d: %d\n", TC, visited[N-1][N-1]);
		}
	}
	
	public static boolean isInMap(int x, int y) {
		if ((0 <= x && x < N) && (0 <= y && y < N)) return true;
		else return false;
	}
}