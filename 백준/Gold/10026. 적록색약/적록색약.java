import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
	static int N, commonVal, colorWkVal;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < N; j++) {
				if (tmp.charAt(j) == 'R') map[i][j] = 0;
				else if (tmp.charAt(j) == 'G') map[i][j] = 1;
				else map[i][j] = 2;
			}
		}
		
		// 보통 사람 dfs
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if (!visited[i][j])	{
					commonVal++;
					bfs(i, j, map[i][j]);
				}
			}
		}
		
		// 색약 dfs
		// 맵의 적록을 하나로 만들어준다.
		makeColorWeakness(map);
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if (!visited[i][j])	{
					colorWkVal++;
					bfs(i, j, map[i][j]);
				}
			}
		}
		
		System.out.print(commonVal + " " + colorWkVal);
		
	}
	
	public static void bfs(int x, int y, int color) {
		Deque<int[]> dq = new ArrayDeque<>();
		int[] tmp = {x, y, color};
		dq.offer(tmp);
		visited[x][y] = true;
		
		while(!dq.isEmpty()) {
			int[] cur = dq.pollFirst();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(!isInMap(nx, ny) || visited[nx][ny]) continue;
				
				if (map[nx][ny] == cur[2]) {
					int[] next = {nx, ny, cur[2]};
					dq.offer(next);
					visited[nx][ny] = true;
				}
			}
		}
	}
	
	public static void makeColorWeakness(int[][] orig){
		 for(int i = 0; i < N; i ++) {
			 for (int j = 0; j < N; j++) {
				 if (orig[i][j] == 1) orig[i][j] = 0; 
			 }
		 }
	}
	
	public static boolean isInMap(int x, int y) {
		if ((0 <= x && x < N) && (0 <= y && y < N)) return true;
		else return false;
	}
}